package me.bendeye.perus.manager;

import lombok.Getter;
import me.bendeye.perus.util.ColorUtil;
import org.bukkit.configuration.file.FileConfiguration;

@Getter
public class ConfigManager {

    private final String helpmessage;
    private final String toggledonalerts;

    private final String untoggledonalerts;

    public ConfigManager(FileConfiguration fileConfiguration) {

        this.helpmessage = ColorUtil.format(fileConfiguration.getString("perus.messages.help"));
        this.toggledonalerts = ColorUtil.format(fileConfiguration.getString("perus.messages.alerts.toggled"));
        this.untoggledonalerts = ColorUtil.format(fileConfiguration.getString("perus.messages.alerts.untoggled"));
    }

}
