/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.bing.videosearch.samples;

import com.microsoft.bing.videosearch.models.ErrorResponseException;
import com.microsoft.bing.videosearch.models.Freshness;
import com.microsoft.bing.videosearch.models.TrendingVideos;
import com.microsoft.bing.videosearch.models.TrendingVideosCategory;
import com.microsoft.bing.videosearch.models.TrendingVideosSubcategory;
import com.microsoft.bing.videosearch.models.TrendingVideosTile;
import com.microsoft.bing.videosearch.models.VideoDetails;
import com.microsoft.bing.videosearch.models.VideoInsightModule;
import com.microsoft.bing.videosearch.models.VideoLength;
import com.microsoft.bing.videosearch.models.VideoObject;
import com.microsoft.bing.videosearch.models.VideoPricing;
import com.microsoft.bing.videosearch.models.VideoResolution;
import com.microsoft.bing.videosearch.models.Videos;
import com.microsoft.bing.videosearch.implementation.VideoSearchClientImpl;
import com.microsoft.rest.credentials.ServiceClientCredentials;
import okhttp3.*;
import okhttp3.OkHttpClient.Builder;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;


/**
 * Sample code for searching news using Bing Video Search, an Bing Service.
 *  - Search videos for "SwiftKey" and print out id, name and url.
 *  - Search videos for "Bellevue Trailer" that is free, short and 1080p resolution and print out id, name and url.
 *  - Search for trending videos then verify banner tiles and categories.
 *  - Search videos for "Bellevue Trailer" and then search for detail information of the first video.
 */
public class BingVideoSearchSample {
    /**
     * Main function which runs the actual sample.
     *
     * @param client instance of the Bing Video Search API client
     * @return true if sample runs successfully
     */
    public static boolean runSample(VideoSearchClientImpl client) {
        try {

            //=============================================================
            // This will search videos for (SwiftKey) then verify number of results and print out id,
            //   name and url of the first video result.

            System.out.println("Search videos for query \"SwiftKey\"");
            Videos videoResults = client.videos().search("SwiftKey");

            printVideoResults(videoResults);


            //=============================================================
            // This will search videos for "Bellevue Trailer" that is free, short and 1080p resolution then verify
            //   number of results and print out id, name and url of the first video result.


            System.out.println("Search videos for query \"Bellevue Trailer\" that is free, short and 1080p resolution");
            
            videoResults = client.videos().search("Bellevue Trailer", null, null, null, null, null, null, null, Freshness.MONTH, null, VideoLength.SHORT, "en-us", null, VideoPricing.FREE , VideoResolution.HD1080P, null, null, null, null);

            printVideoResults(videoResults);
            

            //=============================================================
            // This will search for trending videos then verify banner tiles and categories.

            System.out.println("Search trending videos");
            TrendingVideos trendingResults = client.videos().trending();

            printTrendingResults(trendingResults);


            //=============================================================
            // This will search videos for "Bellevue Trailer" and then search for detail information of the first video.

            if (videoResults != null && videoResults.value().size() > 0)
            {
                VideoObject firstVideo = videoResults.value().get(0);
                List<VideoInsightModule> modules = new ArrayList<VideoInsightModule>();
                modules.add(VideoInsightModule.ALL);

                System.out.println(
                        String.format("Search detail for video id={firstVideo.VideoId}, name=%s", firstVideo.name()));
                int maxTries = 2;
                for (int i = 1; i <= 2; i++) {
                    try {
                        VideoDetails videoDetail = client.videos().details("Bellevue Trailer", null, null, null, null, null, null, firstVideo.videoId(),modules,"en-us",null, null, null,null,null);
                        if (videoDetail != null) {
                            if (videoDetail.videoResult() != null) {
                                System.out.println(
                                        String.format("Expected video id: %s", videoDetail.videoResult().videoId()));
                                System.out.println(
                                        String.format("Expected video name: %s", videoDetail.videoResult().name()));
                                System.out.println(
                                        String.format("Expected video url: %s", videoDetail.videoResult().contentUrl()));
                            } else {
                                System.out.println("Couldn't find expected video!");
                            }

                            if (videoDetail.relatedVideos() != null && videoDetail.relatedVideos().value() != null &&
                                    videoDetail.relatedVideos().value().size() > 0) {
                                VideoObject firstRelatedVideo = videoDetail.relatedVideos().value().get(0);
                                System.out.println(
                                        String.format("Related video count: %d", videoDetail.relatedVideos().value().size()));
                                System.out.println(
                                        String.format("First related video id: %s", firstRelatedVideo.videoId()));
                                System.out.println(
                                        String.format("First related video name: %s", firstRelatedVideo.name()));
                                System.out.println(
                                        String.format("First related video url: %s", firstRelatedVideo.contentUrl()));
                            } else {
                                System.out.println("Couldn't find any related video!");
                            }
                        } else {
                            System.out.println("Couldn't find detail about the video!");
                        }
                        break;
                    } catch (ErrorResponseException e) {
                        System.out.println(
                                String.format("Exception occurred, status code %s with reason %s.", e.response().code(), e.response().message()));

                        if (e.response().code() == 429) {
                            System.out.println("You are getting a request exceeded error because you are using the free tier for this sample. Code will wait 1 second before resending request");
                        }

                        if (i == maxTries) {
                            throw e;
                        }
                        Thread.sleep(1000);
                        System.out.println("Resending request now...");
                    }
                }
            } else {
                System.out.println("Couldn't find video results!");
            }

            return true;
        } catch (Exception f) {
            System.out.println(f.getMessage());
            f.printStackTrace();
        }
        return false;
    }

