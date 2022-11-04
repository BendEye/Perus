package me.bendeye.perus.manager;

import me.bendeye.perus.data.PlayerData;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Lindgey
 * made on me.bendeye.perus.listener
 */
public class PlayerDataManager {

    private final List<PlayerData> playerDataList = new ArrayList<>();

    public void addOrDelete(Player player) {
        if(playerDataList.stream().anyMatch(playerData -> playerData.getPlayer().getUniqueId() == player.getUniqueId())) {
            playerDataList.remove(getData(player));

        } else {
            PlayerData playerData = new PlayerData(player);
            playerDataList.add(new PlayerData(player));

        }

    }

    public PlayerData getData(Player player) {
        Optional<PlayerData> dataOptional = playerDataList.stream().filter(playerData -> playerData.getPlayer().getUniqueId() == player.getUniqueId()).findAny();

        if(dataOptional.isPresent())
            return dataOptional.get();
        else addOrDelete(player);

        return getData(player);
    }
}
