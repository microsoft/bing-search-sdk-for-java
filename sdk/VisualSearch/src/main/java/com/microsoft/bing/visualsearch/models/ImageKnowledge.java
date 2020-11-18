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
 * Defines a visual search API response.
 */
public class ImageKnowledge extends Response {
    /**
     * A list of visual search tags.
     */
    @JsonProperty(value = "tags", access = JsonProperty.Access.WRITE_ONLY)
    private List<ImageTag> tags;

    /**
     * Image object containing metadata about the requested image.
     */
    @JsonProperty(value = "image", access = JsonProperty.Access.WRITE_ONLY)
    private ImageObject image;

    /**
     * Get a list of visual search tags.
     *
     * @return the tags value
     */
    public List<ImageTag> tags() {
        return this.tags;
    }

    /**
     * Get image object containing metadata about the requested image.
     *
     * @return the image value
     */
    public ImageObject image() {
        return this.image;
    }

}