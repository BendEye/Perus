package me.bendeye.perus.listener;

import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import me.bendeye.perus.Perus;
import me.bendeye.perus.data.PlayerData;
import me.bendeye.perus.packet.Packet;

/**
 * @author Lindgey
 * made on me.bendeye.perus.listener
 */
public class PacketListener extends PacketAdapter {

    public PacketListener() {
        super(Perus.getInstance(), Packet.getTypes());
    }

    @Override
    public void onPacketReceiving(PacketEvent event) {
        PlayerData data = Perus.getInstance().getDataManager().getData(event.getPlayer());

        if (data != null) {
            data.handle(new Packet(event.getPacket()));


        }
    }

    @Override
    public void onPacketSending(PacketEvent event) {
        PlayerData data = Perus.getInstance().getDataManager().getData(event.getPlayer());

        if (data != null) {
            data.handle(new Packet(event.getPacket()));
        }
    }
}
