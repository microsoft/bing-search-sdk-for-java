---
services: bing-entity-search
platforms: java
author: milismsft
---

# Bing Entity Search SDK Sample ##

Sample code for searching entities using Bing Entity Search, a Bing Service.
- Search the entities for "Satya Nadella" and print out a short description.
- Search the entities and handle disambiguation results for an ambiguous query "William Gates".
- Search the entities for a single store "Microsoft Store" and print out its phone number.
- Search the entities for a list of restaurants "seattle restaurants" and present their names and phone numbers.
- Trigger a bad request and shows how to read the error response.


## Features

This project framework provides examples for the **Bing Entity Search SDK** for the [Entity Search API](https://api.bing.microsoft.com/v7.0/entities)

## Getting Started

### Prerequisites

- A Bing API key with which to authenticate the SDK's calls. [Create a new Azure account, and try Bing Apis.](https://portal.azure.com/#create/microsoft.bingsearch)
- Maven

### Quickstart

To get these samples running locally, simply get the pre-requisites above, then:

1. git clone https://github.com/microsoft/bing-search-sdk-for-java.git
2. cd bing-search-sdk-for-java/samples/java/com/microsoft/bing/samples/sdk/EntitySearchSample
3. Set a system environment variable named `BING_ENTITY_SEARCH_SUBSCRIPTION_KEY` and add your subscription key value. Reopen your command prompt or IDE. If not, you might get an API key not found exception.
4. set env variable `BING_ENTITY_SEARCH_ENDPOINT` to your account Endpoint.
5. mvn compile exec:java

## More information ##

[Bing Entity Search Documentation](https://docs.microsoft.com/en-us/bing/search-apis/bing-entity-search/overview)
[http://azure.com/java](http://azure.com/java)

If you don't have a Microsoft Azure subscription you can visit [the Microsoft Web site](https://portal.azure.com/#create/microsoft.bingsearch), create a new Azure account, and try Bing Search Apis.

---

This project has adopted the [Microsoft Open Source Code of Conduct](https://opensource.microsoft.com/codeofconduct/). For more information see the [Code of Conduct FAQ](https://opensource.microsoft.com/codeofconduct/faq/) or contact [opencode@microsoft.com](mailto:opencode@microsoft.com) with any additional questions or comments.
