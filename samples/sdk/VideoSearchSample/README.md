---
services: bing-video-search
platforms: java
author: milismsft
---

# Bing Video Search SDK Sample ##

Sample code for searching news using Bing Video Search, a Bing Service.
- Search videos for "SwiftKey" and print out id, name and url.
- Search videos for "Bellevue Trailer" that is free, short and 1080p resolution and print out id, name and url.
- Search for trending videos then verify banner tiles and categories.
- Search videos for "Bellevue Trailer" and then search for detail information of the first video.

## Features

This project framework provides examples for the **Bing Video Search SDK** for the [Video Search API](https://api.bing.microsoft.com/v7.0/videos)

## Getting Started

### Prerequisites

- A Bing API key with which to authenticate the SDK's calls. [Create a new Azure account, and try Bing Apis] (https://portal.azure.com/#create/microsoft.bingsearch or https://aka.ms/bingapisignup)
- Maven

### Quickstart

To get these samples running locally, simply get the pre-requisites above, then:

1. git clone https://github.com/microsoft/bing-search-sdk-for-java.git
2. cd bing-search-sdk-for-java/samples/java/com/microsoft/bing/samples/sdk/VideoSearchSample
3. Set a system environment variable named `BING_SEARCH_V7_SUBSCRIPTION_KEY` with your subscription key, 
   then reopen your command prompt or IDE. If not, you might get an API key not found exception.
4. set env variable `BING_SEARCH_V7_ENDPOINT` to your account Endpoint.
5. mvn compile exec:java

## More information ##
[Bing Video Search Documentation](https://docs.microsoft.com/en-us/bing/search-apis/bing-video-search/)

[http://azure.com/java](http://azure.com/java)

If you don't have a Microsoft Azure subscription you can visit [the Microsoft  Web site](https://portal.azure.com/#create/microsoft.bingsearch or https://aka.ms/bingapisignup), create a new Azure account, and try Bing Apis.

---

This project has adopted the [Microsoft Open Source Code of Conduct](https://opensource.microsoft.com/codeofconduct/). For more information see the [Code of Conduct FAQ](https://opensource.microsoft.com/codeofconduct/faq/) or contact [opencode@microsoft.com](mailto:opencode@microsoft.com) with any additional questions or comments.
