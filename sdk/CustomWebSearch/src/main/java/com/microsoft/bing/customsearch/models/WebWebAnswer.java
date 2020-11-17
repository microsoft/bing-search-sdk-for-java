/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.bing.customsearch.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Defines a list of relevant webpage links.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "_type", defaultImpl = WebWebAnswer.class)
@JsonTypeName("Web/WebAnswer")
public class WebWebAnswer extends SearchResultsAnswer {
    /**
     * A list of webpages that are relevant to the query.
     */
    @JsonProperty(value = "value", required = true)
    private List<WebPage> value;

    /**
     * A Boolean value that indicates whether the response excluded some
     * results from the answer. If Bing excluded some results, the value is
     * true.
     */
    @JsonProperty(value = "someResultsRemoved", access = JsonProperty.Access.WRITE_ONLY)
    private Boolean someResultsRemoved;

    /**
     * Get a list of webpages that are relevant to the query.
     *
     * @return the value value
     */
    public List<WebPage> value() {
        return this.value;
    }

    /**
     * Set a list of webpages that are relevant to the query.
     *
     * @param value the value value to set
     * @return the WebWebAnswer object itself.
     */
    public WebWebAnswer withValue(List<WebPage> value) {
        this.value = value;
        return this;
    }

    /**
     * Get a Boolean value that indicates whether the response excluded some results from the answer. If Bing excluded some results, the value is true.
     *
     * @return the someResultsRemoved value
     */
    public Boolean someResultsRemoved() {
        return this.someResultsRemoved;
    }

}
