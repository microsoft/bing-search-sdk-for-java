/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.bing.autosuggest.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The top-level response that represents a failed request.
 */
public class ErrorResponse extends Response {
    /**
     * A list of errors that describe the reasons why the request failed.
     */
    @JsonProperty(value = "errors", required = true)
    private List<Error> errors;

    /**
     * Get a list of errors that describe the reasons why the request failed.
     *
     * @return the errors value
     */
    public List<Error> errors() {
        return this.errors;
    }

    /**
     * Set a list of errors that describe the reasons why the request failed.
     *
     * @param errors the errors value to set
     * @return the ErrorResponse object itself.
     */
    public ErrorResponse withErrors(List<Error> errors) {
        this.errors = errors;
        return this;
    }

}
