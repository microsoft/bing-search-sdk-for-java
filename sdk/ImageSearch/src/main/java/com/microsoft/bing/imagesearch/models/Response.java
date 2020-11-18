/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.bing.imagesearch.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Defines a response. All schemas that could be returned at the root of a
 * response should inherit from this.
 */
public class Response extends Identifiable {
    /**
     * The URL that returns this resource.
     */
    @JsonProperty(value = "readLink", access = JsonProperty.Access.WRITE_ONLY)
    private String readLink;

    /**
     * The URL To Bing's search result for this item.
     */
    @JsonProperty(value = "webSearchUrl", access = JsonProperty.Access.WRITE_ONLY)
    private String webSearchUrl;

    /**
     * Get the URL that returns this resource.
     *
     * @return the readLink value
     */
    public String readLink() {
        return this.readLink;
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
