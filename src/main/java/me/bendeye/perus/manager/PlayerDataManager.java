package me.bendeye.perus.manager;

import com.comphenix.protocol.injector.server.TemporaryPlayer;
import me.bendeye.perus.data.PlayerData;
import org.bukkit.entity.Player;

import java.util.*;

/**
 * @author Lindgey
 * made on me.bendeye.perus.listener
 */
public class PlayerDataManager {

    private final Map<UUID, PlayerData> playerDataMap = new HashMap<>();

    //private final List<PlayerData> playerDataList = new ArrayList<>();




    public void addPlayer(Player player) {
        if (player instanceof TemporaryPlayer || player == null) {
            System.out.println("Player has disconnected or was kicked before fully joining!");
        } else playerDataMap.put(player.getUniqueId(), new PlayerData(player));

    }

    public void removePlayer(Player player) {
        if (player instanceof TemporaryPlayer || player == null) {
            System.out.println("Player has disconnected or was kicked before fully joining!");
        } else playerDataMap.remove(player.getUniqueId());
    }


    public PlayerData getData(Player player) {

        Optional<PlayerData> dataOptional = Optional.ofNullable(playerDataMap.get((player.getUniqueId())));
        if (player instanceof TemporaryPlayer) {
            System.out.println("Player has disconnected or was kicked before fully joining!");
            return null;
        } else if(dataOptional.isPresent())
            return dataOptional.get();
        else addPlayer(player);

            return getData(player);

    }
}
