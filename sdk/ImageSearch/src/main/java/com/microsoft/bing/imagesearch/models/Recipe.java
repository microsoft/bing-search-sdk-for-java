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
 * Defines a cooking recipe.
 */
public class Recipe extends CreativeWork {
    /**
     * The amount of time the food takes to cook. For example, PT25M. For
     * information about the time format, see
     * http://en.wikipedia.org/wiki/ISO_8601#Durations.
     */
    @JsonProperty(value = "cookTime", access = JsonProperty.Access.WRITE_ONLY)
    private String cookTime;

    /**
     * The amount of time required to prepare the ingredients. For example,
     * PT15M. For information about the time format, see
     * http://en.wikipedia.org/wiki/ISO_8601#Durations.
     */
    @JsonProperty(value = "prepTime", access = JsonProperty.Access.WRITE_ONLY)
    private String prepTime;

    /**
     * The total amount of time it takes to prepare and cook the recipe. For
     * example, PT45M. For information about the time format, see
     * http://en.wikipedia.org/wiki/ISO_8601#Durations.
     */
    @JsonProperty(value = "totalTime", access = JsonProperty.Access.WRITE_ONLY)
    private String totalTime;

    /**
     * Get the amount of time the food takes to cook. For example, PT25M. For information about the time format, see http://en.wikipedia.org/wiki/ISO_8601#Durations.
     *
     * @return the cookTime value
     */
    public String cookTime() {
        return this.cookTime;
    }

    /**
     * Get the amount of time required to prepare the ingredients. For example, PT15M. For information about the time format, see http://en.wikipedia.org/wiki/ISO_8601#Durations.
     *
     * @return the prepTime value
     */
    public String prepTime() {
        return this.prepTime;
    }

    /**
     * Get the total amount of time it takes to prepare and cook the recipe. For example, PT45M. For information about the time format, see http://en.wikipedia.org/wiki/ISO_8601#Durations.
     *
     * @return the totalTime value
     */
    public String totalTime() {
        return this.totalTime;
    }

}
