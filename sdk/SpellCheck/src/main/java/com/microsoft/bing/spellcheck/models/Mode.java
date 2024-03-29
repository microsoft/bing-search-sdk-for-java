/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.bing.spellcheck.models;

import java.util.Collection;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.microsoft.rest.ExpandableStringEnum;

/**
 * Defines values for Mode.
 */
public final class Mode extends ExpandableStringEnum<Mode> {
    /** Static value proof for Mode. */
    public static final Mode PROOF = fromString("proof");

    /** Static value spell for Mode. */
    public static final Mode SPELL = fromString("spell");

    /**
     * Creates or finds a Mode from its string representation.
     * @param name a name to look for
     * @return the corresponding Mode
     */
    @JsonCreator
    public static Mode fromString(String name) {
        return fromString(name, Mode.class);
    }

    /**
     * @return known Mode values
     */
    public static Collection<Mode> values() {
        return values(Mode.class);
    }
}
