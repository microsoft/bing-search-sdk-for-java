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
 * Defines a link to a webpage that contains a collection of related images.
 */
public class ImageGallery extends CollectionPage {
    /**
     * The publisher or social network where the images were found. You must
     * attribute the publisher as the source where the collection was found.
     */
    @JsonProperty(value = "source", access = JsonProperty.Access.WRITE_ONLY)
    private String source;

    /**
     * The number of related images found in the collection.
     */
    @JsonProperty(value = "imagesCount", access = JsonProperty.Access.WRITE_ONLY)
    private Long imagesCount;

    /**
     * The number of users on the social network that follow the creator.
     */
    @JsonProperty(value = "followersCount", access = JsonProperty.Access.WRITE_ONLY)
    private Long followersCount;

    /**
     * Get the publisher or social network where the images were found. You must attribute the publisher as the source where the collection was found.
     *
     * @return the source value
     */
    public String source() {
        return this.source;
    }

    /**
     * Get the number of related images found in the collection.
     *
     * @return the imagesCount value
     */
    public Long imagesCount() {
        return this.imagesCount;
    }

    /**
     * Get the number of users on the social network that follow the creator.
     *
     * @return the followersCount value
     */
    public Long followersCount() {
        return this.followersCount;
    }

}
