package me.bendeye.perus.manager;

import me.bendeye.perus.check.Check;
import me.bendeye.perus.check.impl.fly.FlyA;
import me.bendeye.perus.check.impl.speed.SpeedA;
import me.bendeye.perus.data.PlayerData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Lindgey
 * made on me.bendeye.perus.manager
 */
public class CheckManager {

    public List<Check> getChecks(PlayerData data) {
        List<Check> list = Arrays.asList(
                new SpeedA(data),
                new FlyA(data)
        );

        return list;
    }
}
