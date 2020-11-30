/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.bing.samples;
import com.microsoft.bing.newssearch.models.Freshness;
import com.microsoft.bing.newssearch.models.NewsArticle;
import com.microsoft.bing.newssearch.models.NewsModel;
import com.microsoft.bing.newssearch.models.NewsTopic;
import com.microsoft.bing.newssearch.models.SafeSearch;
import com.microsoft.bing.newssearch.models.TrendingTopics;
import com.microsoft.bing.newssearch.implementation.NewsSearchClientImpl;
import com.microsoft.rest.credentials.ServiceClientCredentials;
import okhttp3.*;
import okhttp3.OkHttpClient.Builder;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

/**
 * Sample code for searching news using Bing News Search, an Azure Cognitive Service.
 *  - Search the news for "Quantum  Computing" with market and count settings and print out the results.
 *  - Search the news for "Artificial Intelligence" with market, freshness and sort-by settings and print out the results.
 *  - Search the news category "Movie and TV Entertainment" with market and safe search settings and print out the results.
 *  - Search the news trending topics with market and print out the results.
 */
public class BingNewsSearchSample {
    /**
     * Main function which runs the actual sample.
     *
     * @param client instance of the Bing News Search API client
     * @return true if sample runs successfully
     */
    public static boolean runSample(NewsSearchClientImpl client) {
        try {

            //=============================================================
            // This will search news for (Quantum  Computing) with market and count parameters then verify number of
            // results and print out total estimated matches, name, url, description, published time and name of provider
            // of the first item in the list of news result list.

            System.out.println("Search news for query \"Quantum  Computing\" with market and count");
            NewsModel newsResults = client.news().search("Quantum  Computing");
            PrintNewsResult(newsResults);


            //=============================================================
            // This will search most recent news for (Artificial Intelligence) with freshness and sort-by parameters then
            //  verify number of results and print out totalEstimatedMatches, name, url, description, published time and
            //  name of provider of the first news result

            System.out.println("Search most recent news for query \"Artificial Intelligence\" with freshness and sortBy");
            (String query, String acceptLanguage, String userAgent, String clientId, String clientIp, String location, String countryCode, Integer count, Freshness freshness, String market, Integer offset, Boolean originalImage, SafeSearch safeSearch, String setLang, String sortBy, Boolean textDecorations, TextFormat textFormat)
            newsResults = client.news().search("Artificial Intelligence",market = "en-us", freshness=Freshness.WEEK, sortBy="Date");

            PrintNewsResult(newsResults);


            //=============================================================
            // This will search category news for movie and TV entertainment with safe search then verify number of results
            //  and print out category, name, url, description, published time and name of provider of the first news result

            System.out.println("Search category news");
            newsResults = client.news().category();
            PrintNewsResult(newsResults);


            //=============================================================
            // This will search news trending topics in Bing then verify number of results and print out name, text of query,
            //  webSearchUrl, newsSearchUrl and image Url of the first news result

            System.out.println("Search news trending topics in Bing");
            TrendingTopics trendingTopics = client.news().trending();
            if (trendingTopics != null) {
                if (trendingTopics.value().size() > 0) {
                    NewsTopic firstTopic = trendingTopics.value().get(0);

                    System.out.println(String.format("Trending topics count: %s", trendingTopics.value().size()));
                    System.out.println(String.format("First topic name: %s", firstTopic.name()));
                    System.out.println(String.format("First topic query: %s", firstTopic.query().text()));
                    System.out.println(String.format("First topic image url: %s", firstTopic.image().url()));
                    System.out.println(String.format("First topic webSearchUrl: %s", firstTopic.webSearchUrl()));
                    System.out.println(String.format("First topic newsSearchUrl: %s", firstTopic.newsSearchUrl()));
                } else {
                    System.out.println("Couldn't find news trending topics!");
                }
            } else {
                System.out.println("Didn't see any news trending topics..");
            }

            return true;
        } catch (Exception f) {
            System.out.println(f.getMessage());
            f.printStackTrace();
        }
        return false;
    }

    /**
     * Prints the first item in the list of news result list.
     *
     * @param newsResults the news result
     */
    public static void PrintNewsResult(NewsModel newsResults) {
        if (newsResults != null) {
            if (newsResults.value().size() > 0) {
                NewsArticle firstNewsResult = newsResults.value().get(0);

                System.out.println(String.format("TotalEstimatedMatches value: %d", newsResults.totalEstimatedMatches()));
                System.out.println(String.format("News result count: %d", newsResults.value().size()));
                System.out.println(String.format("First news name: %s", firstNewsResult.name()));
                System.out.println(String.format("First news url: %s", firstNewsResult.url()));
                System.out.println(String.format("First news description: %s", firstNewsResult.description()));
                System.out.println(String.format("First news published time: %s", firstNewsResult.datePublished()));
                System.out.println(String.format("First news provider: %s", firstNewsResult.provider().get(0).name()));
            } else {
                System.out.println("Couldn't find news results!");
            }
        } else {
            System.out.println("Didn't see any news result data..");
        }
    }

    /**
     * Main entry point.
     *
     * @param args the parameters
     */
    public static void main(String[] args) {
        try {
            //=============================================================
            // Authenticate
            // Set the BING_SEARCH_V7_SUBSCRIPTION_KEY environment variable with your subscription key, 
            // then reopen your command prompt or IDE. If not, you may get an API key not found exception.
            final String subscriptionKey = System.getenv("BING_SEARCH_V7_SUBSCRIPTION_KEY");

            // Add your Bing Search V7 endpoint to your environment variables.
            String endpoint = System.getenv("BING_SEARCH_V7_ENDPOINT") + "/bing/v7.0/news/search";
            
            ServiceClientCredentials credentials = new ServiceClientCredentials() {
                @Override
                public void applyCredentialsFilter(Builder builder) {
                    builder.addNetworkInterceptor(
                        new Interceptor() {
                            @Override
                            public Response intercept(Chain chain) throws IOException {
                                Request request = null;
                                Request original = chain.request();
                                Request.Builder requestBuilder = original.newBuilder();
                                requestBuilder.addHeader("Ocp-Apim-Subscription-Key", subscriptionKey);
                                request = requestBuilder.build();
                                return chain.proceed(request);
                            }
                        }
                    );
                }
            };
            NewsSearchClientImpl client = new NewsSearchClientImpl(endpoint,credentials);

            runSample(bingNewsSearchAPIClient);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
