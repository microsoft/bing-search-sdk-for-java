/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.bing.samples;
import com.microsoft.bing.entitysearch.models.EntityScenario;
import com.microsoft.bing.entitysearch.models.Error;
import com.microsoft.bing.entitysearch.models.ErrorResponse;
import com.microsoft.bing.entitysearch.models.ErrorResponseException;
import com.microsoft.bing.entitysearch.models.Place;
import com.microsoft.bing.entitysearch.models.SearchResponse;
import com.microsoft.bing.entitysearch.models.Thing;
import com.microsoft.bing.entitysearch.implementation.EntitySearchClientImpl;
import com.microsoft.rest.credentials.ServiceClientCredentials;
import okhttp3.*;
import okhttp3.OkHttpClient.Builder;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

/**
 * Sample code for searching entities using Bing Entiy Search, a Bing Service.
 *  - Search the entities for "Satya Nadella" and print out a short description.
 *  - Search the entities and handle disambiguation results for an ambiguous query "William Gates".
 *  - Search the entities for a single store "Microsoft Store" and print out its phone number.
 *  - Search the entities for a list of restaurants "seattle restaurants" and present their names and phone numbers.
 *  - Trigger a bad request and shows how to read the error response.
 */
public class BingEntitySearchSample {
    /**
     * Main function which runs the actual sample.
     *
     * @param client instance of the Bing Entity Search API client
     * @return true if sample runs successfully
     */
    public static boolean runSample(EntitySearchClientImpl client) {
        try {

            //=============================================================
            // This will look up a single entity "Satya Nadella" and print out a short description of it.

            SearchResponse entityData = client.entities().search("Satya Nadella");

            if (entityData.entities().value().size() > 0) {
                // find the entity that represents the dominant one
                List<Thing> entrys = entityData.entities().value();
                boolean hasDominateEntry = false;
                for (Thing thing : entrys) {
                    if (thing.entityPresentationInfo().entityScenario() == EntityScenario.DOMINANT_ENTITY) {
                        System.out.println("Searched for \"Satya Nadella\" and found a dominant entity with this description:");
                        System.out.println(thing.description());
                        System.out.println("\n");
                        hasDominateEntry = true;
                        break;
                    }
                }
                if (!hasDominateEntry) {
                    System.out.println("Couldn't find main entity Satya Nadella!");
                }
            } else {
                System.out.println("Didn't see any data..");
            }


            //=============================================================
            // This will handle disambiguation results for an ambiguous query "harry potter".

            int maxTries = 2;
            for (int i = 1; i <= 2; i++) {
                try {
                    entityData = client.entities().search("William Gates");

                    if (entityData.entities().value().size() > 0) {
                        // find the entity that represents the dominant one
                        List<Thing> entrys = entityData.entities().value();
                        boolean hasDominateEntry = false;
                        for (Thing thing : entrys) {
                            if (thing.entityPresentationInfo().entityScenario() == EntityScenario.DOMINANT_ENTITY) {
                                System.out.println("Searched for \"William Gates\" and found a dominant entity with this description:");
                                System.out.println(thing.description());
                                hasDominateEntry = true;
                                break;
                            }
                        }
                        if (!hasDominateEntry) {
                            System.out.println("Couldn't find main entity \"William Gates\"!");
                        } else {
                            List<Thing> dominateEntries = new ArrayList<>();
                            for (Thing thing : entrys) {
                                if (thing.entityPresentationInfo().entityScenario() == EntityScenario.DISAMBIGUATION_ITEM) {
                                    dominateEntries.add(thing);
                                }
                            }
                            if (dominateEntries.size() > 1) {
                                System.out.println("This query is pretty ambiguous and can be referring to multiple things. Did you mean one of these:");
                                for (Thing thing : dominateEntries) {
                                    System.out.format("\t%s (%s)\n", thing.name(), thing.entityPresentationInfo().entityTypeDisplayHint());
                                }
                            } else {
                                System.out.println("We didn't find any disambiguation items for William Gates, so we must be certain what you're talking about!");
                            }
                        }
                    } else {
                        System.out.println("Didn't see any data..");
                    }
                    System.out.println("\n");
                    break;
                } catch (ErrorResponseException e) {
                    System.out.println(
                            String.format("Exception occurred when searching for William Gates, status code %s with reason %s.", e.response().code(), e.response().message()));

                    if (e.response().code() == 429) {
                        System.out.println("You are getting a request exceeded error because you are using the free tier for this sample. Code will wait 1 second before resending request");
                    } else {
                        throw e;
                    }

                    if (i == maxTries) {
                        throw e;
                    }
                    Thread.sleep(1000);
                }
            }

            //=============================================================
            // This will look up a single restaurant "john howie bellevue" and print out its phone number.

            System.out.println("Searching for \"john howie bellevue\"");
            for (int i = 1; i <= 2; i++) {
                try {
                    entityData = client.entities().search("john howie bellevue");

                    if (entityData.places() != null && entityData.places().value().size() > 0) {
                        // Some local entities will be places, others won't be. Depending on the data you want, try to cast to the appropriate schema
                        // In this case, the item being returned is technically a Store, but the Place schema has the data we want (telephone)
                        Place store = (Place) entityData.places().value().get(0);

                        if (store != null) {
                            System.out.println("Searched for \"john howie bellevue\" and found a store with this phone number:");
                            System.out.println(store.telephone());
                        } else {
                            System.out.println("Couldn't find a place!");
                        }
                    } else {
                        System.out.println("Didn't see any data..");
                    }
                    System.out.println("/n");
                    break;
                } catch (ErrorResponseException e) {
                    System.out.println(
                            String.format("Exception occurred when searching for Microsoft Store, status code %s with reason %s.", e.response().code(), e.response().message()));

                    if (e.response().code() == 429) {
                        System.out.println("You are getting a request exceeded error because you are using the free tier for this sample. Code will wait for 1 second before resending request");
                    } else {
                        throw e;
                    }
                    if (i == maxTries) {
                        throw e;
                    }
                    Thread.sleep(1000);
                }
            }


            //=============================================================
            // This will look up a list of restaurants "seattle restaurants" and present their names and phone numbers.
            for (int i = 1; i <= 2; i++) {
                try {
                    SearchResponse restaurants = client.entities().search("seattle restaurants");

                    if (restaurants.places() != null && restaurants.places().value().size() > 0) {
                        List<Thing> listItems = new ArrayList<Thing>();
                        for (Thing place : restaurants.places().value()) {
                            if (place.entityPresentationInfo().entityScenario() == EntityScenario.LIST_ITEM) {
                                listItems.add(place);
                            }
                        }

                        if (listItems.size() > 0) {
                            StringBuilder sb = new StringBuilder();

                            for (Thing item : listItems) {
                                Place place = (Place) item;
                                if (place == null) {
                                    System.out.println(String.format("Unexpectedly found something that isn't a place named \"%s\"", item.toString()));
                                    continue;
                                }

                                sb.append(String.format(",%s (%s) ", place.name(), place.telephone()));
                            }

                            System.out.println("Ok, we found these places: ");
                            System.out.println(sb.toString().substring(1));
                        } else {
                            System.out.println("Couldn't find any relevant results for \"seattle restaurants\"");
                        }
                    } else {
                        System.out.println("Didn't see any data..");
                    }
                    System.out.println("/n");
                    break;
                } catch (ErrorResponseException e) {
                    System.out.println(
                            String.format("Exception occurred when searching for seattle restaurants, status code %s with reason %s.", e.response().code(), e.response().message()));

                    if (e.response().code() == 429) {
                        System.out.println("You are getting a request exceeded error because you are using the free tier for this sample. Code will wait for 1 second before resending request");
                    } else {
                        throw e;
                    }
                    if (i == maxTries) {
                        throw e;
                    }
                    Thread.sleep(1000);
                }
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

            // If you are going to set the BING_ENTITY_SEARCH_SUBSCRIPTION_KEY environment variable, make sure you set it for your OS, then reopen your command prompt or IDE.
            // If not, you may get an API key not found exception.
            // IMPORTANT: if you have not set the BING_ENTITY_SEARCH_SUBSCRIPTION_KEY environment variable to your Bing API key:
            // 1. comment out the below line
            final String subscriptionKey = System.getenv("BING_ENTITY_SEARCH_SUBSCRIPTION_KEY");
            // 2. add your key to your environment variables, and uncomment the line
            //final String subscriptionKey = System.getenv("BING_ENTITY_SEARCH_SUBSCRIPTION_KEY");
            //Entity search Endpoint
            String endpoint = System.getenv("BING_ENTITY_SEARCH_ENDPOINT") + "/v7.0";

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
            EntitySearchClientImpl client = new EntitySearchClientImpl(endpoint,credentials);


            runSample(client);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
