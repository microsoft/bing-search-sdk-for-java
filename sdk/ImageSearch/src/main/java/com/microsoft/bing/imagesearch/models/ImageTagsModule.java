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
 * Defines the characteristics of content found in an image.
 */
public class ImageTagsModule {
    /**
     * A list of tags that describe the characteristics of the content found in
     * the image. For example, if the image is of a musical artist, the list
     * might include Female, Dress, and Music to indicate the person is female
     * music artist that's wearing a dress.
     */
    @JsonProperty(value = "value", required = true)
    private List<InsightsTag> value;

    /**
     * Get a list of tags that describe the characteristics of the content found in the image. For example, if the image is of a musical artist, the list might include Female, Dress, and Music to indicate the person is female music artist that's wearing a dress.
     *
     * @return the value value
     */
    public List<InsightsTag> value() {
        return this.value;
    }

    /**
     * Set a list of tags that describe the characteristics of the content found in the image. For example, if the image is of a musical artist, the list might include Female, Dress, and Music to indicate the person is female music artist that's wearing a dress.
     *
     * @param value the value value to set
     * @return the ImageTagsModule object itself.
     */
    public ImageTagsModule withValue(List<InsightsTag> value) {
        this.value = value;
        return this;
    }

}
