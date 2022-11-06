package me.bendeye.perus.data.tracker.impl;

import me.bendeye.perus.data.PlayerData;
import me.bendeye.perus.data.tracker.api.Tracker;
import me.bendeye.perus.packet.Packet;

public class PacketTracker extends Tracker {


    public PacketTracker(PlayerData data) {
        super(data);
    }

    @Override
    public void handlePreCheck(Packet packet) {

    }

    @Override
    public void handlePostCheck(Packet packet) {

    }
}



