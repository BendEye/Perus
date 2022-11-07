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
    private CustomLocation location, lastLocation;
    private double x, y, z;
    private double lastX, lastY, lastZ;
    private double distX, distY, distZ, horizontalDist;
    private double lastDistX, lastDistY, lastDistZ, lastHorizontalDist;

    public MovementTracker(PlayerData data) {
        super(data);
        getData().getPlayer().getLocation();
        this.location = this.lastLocation = new CustomLocation(getData().getPlayer().getLocation());
    }

    @Override
    public void handlePreCheck(Packet packet) {
        if(packet.isFlying()) {
            lastX = x;
            lastY = y;
            lastZ = z;


            lastDistX = distX;
            lastDistY = distY;
            lastDistZ = distZ;

            lastHorizontalDist = horizontalDist;

            if(packet.isPosition()) {
                x = packet.getDoubles().read(0);
                y = packet.getDoubles().read(1);
                z = packet.getDoubles().read(2);


                horizontalDist = Math.hypot(distX, distZ);
            } else {
                distX = distY = distZ = 0;
            }

        }

    }

    @Override
    public void handlePostCheck(Packet packet) {

    }
}
