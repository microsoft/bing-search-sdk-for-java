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
 * Defines a 2D point with X and Y coordinates.
 */
public class Point2D extends StructuredValue {
    /**
     * The x-coordinate of the point.
     */
    @JsonProperty(value = "x", required = true)
    private double x;

    /**
     * The y-coordinate of the point.
     */
    @JsonProperty(value = "y", required = true)
    private double y;

    /**
     * Get the x-coordinate of the point.
     *
     * @return the x value
     */
    public double x() {
        return this.x;
    }

    /**
     * Set the x-coordinate of the point.
     *
     * @param x the x value to set
     * @return the Point2D object itself.
     */
    public Point2D withX(double x) {
        this.x = x;
        return this;
    }

    /**
     * Get the y-coordinate of the point.
     *
     * @return the y value
     */
    public double y() {
        return this.y;
    }

    /**
     * Set the y-coordinate of the point.
     *
     * @param y the y value to set
     * @return the Point2D object itself.
     */
    public Point2D withY(double y) {
        this.y = y;
        return this;
    }

}
