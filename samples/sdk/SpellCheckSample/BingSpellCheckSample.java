/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.bing.samples;

import com.microsoft.bing.spellcheck.models.Mode;
import com.microsoft.bing.spellcheck.models.SpellCheck;
import com.microsoft.bing.spellcheck.models.SpellingFlaggedToken;
import com.microsoft.bing.spellcheck.models.SpellingTokenSuggestion;
import com.microsoft.bing.spellcheck.implementation.SpellCheckClientImpl;
import com.microsoft.rest.credentials.ServiceClientCredentials;
import okhttp3.*;
import okhttp3.OkHttpClient.Builder;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.List;

/**
 * Sample code for spell checking using Bing Spell Check, an Azure Cognitive Service.
 *  - Spell check "Bill Gatas" with market and mode settings and print out the flagged tokens and suggestions.
 */
public class BingSpellCheckSample {
    /**
     * Main function which runs the actual sample.
     *
     * @param client instance of the Bing Spell Check API client
     * @return true if sample runs successfully
     */
    public static boolean runSample(SpellCheckClientImpl client) {
        try {

            //=============================================================
            // This will use Bing Spell Check Cognitive Service to spell check "Bill Gatas" with market and mode
            //   parameters then verify number of results and print out flagged tokens count, token and type of the
            //   first item in the list of flagged tokens, the suggestions total count and the first suggestion in the
            //   list and its score.
            Mode proofmode = Mode.fromString("proof");
            SpellCheck result = client.spellChecker("Bill Gatas", null, null, null, null, null, null, null, null, null, null, null, "en-us", null, null,null, proofmode, null, null);

            // SpellCheck Results
            if (result.flaggedTokens().size() > 0)
            {
                // find the first spellcheck result
                SpellingFlaggedToken firstspellCheckResult = result.flaggedTokens().get(0);

                if (firstspellCheckResult != null)
                {
                    System.out.println(String.format("SpellCheck Results#%d", result.flaggedTokens().size()));
                    System.out.println(String.format("First SpellCheck Result token: %s ", firstspellCheckResult.token()));
                    System.out.println(String.format("First SpellCheck Result Type: %s ", firstspellCheckResult.type()));
                    System.out.println(String.format("First SpellCheck Result Suggestion Count: %d ",
                            firstspellCheckResult.suggestions().size()));

                    List<SpellingTokenSuggestion> suggestions = firstspellCheckResult.suggestions();
                    if (suggestions.size() > 0)
                    {
                        SpellingTokenSuggestion firstSuggestion = suggestions.get(0);
                        System.out.println(String.format("First SpellCheck Suggestion Score: %f ", firstSuggestion.score()));
                        System.out.println(String.format("First SpellCheck Suggestion : %s ", firstSuggestion.suggestion()));
                    }
                }
                else
                {
                    System.out.println("Couldn't get any Spell check results!");
                }
            }
            else
            {
                System.out.println("Didn't see any SpellCheck results..");
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
            final String subscriptionKey = System.getenv("AZURE_BING_SAMPLES_API_KEY");

            // Add your Bing Search V7 endpoint to your environment variables.
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
            SpellCheckClientImpl client = new SpellCheckClientImpl(endpoint,credentials);

            runSample(client);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}

