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


    public void addPlayer(Player player) {
        playerDataMap.put(player.getUniqueId(), new PlayerData(player));
    }

    public void removePlayer(Player player) {
        playerDataMap.remove(player.getUniqueId());
    }


    public PlayerData getData(Player player) {

        Optional<PlayerData> dataOptional = Optional.ofNullable(playerDataMap.get((player.getUniqueId())));
        if(dataOptional.isPresent())
            return dataOptional.get();
        else addPlayer(player);
        return getData(player);

    }
}
