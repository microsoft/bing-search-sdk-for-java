/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.bing.entitysearch.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The MediaObject model.
 */
public class MediaObject extends CreativeWork {
    /**
     * Original URL to retrieve the source (file) for the media object (e.g the
     * source URL for the image).
     */
    @JsonProperty(value = "contentUrl", access = JsonProperty.Access.WRITE_ONLY)
    private String contentUrl;

    /**
     * URL of the page that hosts the media object.
     */
    @JsonProperty(value = "hostPageUrl", access = JsonProperty.Access.WRITE_ONLY)
    private String hostPageUrl;

    /**
     * The width of the source media object, in pixels.
     */
    @JsonProperty(value = "width", access = JsonProperty.Access.WRITE_ONLY)
    private Integer width;

    /**
     * The height of the source media object, in pixels.
     */
    @JsonProperty(value = "height", access = JsonProperty.Access.WRITE_ONLY)
    private Integer height;

    /**
     * Get original URL to retrieve the source (file) for the media object (e.g the source URL for the image).
     *
     * @return the contentUrl value
     */
    public String contentUrl() {
        return this.contentUrl;
    }

    /**
     * Get uRL of the page that hosts the media object.
     *
     * @return the hostPageUrl value
     */
    public String hostPageUrl() {
        return this.hostPageUrl;
    }

    /**
     * Get the width of the source media object, in pixels.
     *
     * @return the width value
     */
    public Integer width() {
        return this.width;
    }

    /**
     * Get the height of the source media object, in pixels.
     *
     * @return the height value
     */
    public Integer height() {
        return this.height;
    }

}
