---
services:  bing-visual-search
platforms: java
author: milismsft
---

# Bing Visual Search SDK Sample ##

Sample code for searching news using Bing Visual Search, a Bing Service.
- Search videos for "SwiftKey" and print out id, name and url.
- Search videos for "Bellevue Trailer" that is free, short and 1080p resolution and print out id, name and url.
- Search for trending videos then verify banner tiles and categories.
- Search videos for "Bellevue Trailer" and then search for detail information of the first video.

## Features

This project framework provides examples for the **Bing Visual Search SDK** for the [Visual Search API](https://api.bing.microsoft.com/v7.0/images/visualsearch)

## Getting Started

### Prerequisites

- A Bing API key with which to authenticate the SDK's calls. [Create a new Azure account, and try Bing Apis.](https://portal.azure.com/#create/microsoft.bingsearch or https://aka.ms/bingapisignup) BE SURE TO USE THE S9 PRICING TIER FOR THE BING SEARCH V7 API FOR VISUAL SEARCH.
- Maven

### Quickstart

To get these samples running locally, simply get the pre-requisites above, then:

1. git clone https://github.com/microsoft/bing-search-sdk-for-java.git
2. cd bing-search-sdk-for-java/samples/java/com/microsoft/bing/samples/sdk/VisualSearchSample
3. Set a system environment variable named `BING_SEARCH_V7_SUBSCRIPTION_KEY` with your subscription key,
   then reopen your command prompt or IDE. If not, you might get an API key not found exception.
4. mvn compile exec:java

## More information ##

[Bing Visual Search Documentation](https://docs.microsoft.com/en-us/bing/search-apis/bing-visual-search/)
[http://azure.com/java](http://azure.com/java)

If you don't have a Microsoft Azure subscription you can visit[the Microsoft  Web site](https://portal.azure.com/#create/microsoft.bingsearch or https://aka.ms/bingapisignup), create a new Azure account, and try Bing Apis.

---

This project has adopted the [Microsoft Open Source Code of Conduct](https://opensource.microsoft.com/codeofconduct/). For more information see the [Code of Conduct FAQ](https://opensource.microsoft.com/codeofconduct/faq/) or contact [opencode@microsoft.com](mailto:opencode@microsoft.com) with any additional questions or comments.
