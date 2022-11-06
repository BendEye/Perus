package me.bendeye.perus.check.impl.speed;

import me.bendeye.perus.check.Check;
import me.bendeye.perus.check.annotations.Testing;
import me.bendeye.perus.data.PlayerData;
import me.bendeye.perus.data.tracker.impl.MovementTracker;
import me.bendeye.perus.data.tracker.impl.RotationTracker;
import me.bendeye.perus.packet.Packet;

@Testing
public class SpeedA extends Check {

    public SpeedA(PlayerData data) {
        super(data, "Speed (A)");
    }

    @Override
    public void handle(Packet packet) {
        if (!packet.isRotation()) {
            final MovementTracker movementTracker = getData().getMovementTracker();
            final RotationTracker rotationData = getData().getRotationTracker();
            final float deltaYaw = rotationData.getYaw();

            final double deltaXZ = movementTracker.getHorizontalDist();
            final double lastDeltaXZ = movementTracker.getLastHorizontalDist();

            final double accel = Math.abs(deltaXZ - lastDeltaXZ);

            final double squareAccel = accel * 100;

            if (deltaYaw > 1.5F && deltaXZ > .15D && squareAccel < 1.0E-5) {

                flag("DY: " + deltaYaw + " accel: " + squareAccel);


            }
        }
    }
}

