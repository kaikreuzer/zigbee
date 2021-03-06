/**
 * Copyright (c) 2016-2017 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.smarthome.zigbee.zcl.clusters.thermostat;

import org.eclipse.smarthome.zigbee.zcl.ZclCommand;
import org.eclipse.smarthome.zigbee.zcl.ZclFieldDeserializer;
import org.eclipse.smarthome.zigbee.zcl.ZclFieldSerializer;
import org.eclipse.smarthome.zigbee.zcl.protocol.ZclCommandDirection;
import org.eclipse.smarthome.zigbee.zcl.protocol.ZclDataType;

/**
 * Setpoint Raise/Lower Command value object class.
 * <p>
 * Cluster: <b>Thermostat</b>. Command is sent <b>TO</b> the server.
 * This command is a <b>specific</b> command used for the Thermostat cluster.
 * <p>
 * Code is auto-generated. Modifications may be overwritten!
 */
public class SetpointRaiseLowerCommand extends ZclCommand {
    /**
     * Mode command message field.
     */
    private Integer mode;

    /**
     * Amount command message field.
     */
    private Integer amount;

    /**
     * Default constructor.
     */
    public SetpointRaiseLowerCommand() {
        genericCommand = false;
        clusterId = 513;
        commandId = 0;
        commandDirection = ZclCommandDirection.CLIENT_TO_SERVER;
    }

    /**
     * Gets Mode.
     *
     * @return the Mode
     */
    public Integer getMode() {
        return mode;
    }

    /**
     * Sets Mode.
     *
     * @param mode the Mode
     */
    public void setMode(final Integer mode) {
        this.mode = mode;
    }

    /**
     * Gets Amount.
     *
     * @return the Amount
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * Sets Amount.
     *
     * @param amount the Amount
     */
    public void setAmount(final Integer amount) {
        this.amount = amount;
    }

    @Override
    public void serialize(final ZclFieldSerializer serializer) {
        serializer.serialize(mode, ZclDataType.ENUMERATION_8_BIT);
        serializer.serialize(amount, ZclDataType.SIGNED_8_BIT_INTEGER);
    }

    @Override
    public void deserialize(final ZclFieldDeserializer deserializer) {
        mode = (Integer) deserializer.deserialize(ZclDataType.ENUMERATION_8_BIT);
        amount = (Integer) deserializer.deserialize(ZclDataType.SIGNED_8_BIT_INTEGER);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(78);
        builder.append("SetpointRaiseLowerCommand [");
        builder.append(super.toString());
        builder.append(", mode=");
        builder.append(mode);
        builder.append(", amount=");
        builder.append(amount);
        builder.append(']');
        return builder.toString();
    }

}
