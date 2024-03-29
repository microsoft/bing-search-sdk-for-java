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
 * Defines information about a local entity, such as a restaurant or hotel.
 */
public class Place extends Thing {
    /**
     * The postal address of where the entity is located.
     */
    @JsonProperty(value = "address", access = JsonProperty.Access.WRITE_ONLY)
    private PostalAddress address;

    /**
     * The entity's telephone number.
     */
    @JsonProperty(value = "telephone", access = JsonProperty.Access.WRITE_ONLY)
    private String telephone;

    /**
     * Get the postal address of where the entity is located.
     *
     * @return the address value
     */
    public PostalAddress address() {
        return this.address;
    }

    /**
     * Get the entity's telephone number.
     *
     * @return the telephone value
     */
    public String telephone() {
        return this.telephone;
    }

}
