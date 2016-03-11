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
package de.qaware.cloud.nativ.zwitscher.board.domain;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * The ZwitscherRepository uses a load balanced RestTemplate to access the /tweets, the
 * actual invocation is wrapped into a Hystrix command.
 */
@Repository
@Slf4j
public class ZwitscherRepository {

    @Autowired
    @LoadBalanced
    private RestTemplate restTemplate;

    @Value("${board.zwitscherUrl}")
    private String tweetsRibbonUrl;

    /**
     * Find the matching Zwitscher messages for the given query.
     *
     * @param q the query, max 500 chars long
     * @return the tweets, never NULL
     */
    @HystrixCommand(fallbackMethod = "none")
    public Collection<Zwitscher> findByQ(final @Length(max = 500) String q) {
        log.info("Get Zwitscher message from /tweets using q={}.", q);

        Zwitscher[] tweets = restTemplate.getForObject(tweetsRibbonUrl, Zwitscher[].class, q);
        return Arrays.asList(tweets);
    }

    /**
     * Fallback method called by Hystrix in case of error.
     *
     * @param q the query, not used actually
     * @return empty collection
     */
    protected Collection<Zwitscher> none(final String q) {
        log.warn("Using fallback for Zwitscher messages.");
        return Collections.emptyList();
    }
}
