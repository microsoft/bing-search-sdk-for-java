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
 * Defines a region of an image. The region is defined by the coordinates of
 * the top, left corner and bottom, right corner of the region. The coordinates
 * are fractional values of the original image's width and height in the range
 * 0.0 through 1.0.
 */
public class NormalizedRectangle extends StructuredValue {
    /**
     * The left coordinate.
     */
    @JsonProperty(value = "left", required = true)
    private double left;

    /**
     * The top coordinate.
     */
    @JsonProperty(value = "top", required = true)
    private double top;

    /**
     * The right coordinate.
     */
    @JsonProperty(value = "right", required = true)
    private double right;

    /**
     * The bottom coordinate.
     */
    @JsonProperty(value = "bottom", required = true)
    private double bottom;

    /**
     * Get the left coordinate.
     *
     * @return the left value
     */
    public double left() {
        return this.left;
    }

    /**
     * Set the left coordinate.
     *
     * @param left the left value to set
     * @return the NormalizedRectangle object itself.
     */
    public NormalizedRectangle withLeft(double left) {
        this.left = left;
        return this;
    }

    /**
     * Get the top coordinate.
     *
     * @return the top value
     */
    public double top() {
        return this.top;
    }

    /**
     * Set the top coordinate.
     *
     * @param top the top value to set
     * @return the NormalizedRectangle object itself.
     */
    public NormalizedRectangle withTop(double top) {
        this.top = top;
        return this;
    }

    /**
     * Get the right coordinate.
     *
     * @return the right value
     */
    public double right() {
        return this.right;
    }

    /**
     * Set the right coordinate.
     *
     * @param right the right value to set
     * @return the NormalizedRectangle object itself.
     */
    public NormalizedRectangle withRight(double right) {
        this.right = right;
        return this;
    }

    /**
     * Get the bottom coordinate.
     *
     * @return the bottom value
     */
    public double bottom() {
        return this.bottom;
    }

    /**
     * Set the bottom coordinate.
     *
     * @param bottom the bottom value to set
     * @return the NormalizedRectangle object itself.
     */
    public NormalizedRectangle withBottom(double bottom) {
        this.bottom = bottom;
        return this;
    }

}
