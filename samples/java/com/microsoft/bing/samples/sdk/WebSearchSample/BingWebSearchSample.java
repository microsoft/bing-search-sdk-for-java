/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.bing.websearch.samples;


import com.microsoft.bing.websearch.implementation.WebSearchClientImpl;
import com.microsoft.bing.websearch.models.ImageObject;
import com.microsoft.bing.websearch.models.NewsArticle;
import com.microsoft.bing.websearch.models.SearchResponse;
import com.microsoft.bing.websearch.models.VideoObject;
import com.microsoft.bing.websearch.models.WebPage;
import com.microsoft.rest.credentials.ServiceClientCredentials;
import okhttp3.*;
import okhttp3.OkHttpClient.Builder;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
/**
 * Sample code for searching web using Bing Web Search, a Bing Service.
 *  - Search the web for "Xbox" with market and count settings and print out the name and url for first web, image, news and videos results.
 */
public class BingWebSearchSample {
    /**
     * Main function which runs the actual sample.
     *
     * @param client instance of the Bing Web Search API client
     * @return true if sample runs successfully
     */
    public static boolean runSample(WebSearchClientImpl client) {
        try {

            //=============================================================
            // This will look up a single query "Xbox" and print out name and url for first web, image, news and videos results

            System.out.println("Searched Web for \"Xbox\"");
            SearchResponse webData = client.webs().search("Xbox");

            //WebPages
            if (webData != null && webData.webPages() != null && webData.webPages().value() != null &&
                    webData.webPages().value().size() > 0) {
                // find the first web page
                WebPage firstWebPagesResult = webData.webPages().value().get(0);

                if (firstWebPagesResult != null) {
                    System.out.println(String.format("Webpage Results#%d", webData.webPages().value().size()));
                    System.out.println(String.format("First web page name: %s ", firstWebPagesResult.name()));
                    System.out.println(String.format("First web page URL: %s ", firstWebPagesResult.url()));
                } else {
                    System.out.println("Couldn't find web results!");
                }
            } else {
                System.out.println("Didn't see any Web data..");
            }

            //Images
            if (webData != null && webData.images() != null && webData.images().value() != null && webData.images().value().size() > 0) {
                // find the first image result
                ImageObject firstImageResult = webData.images().value().get(0);

                if (firstImageResult != null) {
                    System.out.println(String.format("Image Results#%d", webData.images().value().size()));
                    System.out.println(String.format("First Image result name: %s ", firstImageResult.name()));
                    System.out.println(String.format("First Image result URL: %s ", firstImageResult.contentUrl()));
                } else {
                    System.out.println("Couldn't find first image results!");
                }
            } else {
                System.out.println("Didn't see any image data..");
            }

            //News
            if (webData != null && webData.news() != null && webData.news().value() != null && webData.news().value().size() > 0) {
                // find the first news result
                NewsArticle firstNewsResult = webData.news().value().get(0);

                if (firstNewsResult != null) {
                    System.out.println(String.format("News Results#%d", webData.news().value().size()));
                    System.out.println(String.format("First news result name: %s ", firstNewsResult.name()));
                    System.out.println(String.format("First news result URL: %s ", firstNewsResult.url()));
                } else {
                    System.out.println("Couldn't find any News results!");
                }
            } else {
                System.out.println("Didn't see first news data..");
            }

            //Videos
            if (webData != null && webData.videos() != null && webData.videos().value() != null && webData.videos().value().size() > 0) {
                // find the first video result
                VideoObject firstVideoResult = webData.videos().value().get(0);

                if (firstVideoResult != null) {
                    System.out.println(String.format("Video Results#%s", webData.videos().value().size()));
                    System.out.println(String.format("First Video result name: %s ", firstVideoResult.name()));
                    System.out.println(String.format("First Video result URL: %s ", firstVideoResult.contentUrl()));
                } else {
                    System.out.println("Couldn't find first video results!");
                }
            } else {
                System.out.println("Didn't see any video data..");
            }

            return true;
        } catch (Exception f) {
            System.out.println(f.getMessage());
            f.printStackTrace();
        }
        return false;
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
            String endpoint = System.getenv("BING_SEARCH_V7_ENDPOINT") + "/v7.0";
            
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
            WebSearchClientImpl client = new WebSearchClientImpl(endpoint,credentials);


            runSample(client);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
