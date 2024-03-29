/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.bing.visualsearch.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Defines an image action.
 */
public class ImageAction extends Action {
    /**
     * A string representing the type of action.
     */
    @JsonProperty(value = "actionType", access = JsonProperty.Access.WRITE_ONLY)
    private String actionType;

    /**
     * Get a string representing the type of action.
     *
     * @return the actionType value
     */
    public String actionType() {
        return this.actionType;
    }

}