    /**
     * Print out id, name and url of the first video result.
     *
     * @param videoResults the video results
     */
    public static void printVideoResults(Videos videoResults) {
        if (videoResults != null && videoResults.value() != null) {
            if (videoResults.value().size() > 0) {
                VideoObject firstVideoResult = videoResults.value().get(0);
                System.out.println(String.format("Video result count: %d", videoResults.value().size()));
                System.out.println(String.format("First video id: %s", firstVideoResult.videoId()));
                System.out.println(String.format("First video name: %s", firstVideoResult.name()));
                System.out.println(String.format("First video url: %s", firstVideoResult.contentUrl()));
            } else {
                System.out.println("Couldn't find video results!");
            }
        } else {
            System.out.println("Didn't see any video result data..");
        }
    }

    /**
     * Print out id, name and url of the first video result.
     *
     * @param trendingResults the video results
     */
    public static void printTrendingResults(TrendingVideos trendingResults) {
        if (trendingResults != null) {
            // Banner Tiles
            if (trendingResults.bannerTiles().size() > 0) {
                TrendingVideosTile firstBannerTile = trendingResults.bannerTiles().get(0);
                System.out.println(
                        String.format("Banner tile count: {trendingResults.BannerTiles.Count}"));
                System.out.println(
                        String.format("First banner tile text: {firstBannerTile.Query.Text}"));
                System.out.println(
                        String.format("First banner tile url: {firstBannerTile.Query.WebSearchUrl}"));
            } else {
                System.out.println("Couldn't find banner tiles!");
            }

            // Categories
            if (trendingResults.categories().size() > 0) {
                TrendingVideosCategory firstCategory = trendingResults.categories().get(0);
                System.out.println(
                        String.format("Category count: %d", trendingResults.categories().size()));
                System.out.println(
                        String.format("First category title: %s", firstCategory.title()));

                if (firstCategory.subcategories().size() > 0) {
                    TrendingVideosSubcategory firstSubCategory = firstCategory.subcategories().get(0);
                    System.out.println(
                            String.format("SubCategory count: %d", firstCategory.subcategories().size()));
                    System.out.println(
                            String.format("First sub category title: %s", firstSubCategory.title()));

                    if (firstSubCategory.tiles().size() > 0) {
                        TrendingVideosTile firstTile = firstSubCategory.tiles().get(0);
                        System.out.println(
                                String.format("Tile count: %d", firstSubCategory.tiles().size()));
                        System.out.println(
                                String.format("First tile text: %s", firstTile.query().text()));
                        System.out.println(
                                String.format("First tile url: %s", firstTile.query().webSearchUrl()));
                    } else {
                        System.out.println("Couldn't find tiles!");
                    }
                } else {
                    System.out.println("Couldn't find subcategories!");
                }
            } else {
                System.out.println("Couldn't find categories!");
            }
        } else {
            System.out.println("Didn't see any trending video data..");
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
            String endpoint = System.getenv("BING_SEARCH_V7_ENDPOINT") + "/bing/v7.0/videos/search";
             
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
            VideoSearchClientImpl client = new VideoSearchClientImpl(endpoint,credentials);

            runSample(client);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
