package me.bendeye.perus.check.impl.speed;

import me.bendeye.perus.check.Check;
import me.bendeye.perus.check.annotations.Testing;
import me.bendeye.perus.data.PlayerData;
import me.bendeye.perus.data.tracker.impl.MovementTracker;
import me.bendeye.perus.packet.Packet;

@Testing
public class SpeedA extends Check {

    public SpeedA(PlayerData data) {
        super(data, "Speed (A)");
    }

    @Override
    public void handle(Packet packet) {
        if (!packet.isRotation()) {

            MovementTracker data = getData().getMovementTracker();
            final float deltaYaw = getData().getMovementTracker().getYaw();

            final double deltaXZ = data.getX() + data.getZ();
            final double lastDeltaXZ = data.getLastX() + data.getLastZ();

            final double accel = Math.abs(deltaXZ - lastDeltaXZ);

            final double squareAccel = accel * 100;

            if (deltaYaw > 1.5F && deltaXZ > .15D && squareAccel < 1.0E-5) {

                flag("DY: " + deltaYaw + " accel: " + squareAccel);


            }
        }
    }
}

