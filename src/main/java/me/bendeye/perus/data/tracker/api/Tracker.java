package me.bendeye.perus.data.tracker.api;

import lombok.Getter;
import me.bendeye.perus.data.PlayerData;
import me.bendeye.perus.packet.Packet;

/**
 * @author Lindgey
 * made on me.bendeye.perus.data.tracker.api
 */

@Getter
public abstract class Tracker {

    private final PlayerData data;

    public Tracker(PlayerData data) {
        this.data = data;
        data.getTrackers().add(this);
    }

    public abstract void handlePreCheck(Packet packet);

    public abstract void handlePostCheck(Packet packet);
}
