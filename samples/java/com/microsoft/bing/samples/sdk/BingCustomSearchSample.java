// <imports>

package com.microsoft.bing.samples;
import com.microsoft.bing.customsearch.models.SearchResponse;
import com.microsoft.bing.customsearch.models.WebPage;
import com.microsoft.bing.customsearch.implementation.CustomSearchClientImpl;
import com.microsoft.rest.credentials.ServiceClientCredentials;
import okhttp3.*;
import okhttp3.OkHttpClient.Builder;
import java.io.IOException;
import java.util.List;
// </imports>

public class BingCustomSearchSample {

    // <runSample>
    public static boolean runSample(CustomSearchClientImpl client, String customConfigId) {
        try {
    
            // This will search for "Xbox" using Bing Custom Search 
            //and print out name and url for the first web page in the results list
    
            System.out.println("Searching for Query: \"Xbox\"");
            customConfigId = customConfigId != null ? customConfigId : "0";
            SearchResponse webData = client.customInstances().search(customConfigId,"Xbox");
    
            if (webData != null && webData.webPages() != null && webData.webPages().value().size() > 0)
            {
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
    
            return true;
        } catch (Exception f) {
            System.out.println(f.getMessage());
            f.printStackTrace();
        }
        return false;
    }
    // </runSample>
    
    // <main>
    public static void main(String[] args) {
        try {
    
            // Set the BING_CUSTOM_SEARCH_SUBSCRIPTION_KEY and AZURE_BING_SAMPLES_CUSTOM_CONFIG_ID environment variables, 
            // then reopen your command prompt or IDE. If not, you may get an API key not found exception.
            final String subscriptionKey = System.getenv("BING_CUSTOM_SEARCH_SUBSCRIPTION_KEY");
            // If you do not have a customConfigId, you can also use 1 as your value when setting your environment variable.
            final String customConfigId = System.getenv("AZURE_BING_SAMPLES_CUSTOM_CONFIG_ID");
            //Custom Search Endpoint
            String endpoint = System.getenv("BING_CUSTOM_SEARCH_ENDPOINT") +  "/v7.0/custom";
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
            CustomSearchClientImpl client = new CustomSearchClientImpl(endpoint,credentials);
            runSample(client, customConfigId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    // </main>
}