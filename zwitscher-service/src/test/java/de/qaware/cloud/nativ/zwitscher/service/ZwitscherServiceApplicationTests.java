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
package de.qaware.cloud.nativ.zwitscher.service;

import de.qaware.cloud.nativ.zwitscher.service.quote.QuotesOnDesignClient;
import de.qaware.cloud.nativ.zwitscher.service.quote.RandomQuote;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestPropertySource("classpath:/application-test.properties")
public class ZwitscherServiceApplicationTests {

    @Configuration
    @Import(ZwitscherServiceApplication.class)
    public static class MockTwitterConfiguration {
        @Bean
        public Twitter twitter() {
            return Mockito.mock(Twitter.class);
        }

    }

    @Autowired
    @Qualifier("de.qaware.cloud.nativ.zwitscher.service.quote.QuotesOnDesignClient")
    private QuotesOnDesignClient quoteClient;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testQuotesOnDesignFeignClient() throws Exception {
        RandomQuote quote = quoteClient.getRandomQuote();
        assertThat(quote, is(notNullValue()));

        assertThat(quote.getQuote(), is(notNullValue()));
        assertThat(quote.getAuthor(), is(notNullValue()));
    }
}
