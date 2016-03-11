/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 QAware GmbH, Munich, Germany
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package de.qaware.cloud.nativ.zwitscher.board.web;

import de.qaware.cloud.nativ.zwitscher.board.domain.Quote;
import de.qaware.cloud.nativ.zwitscher.board.domain.QuoteRepository;
import de.qaware.cloud.nativ.zwitscher.board.domain.Zwitscher;
import de.qaware.cloud.nativ.zwitscher.board.domain.ZwitscherRepository;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

/**
 * The main UI controller for the Zwitscher board interface.
 */
@Controller
public class ZwitscherBoardController {

    @Autowired
    @Qualifier("de.qaware.cloud.nativ.zwitscher.board.domain.QuoteRepository")
    private QuoteRepository quoteRepository;

    @Autowired
    private ZwitscherRepository zwitscherRepository;

    @Value("${board.title}")
    private String title;

    @Value("${board.headline}")
    private String headline;

    /**
     * Renders the one and only Zwitscher board UI.
     *
     * @param viewModel the view model used to render the template
     * @return the template to use
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model viewModel) {
        populateDefault(viewModel);
        return "index";
    }

    /**
     * Called when posting the search form on the Zwitscher board.
     *
     * @param q         the query string
     * @param viewModel the view model used to render the template
     * @return the template to use
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(@RequestParam("q") @Length(max = 500) String q,
                         Model viewModel) {
        populateDefault(viewModel);
        populateTweets(q, viewModel);
        return "index";
    }

    private void populateDefault(Model viewModel) {
        viewModel.addAttribute("title", title);
        viewModel.addAttribute("headline", headline);

        Quote quote = quoteRepository.getNextQuote();
        viewModel.addAttribute("quote", quote);
    }

    private void populateTweets(String q, Model viewModel) {
        Collection<Zwitscher> tweets = zwitscherRepository.findByQ(q);
        viewModel.addAttribute("tweets", tweets);
    }
}
