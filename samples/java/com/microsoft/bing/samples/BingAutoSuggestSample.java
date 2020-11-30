/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.bing.autosuggest.samples;

import com.microsoft.bing.autosuggest;
import com.microsoft.bing.autosuggest.models.SearchAction;
import com.microsoft.bing.autosuggest.models.Suggestions;
import com.microsoft.bing.autosuggest.models.SuggestionsSuggestionGroup;
import com.microsoft.bing.autosuggest.implementation;

/**
 * Sample code for custom searching news using Bing Auto Suggest, an Azure Cognitive Service.
 *  - Search for "Satya Nadella" and print out the first group of suggestions returned from the service.
 */
public class BingAutoSuggestSample {
    /**
     * Main function which runs the actual sample.
     *
     * @param client instance of the Bing Auto Suggest API client
     * @return true if sample runs successfully
     */
    public static boolean runSample(AutoSuggestClientImpl client) {
        try {

            //=============================================================
            // This will request suggestions for "Satya Nadella" and print out the results

            System.out.println("Searched for \"Satya Nadella\" and print out the returned suggestions");

            Suggestions suggestions = client.autoSuggest("Satya Nadella");
            if (suggestions != null && suggestions.suggestionGroups() != null && suggestions.suggestionGroups().size() > 0) {
                System.out.println("Found the following suggestions:");
                for (SearchAction suggestion: suggestions.suggestionGroups().get(0).searchSuggestions()) {
                    System.out.println("....................................");
                    System.out.println(suggestion.query());
                    System.out.println(suggestion.displayText());
                    System.out.println(suggestion.url());
                    System.out.println(suggestion.searchKind());
                }
            } else {
                System.out.println("Didn't see any suggestion...");
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
            // Add your Bing Autosuggest subscription key to your environment variables.
            String subscriptionKey = System.getenv("BING_AUTOSUGGEST_SUBSCRIPTION_KEY");
            String endpoint = System.getenv("BING_AUTOSUGGEST_ENDPOINT") +  "/bing/v7.0/Suggestions";
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
            AutoSuggestClientImpl client = new AutoSuggestClientImpl(endpoint,credentials);
            runSample(client);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
