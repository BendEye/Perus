package me.bendeye.perus.check.impl.speed;

import me.bendeye.perus.check.Check;
import me.bendeye.perus.check.annotations.Testing;
import me.bendeye.perus.data.PlayerData;
import me.bendeye.perus.data.tracker.impl.MovementTracker;
import me.bendeye.perus.packet.Packet;

@Testing
public class SpeedA extends Check {

    public SpeedA(PlayerData data) {
        super(data, "Speed (A)",10);
    }

    @Override
    public void handle(Packet packet) {
        if (packet.isBlockDig()) {
            flag("Dig packet test");
        }
    }
}



