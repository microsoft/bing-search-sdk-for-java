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
 * Defines a recognized entity.
 */
public class RecognizedEntity extends Response {
    /**
     * The entity that was recognized. The following are the possible entity
     * objects: Person.
     */
    @JsonProperty(value = "entity", access = JsonProperty.Access.WRITE_ONLY)
    private Thing entity;

    /**
     * The confidence that Bing has that the entity in the image matches this
     * entity. The confidence ranges from 0.0 through 1.0 with 1.0 being very
     * confident.
     */
    @JsonProperty(value = "matchConfidence", access = JsonProperty.Access.WRITE_ONLY)
    private Double matchConfidence;

    /**
     * Get the entity that was recognized. The following are the possible entity objects: Person.
     *
     * @return the entity value
     */
    public Thing entity() {
        return this.entity;
    }

    /**
     * Get the confidence that Bing has that the entity in the image matches this entity. The confidence ranges from 0.0 through 1.0 with 1.0 being very confident.
     *
     * @return the matchConfidence value
     */
    public Double matchConfidence() {
        return this.matchConfidence;
    }

}
