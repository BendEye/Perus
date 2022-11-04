package me.bendeye.perus.check.impl.fly;

import me.bendeye.perus.check.Check;
import me.bendeye.perus.data.PlayerData;
import me.bendeye.perus.packet.Packet;
import org.bukkit.entity.Player;

/**
 * @author Lindgey
 * made on me.bendeye.perus.check.impl.fly
 */
public class FlyA extends Check {

    public FlyA(PlayerData data) {
        super(data, "Fly (A)");
    }

    @Override
    public void handle(Packet packet) {

    }

}
