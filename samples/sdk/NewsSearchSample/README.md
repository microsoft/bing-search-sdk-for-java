---
services: bing-news-search
platforms: java
author: milismsft
---

# Bing News Search SDK Sample ##

Sample code for searching news using Bing News Search, a Bing Service.
- Search the news for "Quantum  Computing" with market and count settings and print out the results.
- Search the news for "Artificial Intelligence" with market, freshness and sort-by settings and print out the results.
- Search the news category "Movie and TV Entertainment" with market and safe search settings and print out the results.
- Search the news trending topics with market and print out the results.


## Features

This project framework provides examples for the **Bing News Search SDK** for the [News Search API](https://api.bing.microsoft.com/v7.0/news)

## Getting Started

### Prerequisites

- A bing API key with which to authenticate the SDK's calls. [Create a new Azure account, and try Bing Apis.](https://portal.azure.com/#create/microsoft.bingsearch or https://aka.ms/bingapisignup)
- Maven

### Quickstart

To get these samples running locally, simply get the pre-requisites above, then:


1. git clone https://github.com/microsoft/bing-search-sdk-for-java.git
2. cd bing-search-sdk-for-java/samples/java/com/microsoft/bing/samples/sdk/NewsSearchSample
3. Set a system environment variable named `BING_SEARCH_V7_SUBSCRIPTION_KEY` with your subscription key,
   then reopen your command prompt or IDE. If not, you might get an API key not found exception.
4. set env variable `BING_SEARCH_V7_ENDPOINT` to your account Endpoint.
5. mvn compile exec:java

## More information ##
[Bing News Search API Documentation](https://docs.microsoft.com/en-us/bing/search-apis/bing-news-search/)

[http://azure.com/java](http://azure.com/java)

If you don't have a Microsoft Azure subscription you can visit [the Microsoft Web site](https://portal.azure.com/#create/microsoft.bingsearch or https://aka.ms/bingapisignup), create a new Azure account, and try Bing Apis.

---

This project has adopted the [Microsoft Open Source Code of Conduct](https://opensource.microsoft.com/codeofconduct/). For more information see the [Code of Conduct FAQ](https://opensource.microsoft.com/codeofconduct/faq/) or contact [opencode@microsoft.com](mailto:opencode@microsoft.com) with any additional questions or comments.
