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
 * Defines a media object.
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
     * Size of the media object content (use format "value unit" e.g "1024 B").
     */
    @JsonProperty(value = "contentSize", access = JsonProperty.Access.WRITE_ONLY)
    private String contentSize;

    /**
     * Encoding format (e.g mp3, mp4, jpeg, etc).
     */
    @JsonProperty(value = "encodingFormat", access = JsonProperty.Access.WRITE_ONLY)
    private String encodingFormat;

    /**
     * Display URL of the page that hosts the media object.
     */
    @JsonProperty(value = "hostPageDisplayUrl", access = JsonProperty.Access.WRITE_ONLY)
    private String hostPageDisplayUrl;

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
     * Get size of the media object content (use format "value unit" e.g "1024 B").
     *
     * @return the contentSize value
     */
    public String contentSize() {
        return this.contentSize;
    }

    /**
     * Get encoding format (e.g mp3, mp4, jpeg, etc).
     *
     * @return the encodingFormat value
     */
    public String encodingFormat() {
        return this.encodingFormat;
    }

    /**
     * Get display URL of the page that hosts the media object.
     *
     * @return the hostPageDisplayUrl value
     */
    public String hostPageDisplayUrl() {
        return this.hostPageDisplayUrl;
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
