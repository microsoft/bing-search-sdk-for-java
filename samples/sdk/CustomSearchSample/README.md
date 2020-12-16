---
services: bing-custom-search
platforms: java
author: milismsft
---

# Bing Custom Search SDK Sample ##

Sample code for custom searching using Bing Custom Search, a Bing Service.
- Custom search for "Xbox" and print out name and url for the first web page in the results list.


## Features

This project framework provides examples for the **Bing Custom Search SDK** for the [Custom Search API](https://api.bing.microsoft.com/v7.0/custom)

## Getting Started

### Prerequisites

- A Bing API key with which to authenticate the SDK's calls. [Create a new account, and try Bing custom Apis.](https://portal.azure.com/#create/microsoft.bingcustomsearch)
- Maven

### Quickstart

To get these samples running locally, simply get the pre-requisites above, then:

1. git clone https://github.com/microsoft/bing-search-sdk-for-java.git
2. cd bing-search-sdk-for-java/samples/java/com/microsoft/bing/samples/sdk/CustomSearchSample
3. set env variable BING_CUSTOM_SEARCH_SUBSCRIPTION_KEY to your account API key.
4. set env variable BING_SAMPLES_CUSTOM_CONFIG_ID to your custom configuration id. Can set to 1 if you do not have a custom config id.
5. set env variable `BING_CUSTOM_SEARCH_ENDPOINT` to your account Endpoint.
6. mvn compile exec:java

## More information ##
[Bing Custom Search Documentation](https://docs.microsoft.com/en-us/bing/search-apis/bing-custom-search/overview)

[Custom Search using the Bing Custom Search SDK and Java](https://github.com/microsoft/bing-search-sdk-for-java)
[http://azure.com/java](http://azure.com/java)

If you don't have a Microsoft Azure subscription you can visit [the Microsoft Web site](https://portal.azure.com/#create/microsoft.bingcustomsearch), create a new Azure account, and try Bing Custom Search.

---

This project has adopted the [Microsoft Open Source Code of Conduct](https://opensource.microsoft.com/codeofconduct/). For more information see the [Code of Conduct FAQ](https://opensource.microsoft.com/codeofconduct/faq/) or contact [opencode@microsoft.com](mailto:opencode@microsoft.com) with any additional questions or comments.
