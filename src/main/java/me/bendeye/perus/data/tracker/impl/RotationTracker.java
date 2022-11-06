package me.bendeye.perus.data.tracker.impl;

import lombok.Getter;
import me.bendeye.perus.data.PlayerData;
import me.bendeye.perus.data.tracker.api.Tracker;
import me.bendeye.perus.packet.Packet;

@Getter
public class RotationTracker extends Tracker {

    private float yaw, pitch, yawAccel, pitchAccel, deltaYaw, lastDeltaYaw;
    private float lastYaw, lastPitch, lastYawAccel, lastPitchAccel, deltaPitch , lastDeltaPitch;

    public RotationTracker(PlayerData data) {
        super(data);
    }
    @Override
    public void handlePreCheck(Packet packet) {
        if (packet.isFlying()) {
            lastYaw = yaw;
            lastPitch = pitch;

            lastDeltaYaw = deltaYaw;
            lastDeltaPitch = deltaPitch;

            lastYawAccel = yawAccel;
            lastPitchAccel = pitchAccel;

            if(packet.isRotation()) {
                yaw = packet.getFloat().read(0);
                pitch = packet.getFloat().read(1);

                deltaYaw = Math.abs(yaw - lastYaw) % 360F;
                deltaPitch = pitch - lastPitch;

                yawAccel = Math.abs(deltaYaw - lastDeltaYaw);
                pitchAccel = Math.abs(deltaPitch - lastDeltaPitch);
            } else {
                deltaYaw = deltaPitch = 0;
            }





        }
    }

    @Override
    public void handlePostCheck(Packet packet) {

    }
}
