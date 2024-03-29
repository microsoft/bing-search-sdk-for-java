/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.bing.websearch.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Defines an image.
 */
public class ImageObject extends MediaObject {
    /**
     * The URL to a thumbnail of the image.
     */
    @JsonProperty(value = "thumbnail", access = JsonProperty.Access.WRITE_ONLY)
    private ImageObject thumbnail;

    /**
     * Get the URL to a thumbnail of the image.
     *
     * @return the thumbnail value
     */
    public ImageObject thumbnail() {
        return this.thumbnail;
    }

}
