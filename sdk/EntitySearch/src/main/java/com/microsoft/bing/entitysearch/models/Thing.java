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
 * The Thing model.
 */
public class Thing extends Response {
    /**
     * The name of the thing represented by this object.
     */
    @JsonProperty(value = "name", access = JsonProperty.Access.WRITE_ONLY)
    private String name;

    /**
     * The URL to get more information about the thing represented by this
     * object.
     */
    @JsonProperty(value = "url", access = JsonProperty.Access.WRITE_ONLY)
    private String url;

    /**
     * The image property.
     */
    @JsonProperty(value = "image", access = JsonProperty.Access.WRITE_ONLY)
    private ImageObject image;

    /**
     * A short description of the item.
     */
    @JsonProperty(value = "description", access = JsonProperty.Access.WRITE_ONLY)
    private String description;

    /**
     * Additional information about the entity such as hints that you can use
     * to determine the entity's type. To determine the entity's type, use the
     * entityScenario and entityTypeHint fields.
     */
    @JsonProperty(value = "entityPresentationInfo", access = JsonProperty.Access.WRITE_ONLY)
    private EntitiesEntityPresentationInfo entityPresentationInfo;

    /**
     * An ID that uniquely identifies this item.
     */
    @JsonProperty(value = "bingId", access = JsonProperty.Access.WRITE_ONLY)
    private String bingId;

    /**
     * Get the name of the thing represented by this object.
     *
     * @return the name value
     */
    public String name() {
        return this.name;
    }

    /**
     * Get the URL to get more information about the thing represented by this object.
     *
     * @return the url value
     */
    public String url() {
        return this.url;
    }

    /**
     * Get the image value.
     *
     * @return the image value
     */
    public ImageObject image() {
        return this.image;
    }

    /**
     * Get a short description of the item.
     *
     * @return the description value
     */
    public String description() {
        return this.description;
    }

    /**
     * Get additional information about the entity such as hints that you can use to determine the entity's type. To determine the entity's type, use the entityScenario and entityTypeHint fields.
     *
     * @return the entityPresentationInfo value
     */
    public EntitiesEntityPresentationInfo entityPresentationInfo() {
        return this.entityPresentationInfo;
    }

    /**
     * Get an ID that uniquely identifies this item.
     *
     * @return the bingId value
     */
    public String bingId() {
        return this.bingId;
    }

}
