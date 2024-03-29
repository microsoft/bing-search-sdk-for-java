/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.bing.visualsearch.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Defines an recipe action.
 */
public class ImageRecipesAction extends ImageAction {
    /**
     * A list of recipes related to the image.
     */
    @JsonProperty(value = "data", access = JsonProperty.Access.WRITE_ONLY)
    private RecipesModule data;

    /**
     * Get a list of recipes related to the image.
     *
     * @return the data value
     */
    public RecipesModule data() {
        return this.data;
    }

}
