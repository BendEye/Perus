package me.bendeye.perus.listener;

import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.injector.server.TemporaryPlayer;
import me.bendeye.perus.Perus;
import me.bendeye.perus.data.PlayerData;
import me.bendeye.perus.packet.Packet;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;

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
        if (event.isPlayerTemporary()) {
            return;
        }

        PlayerData data = Perus.getInstance().getDataManager().getData((event.getPlayer()).getPlayer());
        data.handle(new Packet(event.getPacket()));
    }


    @Override
    public void onPacketSending(PacketEvent event) {
        if (event.isPlayerTemporary()) {
            return;
        }

        final PlayerData data = Perus.getInstance().getDataManager().getData(event.getPlayer());
            data.handle(new Packet(event.getPacket()));
    }

}
