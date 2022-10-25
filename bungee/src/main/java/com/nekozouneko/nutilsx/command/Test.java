package com.nekozouneko.nutilsx.command;

import com.nekozouneko.nutilsx.Util;
import com.nekozouneko.nutilsx.packet.ByteBufIO;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Test extends Command {

    public Test() {
        super("test", null);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!Util.isPlayer(sender)) {
            return;
        }

        ProxiedPlayer player = (ProxiedPlayer) sender;

        try {
            ByteBuf buf = ByteBufAllocator.DEFAULT.heapBuffer();

            ByteBufIO.writeString("Nekozouneko Server", buf);

            player.sendData("minecraft:brand", ByteBufIO.toArray(buf));
            buf.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
