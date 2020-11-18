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
 * Defines a list of offers from merchants that are related to the image.
 */
public class AggregateOffer extends Offer {
    /**
     * A list of offers from merchants that have offerings related to the
     * image.
     */
    @JsonProperty(value = "offers", access = JsonProperty.Access.WRITE_ONLY)
    private List<Offer> offers;

    /**
     * Get a list of offers from merchants that have offerings related to the image.
     *
     * @return the offers value
     */
    public List<Offer> offers() {
        return this.offers;
    }

}
