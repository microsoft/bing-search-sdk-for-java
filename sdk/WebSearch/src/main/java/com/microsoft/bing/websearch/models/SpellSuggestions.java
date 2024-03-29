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
 * Defines a suggested query string that likely represents the user's intent.
 * The search results include this response if Bing determines that the user
 * may have intended to search for something different. For example, if the
 * user searches for alon brown, Bing may determine that the user likely
 * intended to search for Alton Brown instead (based on past searches by others
 * of Alon Brown).
 */
public class SpellSuggestions extends SearchResultsAnswer {
    /**
     * A list of suggested query strings that may represent the user's
     * intention. The list contains only one Query object.
     */
    @JsonProperty(value = "value", required = true)
    private List<Query> value;

    /**
     * Get a list of suggested query strings that may represent the user's intention. The list contains only one Query object.
     *
     * @return the value value
     */
    public List<Query> value() {
        return this.value;
    }

    /**
     * Set a list of suggested query strings that may represent the user's intention. The list contains only one Query object.
     *
     * @param value the value value to set
     * @return the SpellSuggestions object itself.
     */
    public SpellSuggestions withValue(List<Query> value) {
        this.value = value;
        return this;
    }

}
