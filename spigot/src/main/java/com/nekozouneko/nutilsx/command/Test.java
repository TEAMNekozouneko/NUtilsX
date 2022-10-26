package com.nekozouneko.nutilsx.command;

import com.nekozouneko.nutilsx.NUtilsXSpigot;
import com.nekozouneko.nutilsx.Util;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Test implements CommandExecutor, TabCompleter {

    private NUtilsXSpigot plugin = NUtilsXSpigot.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!Util.isPlayer(sender)) {
            return true;
        }

        Player player = (Player) sender;


        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            DataOutputStream os = new DataOutputStream(bos);

            os.writeUTF("Nekozouneko Server");

            player.sendPluginMessage(plugin, "minecraft:brand", bos.toByteArray());

        } catch (IOException io) {
            io.printStackTrace();
        }


        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        return new ArrayList<>();
    }

}
