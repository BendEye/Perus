package me.bendeye.perus.data.tracker.impl;

import lombok.Getter;
import me.bendeye.perus.data.PlayerData;
import me.bendeye.perus.data.tracker.api.Tracker;
import me.bendeye.perus.packet.Packet;

@Getter
public class RotationTracker extends Tracker {
    private float yaw, pitch, yawAccel, pitchAccel;
    private float lastYaw, lastPitch, lastyawAccel, lastpitchAccel;

    public RotationTracker(PlayerData data) {
        super(data);
    }
    @Override
    public void handlePreCheck(Packet packet) {
        if (packet.isRotation()) {
            final float deltaYaw = Math.abs(yaw - lastYaw);
            final float deltaPitch = Math.abs(pitch - lastPitch);
            final float deltayawAccel = Math.abs(yawAccel - lastpitchAccel);
            final float deltapitchAccel = Math.abs(pitchAccel - lastpitchAccel);
            this.lastYaw = yaw;
            this.lastPitch = pitch;


        }
    }

    @Override
    public void handlePostCheck(Packet packet) {

    }
}
