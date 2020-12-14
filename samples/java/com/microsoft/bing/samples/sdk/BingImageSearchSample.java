/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.bing.samples;
import com.microsoft.bing.imagesearch.models.ImageObject;
import com.microsoft.bing.imagesearch.models.Images;
import com.microsoft.bing.imagesearch.implementation.ImageSearchClientImpl;
import com.microsoft.rest.credentials.ServiceClientCredentials;
import okhttp3.*;
import okhttp3.OkHttpClient.Builder;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

/**
 * Sample code for searching images using Bing Image Search, a Bing Service.
 *  - Searches images for "canadian rockies" then outputs the result.
 */
public class BingImageSearchSample {
    /**
     * Main function which runs the actual sample.
     *
     * @param client instance of the Bing News Search API client
     * @param searchTerm a term to use in the image search request
     * @return true if sample runs successfully
     */
    public static void runSample(ImageSearchClientImpl client, String searchTerm) {
        try {

            //=============================================================
            // This will search images for "canadian rockies" then print the first image result,

            System.out.println(String.format("Search images for query %s", searchTerm));

            Images imageResults = client.images().search(searchTerm);

            if (imageResults != null && imageResults.value().size() > 0) {
                // Image results
                ImageObject firstImageResult = imageResults.value().get(0);

                System.out.println(String.format("Image result count: %d", imageResults.value().size()));
                System.out.println(String.format("First image insights token: %s", firstImageResult.imageInsightsToken()));
                System.out.println(String.format("First image thumbnail url: %s", firstImageResult.thumbnailUrl()));
                System.out.println(String.format("First image content url: %s", firstImageResult.contentUrl()));
            }
            else {
                    System.out.println("Couldn't find any image results!");
                }
            }
        catch (Exception f) {
            System.out.println(f.getMessage());
            f.printStackTrace();
        }
    }

    /**
     * Main entry point.
     *
     * @param args the parameters
     */
    public static void main(String[] args) {
        try {
            // Authenticate
            // Set the BING_SEARCH_V7_SUBSCRIPTION_KEY environment variable, 
            // then reopen your command prompt or IDE for changes to take effect.
            final String subscriptionKey = System.getenv("BING_SEARCH_V7_SUBSCRIPTION_KEY");
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
            ImageSearchClientImpl client = new ImageSearchClientImpl(endpoint,credentials);
            String searchTerm = "canadian rockies";
            runSample(client, searchTerm);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
