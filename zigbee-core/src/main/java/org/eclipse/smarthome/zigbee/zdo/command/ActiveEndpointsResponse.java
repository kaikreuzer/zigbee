/**
 * Copyright (c) 2016-2017 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.smarthome.zigbee.zdo.command;

import java.util.List;

import org.eclipse.smarthome.zigbee.zcl.ZclFieldDeserializer;
import org.eclipse.smarthome.zigbee.zcl.ZclFieldSerializer;
import org.eclipse.smarthome.zigbee.zcl.protocol.ZclDataType;
import org.eclipse.smarthome.zigbee.zdo.ZdoResponse;
import org.eclipse.smarthome.zigbee.zdo.ZdoStatus;

import java.util.ArrayList;

/**
 * Active Endpoints Response value object class.
 * <p>
 * The Active_EP_rsp is generated by a remote device in response to an
 * Active_EP_req directed to the remote device. This command shall be unicast to
 * the originator of the Active_EP_req command.
 * <p>
 * Code is auto-generated. Modifications may be overwritten!
 */
public class ActiveEndpointsResponse extends ZdoResponse {
    /**
     * NWKAddrOfInterest command message field.
     */
    private Integer nwkAddrOfInterest;

    /**
     * ActiveEPList command message field.
     */
    private List<Integer> activeEpList;

    /**
     * Default constructor.
     */
    public ActiveEndpointsResponse() {
        clusterId = 0x8005;
    }

    /**
     * Gets NWKAddrOfInterest.
     *
     * @return the NWKAddrOfInterest
     */
    public Integer getNwkAddrOfInterest() {
        return nwkAddrOfInterest;
    }

    /**
     * Sets NWKAddrOfInterest.
     *
     * @param nwkAddrOfInterest the NWKAddrOfInterest
     */
    public void setNwkAddrOfInterest(final Integer nwkAddrOfInterest) {
        this.nwkAddrOfInterest = nwkAddrOfInterest;
    }

    /**
     * Gets ActiveEPList.
     *
     * @return the ActiveEPList
     */
    public List<Integer> getActiveEpList() {
        return activeEpList;
    }

    /**
     * Sets ActiveEPList.
     *
     * @param activeEpList the ActiveEPList
     */
    public void setActiveEpList(final List<Integer> activeEpList) {
        this.activeEpList = activeEpList;
    }

    @Override
    public void serialize(final ZclFieldSerializer serializer) {
        super.serialize(serializer);

        serializer.serialize(status, ZclDataType.ZDO_STATUS);
        serializer.serialize(nwkAddrOfInterest, ZclDataType.NWK_ADDRESS);
        serializer.serialize(activeEpList.size(), ZclDataType.UNSIGNED_8_BIT_INTEGER);
        for (int cnt = 0; cnt < activeEpList.size(); cnt++) {
            serializer.serialize(activeEpList.get(cnt), ZclDataType.ENDPOINT);
        }
    }

    @Override
    public void deserialize(final ZclFieldDeserializer deserializer) {
        super.deserialize(deserializer);

        // Create lists
        activeEpList = new ArrayList<Integer>();

        status = (ZdoStatus) deserializer.deserialize(ZclDataType.ZDO_STATUS);
        if (status != ZdoStatus.SUCCESS) {
            // Don't read the full response if we have an error
            return;
        }
        nwkAddrOfInterest = (Integer) deserializer.deserialize(ZclDataType.NWK_ADDRESS);
        Integer activeEpCnt = (Integer) deserializer.deserialize(ZclDataType.UNSIGNED_8_BIT_INTEGER);
        if (activeEpCnt != null) {
            for (int cnt = 0; cnt < activeEpCnt; cnt++) {
                activeEpList.add((Integer) deserializer.deserialize(ZclDataType.ENDPOINT));
            }
        }
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(152);
        builder.append("ActiveEndpointsResponse [");
        builder.append(super.toString());
        builder.append(", status=");
        builder.append(status);
        builder.append(", nwkAddrOfInterest=");
        builder.append(nwkAddrOfInterest);
        builder.append(", activeEpList=");
        builder.append(activeEpList);
        builder.append(']');
        return builder.toString();
    }

}