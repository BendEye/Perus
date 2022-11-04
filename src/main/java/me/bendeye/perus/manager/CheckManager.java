package me.bendeye.perus.manager;

import me.bendeye.perus.check.Check;
import me.bendeye.perus.check.impl.fly.FlyA;
import me.bendeye.perus.data.PlayerData;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Lindgey
 * made on me.bendeye.perus.manager
 */
public class CheckManager {

    private final List<Class<? extends Check>> checks;

    public CheckManager() {
        this.checks = Arrays.asList(
                FlyA.class
        );
    }

    public List<Check> loadToPlayer(PlayerData playerData) {
        final List<Check> checkList = new ArrayList<>();
        for(Class<? extends Check> clazz : checks) {
            try {
                checkList.add(clazz.getConstructor(PlayerData.class).newInstance(playerData));
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }

        // TODO REMOVE CHECK IF DISABLED IN CONFIG

        return checkList;
    }
}
