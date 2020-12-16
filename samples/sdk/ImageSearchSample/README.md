---
services: bing-image-search
platforms: java
author: aahill
---

# Java sample for the Bing Image Search SDK Quickstart ##

This code sample compliments the [Bing Image Search Quickstart](https://docs.microsoft.com/en-us/bing/search-apis/bing-image-search/quickstarts/quickstarts) available on docs.microsoft.com.

This Java application sends an image search query to the Bing Image Search API, parses the JSON response, and displays the URL of the first image returned, along with some other information.

The [Bing Image Search API](https://docs.microsoft.com/en-us/bing/search-apis/bing-image-search/) is a Bing service, available from Microsoft.  

## Getting Started

### Prerequisites

- A Bing API key with which to authenticate the SDK's calls. [Create a new  account, and try Bing Apis.](https://portal.azure.com/#create/microsoft.bingsearch)
- The latest version of the [Java Development Kit](http://www.oracle.com/technetwork/java/javase/downloads/index.html) (JDK)
- Maven

You must have a [Bing API account](https://portal.azure.com/#create/microsoft.bingsearch) with access to the Bing Search APIs. If you don't have a subscription, you can visit [the Microsoft Web site](https://portal.azure.com/#create/microsoft.bingsearch), create a new account, and try Bing Apis. Before continuing, You will need the access key provided after activating your free trial, or a paid subscription key from your dashboard.

### Quickstart

After getting the prerequisites above:
1. View the quickstart available [here]([Quickstart: Search for images using the Bing Image Search SDK and Java](https://docs.microsoft.com/en-us/bing/search-apis/bing-image-search/quickstarts/quickstart))
1. git clone https://github.com/microsoft/bing-search-sdk-for-java.git
2. cd bing-search-sdk-for-java/samples/java/com/microsoft/bing/samples/sdk/ImageSearchSample
3. Set a system environment variable named `BING_SEARCH_V7_SUBSCRIPTION_KEY` with your subscription key value, 
   then reopen your command prompt or IDE. If not, you might get an API key not found exception.
4. set env variable `BING_SEARCH_V7_ENDPOINT` to your account Endpoint.
5. mvn compile exec:java-

## More information

* [Quickstart: Search for images using the Bing Image Search SDK and Java](https://docs.microsoft.com/en-us/bing/search-apis/bing-image-search/quickstarts/quickstart)
* [Java on Azure](http://azure.com/java)
* [The Bing Image Search API](https://api.bing.microsoft.com/v7.0/images)

If you don't have a Microsoft subscription you can visit [the Microsoft Web site](https://portal.azure.com/#create/microsoft.bingsearch), create a new Azure account, and try Bing Apis.

---

This project has adopted the [Microsoft Open Source Code of Conduct](https://opensource.microsoft.com/codeofconduct/). For more information see the [Code of Conduct FAQ](https://opensource.microsoft.com/codeofconduct/faq/) or contact [opencode@microsoft.com](mailto:opencode@microsoft.com) with any additional questions or comments.
