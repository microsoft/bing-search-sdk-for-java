/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.bing.websearch.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Defines a webpage's metadata.
 */
public class WebMetaTag {
    /**
     * The metadata.
     */
    @JsonProperty(value = "name", access = JsonProperty.Access.WRITE_ONLY)
    private String name;

    /**
     * The name of the metadata.
     */
    @JsonProperty(value = "content", access = JsonProperty.Access.WRITE_ONLY)
    private String content;

    /**
     * Get the metadata.
     *
     * @return the name value
     */
    public String name() {
        return this.name;
    }

    /**
     * Get the name of the metadata.
     *
     * @return the content value
     */
    public String content() {
        return this.content;
    }

}
