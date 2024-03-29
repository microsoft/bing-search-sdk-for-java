/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.bing.imagesearch.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The top-level object that the response includes when a trending images
 * request succeeds.
 */
public class TrendingImages extends Response {
    /**
     * A list that identifies categories of images and a list of trending
     * images in that category.
     */
    @JsonProperty(value = "categories", required = true)
    private List<TrendingImagesCategory> categories;

    /**
     * Get a list that identifies categories of images and a list of trending images in that category.
     *
     * @return the categories value
     */
    public List<TrendingImagesCategory> categories() {
        return this.categories;
    }

    /**
     * Set a list that identifies categories of images and a list of trending images in that category.
     *
     * @param categories the categories value to set
     * @return the TrendingImages object itself.
     */
    public TrendingImages withCategories(List<TrendingImagesCategory> categories) {
        this.categories = categories;
        return this;
    }

}
