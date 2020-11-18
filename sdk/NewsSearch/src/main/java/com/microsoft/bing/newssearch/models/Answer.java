/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.bing.newssearch.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Defines an answer.
 */
public class Answer extends Response {
    /**
     * The followUpQueries property.
     */
    @JsonProperty(value = "followUpQueries", access = JsonProperty.Access.WRITE_ONLY)
    private List<Query> followUpQueries;

    /**
     * Get the followUpQueries value.
     *
     * @return the followUpQueries value
     */
    public List<Query> followUpQueries() {
        return this.followUpQueries;
    }

}
