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
 * Defines the top-level object that the response includes when the request
 * succeeds.
 */
public class SearchResponse extends Response {
    /**
     * An object that contains the query string that Bing used for the request.
     * This object contains the query string as entered by the user. It may
     * also contain an altered query string that Bing used for the query if the
     * query string contained a spelling mistake.
     */
    @JsonProperty(value = "queryContext", access = JsonProperty.Access.WRITE_ONLY)
    private QueryContext queryContext;

    /**
     * A list of entities that are relevant to the search query.
     */
    @JsonProperty(value = "entities", access = JsonProperty.Access.WRITE_ONLY)
    private Entities entities;

    /**
     * A list of local entities such as restaurants or hotels that are relevant
     * to the query.
     */
    @JsonProperty(value = "places", access = JsonProperty.Access.WRITE_ONLY)
    private Places places;

    /**
     * Get an object that contains the query string that Bing used for the request. This object contains the query string as entered by the user. It may also contain an altered query string that Bing used for the query if the query string contained a spelling mistake.
     *
     * @return the queryContext value
     */
    public QueryContext queryContext() {
        return this.queryContext;
    }

    /**
     * Get a list of entities that are relevant to the search query.
     *
     * @return the entities value
     */
    public Entities entities() {
        return this.entities;
    }

    /**
     * Get a list of local entities such as restaurants or hotels that are relevant to the query.
     *
     * @return the places value
     */
    public Places places() {
        return this.places;
    }

}
