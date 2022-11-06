package me.bendeye.perus.data.tracker.impl;

import lombok.Getter;
import me.bendeye.perus.data.PlayerData;
import me.bendeye.perus.data.tracker.api.Tracker;
import me.bendeye.perus.packet.Packet;
import me.bendeye.perus.util.CustomLocation;

/**
 * @author Lindgey
 * made on me.bendeye.perus.data.tracker.impl
 */

 @Getter
public class MovementTracker extends Tracker {

    private float yaw;
    private double x, y, z;
    private double lastX, lastY, lastZ;

    public MovementTracker(PlayerData data) {
        super(data);
    }

    @Override
    public void handlePreCheck(Packet packet) {
        if(packet.isFlying()) {
            lastX = x;
            lastY = y;
            lastZ = z;

            if(packet.isPosition()) {
                x = packet.getDoubles().read(0);
                y = packet.getDoubles().read(1);
                z = packet.getDoubles().read(2);
            }

        }

    }

    @Override
    public void handlePostCheck(Packet packet) {

    }
}
