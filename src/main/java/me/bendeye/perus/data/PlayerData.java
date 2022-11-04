package me.bendeye.perus.data;

import lombok.Getter;
import lombok.Setter;
import me.bendeye.perus.Perus;
import me.bendeye.perus.check.Check;
import me.bendeye.perus.data.tracker.api.Tracker;
import me.bendeye.perus.data.tracker.impl.MovementTracker;
import me.bendeye.perus.packet.Packet;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * This is our PlayerData class, as the name suggests we store data about the player here.
 * Every player should have this in order for the anticheat to function as the entire plugin is based on this.
 */
@Getter
@Setter
public final class PlayerData {

    private final Player player;
    private final UUID uuid;
    private final List<Check> checks;
    private final List<Tracker> trackers;

    private final MovementTracker movementTracker;


    public PlayerData(final Player player) {
        this.trackers = new ArrayList<>();
        this.player = player;
        this.uuid = player.getUniqueId();
        this.checks = Perus.getInstance().getCheckManager().getChecks(this);
        this.movementTracker = new MovementTracker(this);
    }

    public void handle(Packet packet) {
        trackers.forEach(tracker -> tracker.handlePreCheck(packet));
        checks.forEach(check -> check.handle(packet));
        trackers.forEach(tracker -> tracker.handlePostCheck(packet));

    }
}