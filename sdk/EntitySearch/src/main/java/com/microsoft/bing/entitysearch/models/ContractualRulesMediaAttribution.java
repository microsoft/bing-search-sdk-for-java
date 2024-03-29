/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.bing.entitysearch.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Defines a contractual rule for media attribution.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "_type", defaultImpl = ContractualRulesMediaAttribution.class)
@JsonTypeName("ContractualRules/MediaAttribution")
public class ContractualRulesMediaAttribution extends ContractualRulesAttribution {
    /**
     * The URL that you use to create of hyperlink of the media content. For
     * example, if the target is an image, you would use the URL to make the
     * image clickable.
     */
    @JsonProperty(value = "url", access = JsonProperty.Access.WRITE_ONLY)
    private String url;

    /**
     * Get the URL that you use to create of hyperlink of the media content. For example, if the target is an image, you would use the URL to make the image clickable.
     *
     * @return the url value
     */
    public String url() {
        return this.url;
    }

}
