/**
 * Copyright (c) 2016-2017 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.smarthome.zigbee.zcl.clusters.iaszone;

import java.util.HashMap;
import java.util.Map;

/**
 * Enumeration of IAS Zone attribute ZoneState options.
 * <p>
 * Code is auto-generated. Modifications may be overwritten!
 *
 * @author Chris Jackson
 */
public enum ZoneStateEnum {
    NOT_ENROLLED(0x0000),
    ENROLLED(0x0001);

    /**
     * A mapping between the integer code and its corresponding ZoneStateEnum type to facilitate lookup by value.
     */
    private static Map<Integer, ZoneStateEnum> idMap;

    private final int key;

    ZoneStateEnum(final int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public static ZoneStateEnum getByValue(final int value) {
        if (idMap == null) {
            idMap = new HashMap<Integer, ZoneStateEnum>();
            for (ZoneStateEnum enumValue : values()) {
                idMap.put(enumValue.key, enumValue);
            }
        }
        return idMap.get(value);
    }
}
