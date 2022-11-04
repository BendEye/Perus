package me.bendeye.perus.manager;

import lombok.Getter;
import me.bendeye.perus.util.ColorUtil;
import org.bukkit.configuration.file.FileConfiguration;

@Getter
public class ConfigManager {

    private final String helpmessage;


    private final String notifications;

    public ConfigManager(FileConfiguration fileConfiguration) {

        this.helpmessage = ColorUtil.format(fileConfiguration.getString("perus.messages.help"));
        this.notifications = ColorUtil.format(fileConfiguration.getString("perus.messages.notifications"));
    }

}
