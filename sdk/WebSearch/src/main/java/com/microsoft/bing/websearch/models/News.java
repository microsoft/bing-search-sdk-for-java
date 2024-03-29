/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.bing.websearch.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Defines a news answer.
 */
public class News extends SearchResultsAnswer {
    /**
     * An array of NewsArticle objects that contain information about news
     * articles that are relevant to the query. If there are no results to
     * return for the request, the array is empty.
     */
    @JsonProperty(value = "value", required = true)
    private List<NewsArticle> value;

    /**
     * The location property.
     */
    @JsonProperty(value = "location", access = JsonProperty.Access.WRITE_ONLY)
    private String location;

    /**
     * Get an array of NewsArticle objects that contain information about news articles that are relevant to the query. If there are no results to return for the request, the array is empty.
     *
     * @return the value value
     */
    public List<NewsArticle> value() {
        return this.value;
    }

    /**
     * Set an array of NewsArticle objects that contain information about news articles that are relevant to the query. If there are no results to return for the request, the array is empty.
     *
     * @param value the value value to set
     * @return the News object itself.
     */
    public News withValue(List<NewsArticle> value) {
        this.value = value;
        return this;
    }

    /**
     * Get the location value.
     *
     * @return the location value
     */
    public String location() {
        return this.location;
    }

}
