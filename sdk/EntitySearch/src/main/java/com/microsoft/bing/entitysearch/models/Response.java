/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.bing.entitysearch.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Defines a response. All schemas that could be returned at the root of a
 * response should inherit from this.
 */
public class Response extends Identifiable {
    /**
     * A list of rules that you must adhere to if you display the item.
     */
    @JsonProperty(value = "contractualRules", access = JsonProperty.Access.WRITE_ONLY)
    private List<ContractualRulesContractualRule> contractualRules;

    /**
     * The URL To Bing's search result for this item.
     */
    @JsonProperty(value = "webSearchUrl", access = JsonProperty.Access.WRITE_ONLY)
    private String webSearchUrl;

    /**
     * Get a list of rules that you must adhere to if you display the item.
     *
     * @return the contractualRules value
     */
    public List<ContractualRulesContractualRule> contractualRules() {
        return this.contractualRules;
    }

    /**
     * Get the URL To Bing's search result for this item.
     *
     * @return the webSearchUrl value
     */
    public String webSearchUrl() {
        return this.webSearchUrl;
    }

}