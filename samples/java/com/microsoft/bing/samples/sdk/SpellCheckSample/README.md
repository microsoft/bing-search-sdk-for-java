---
services: bing-spell-check
platforms: java
author: milismsft
---

# Bing Spell Check Sample

This sample checks the spelling for the query "Bill Gatas" (with market and mode settings) and print outs the flagged tokens and spelling correction suggestions.

## Getting Started

### Prerequisites
- If you don't have a Microsoft Azure subscription you can visit [the Microsoft Web site](https://portal.azure.com/#create/microsoft.bingsearch or https://aka.ms/bingapisignup), create a new Azure account, and try Bing Apis.
- Get a Bing API key with which to authenticate the SDK's calls. 
- Set an environment variable named BING_SPELL_CHECK_SUBSCRIPTION_KEY with your Bing API key in the quickstart.

### Clone and run

Execute the following from a command line:
1. `git clone https://github.com/microsoft/bing-search-sdk-for-java.git`
2. `cd bing-search-sdk-for-java/samples/java/com/microsoft/bing/samples/sdk/SpellCheckSample`
1. `mvn compile exec:java cleanupDaemonThreads = false`

## More information 

- [Build and deploy Java apps on Azure](http://azure.com/java)
- [Bing Spell Check documentation](https://docs.microsoft.com/en-us/bing/search-apis/bing-spell-check/)

---

This project has adopted the [Microsoft Open Source Code of Conduct](https://opensource.microsoft.com/codeofconduct/). For more information see the [Code of Conduct FAQ](https://opensource.microsoft.com/codeofconduct/faq/) or contact [opencode@microsoft.com](mailto:opencode@microsoft.com) with any additional questions or comments.
