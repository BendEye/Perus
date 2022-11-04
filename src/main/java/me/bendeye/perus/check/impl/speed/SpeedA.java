package me.bendeye.perus.check.impl.speed;

import me.bendeye.perus.check.Check;
import me.bendeye.perus.data.PlayerData;
import org.bukkit.entity.Player;

public class SpeedA extends Check {

    public SpeedA(PlayerData data) {
        super(data, "SpeedA");
    }

    @Override
    public void handle(Player player) {
            flag();
    }

}
