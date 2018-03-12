/**
 * Copyright (c) 2016-2017 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.smarthome.zigbee.zdo.command;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.eclipse.smarthome.zigbee.CommandTest;
import org.eclipse.smarthome.zigbee.ZigBeeEndpointAddress;
import org.eclipse.smarthome.zigbee.serialization.DefaultSerializer;
import org.eclipse.smarthome.zigbee.zcl.ZclFieldSerializer;
import org.junit.Test;

/**
 *
 * @author Chris Jackson
 *
 */
public class ManagementPermitJoiningRequestTest extends CommandTest {

    @Test
    public void testReceive() {
        // Short response - ie not extended
        int[] packet = getPacketData("00 FF 01");

        ManagementPermitJoiningRequest request = new ManagementPermitJoiningRequest();
        request.setDestinationAddress(new ZigBeeEndpointAddress(0));
        request.setTcSignificance(true);
        request.setPermitDuration(255);

        DefaultSerializer serializer = new DefaultSerializer();
        ZclFieldSerializer fieldSerializer = new ZclFieldSerializer(serializer);

        request.serialize(fieldSerializer);
        assertTrue(Arrays.equals(packet, serializer.getPayload()));
    }
}