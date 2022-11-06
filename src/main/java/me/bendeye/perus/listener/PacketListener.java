package me.bendeye.perus.listener;

import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.injector.server.TemporaryPlayer;
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
        if (event.isCancelled()) {
            return;
        }

        if (event.getPlayer() instanceof TemporaryPlayer || event.getPlayer() == null) {
            return;
        }
        new TemporaryPlayer();
        final PlayerData data = Perus.getInstance().getDataManager().getData(event.getPlayer());
        data.handle(new Packet(event.getPacket()));
    }


    @Override
    public void onPacketSending(PacketEvent event) {
        if (event.isCancelled()) {
            return;
        }
        if (event.getPlayer() instanceof TemporaryPlayer || event.getPlayer() == null) {
            return;
        }
        new TemporaryPlayer();
        final PlayerData data = Perus.getInstance().getDataManager().getData(event.getPlayer());
            data.handle(new Packet(event.getPacket()));
    }

}
