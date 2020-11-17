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
 * Defines an image's caption.
 */
public class ImageInsightsImageCaption {
    /**
     * A caption about the image.
     */
    @JsonProperty(value = "caption", required = true)
    private String caption;

    /**
     * The URL to the website where the caption was found. You must attribute
     * the caption to the source. For example, by displaying the domain name
     * from the URL next to the caption and using the URL to link to the source
     * website.
     */
    @JsonProperty(value = "dataSourceUrl", required = true)
    private String dataSourceUrl;

    /**
     * A list of entities found in the caption. Use the contents of the Query
     * object to find the entity in the caption and create a link. The link
     * takes the user to images of the entity.
     */
    @JsonProperty(value = "relatedSearches", required = true)
    private List<Query> relatedSearches;

    /**
     * Get a caption about the image.
     *
     * @return the caption value
     */
    public String caption() {
        return this.caption;
    }

    /**
     * Set a caption about the image.
     *
     * @param caption the caption value to set
     * @return the ImageInsightsImageCaption object itself.
     */
    public ImageInsightsImageCaption withCaption(String caption) {
        this.caption = caption;
        return this;
    }

    /**
     * Get the URL to the website where the caption was found. You must attribute the caption to the source. For example, by displaying the domain name from the URL next to the caption and using the URL to link to the source website.
     *
     * @return the dataSourceUrl value
     */
    public String dataSourceUrl() {
        return this.dataSourceUrl;
    }

    /**
     * Set the URL to the website where the caption was found. You must attribute the caption to the source. For example, by displaying the domain name from the URL next to the caption and using the URL to link to the source website.
     *
     * @param dataSourceUrl the dataSourceUrl value to set
     * @return the ImageInsightsImageCaption object itself.
     */
    public ImageInsightsImageCaption withDataSourceUrl(String dataSourceUrl) {
        this.dataSourceUrl = dataSourceUrl;
        return this;
    }

    /**
     * Get a list of entities found in the caption. Use the contents of the Query object to find the entity in the caption and create a link. The link takes the user to images of the entity.
     *
     * @return the relatedSearches value
     */
    public List<Query> relatedSearches() {
        return this.relatedSearches;
    }

    /**
     * Set a list of entities found in the caption. Use the contents of the Query object to find the entity in the caption and create a link. The link takes the user to images of the entity.
     *
     * @param relatedSearches the relatedSearches value to set
     * @return the ImageInsightsImageCaption object itself.
     */
    public ImageInsightsImageCaption withRelatedSearches(List<Query> relatedSearches) {
        this.relatedSearches = relatedSearches;
        return this;
    }

}
