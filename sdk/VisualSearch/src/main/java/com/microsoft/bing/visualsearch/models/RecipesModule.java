/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.bing.visualsearch.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Defines a list of recipes.
 */
public class RecipesModule {
    /**
     * A list of recipes.
     */
    @JsonProperty(value = "value", access = JsonProperty.Access.WRITE_ONLY)
    private List<Recipe> value;

    /**
     * Get a list of recipes.
     *
     * @return the value value
     */
    public List<Recipe> value() {
        return this.value;
    }

}
