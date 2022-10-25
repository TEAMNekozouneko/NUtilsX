package com.nekozouneko.nutilsx;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import org.bukkit.entity.Player;

public class Util {

    private Util() {
        throw new UnsupportedOperationException("Constructor is disabled");
    }

    public static boolean isPlayer(org.bukkit.command.CommandSender sender) {
        if (sender instanceof Player) {
            return true;
        }
        return false;
    }

    public static boolean isPlayer(net.md_5.bungee.api.CommandSender sender) {
        if (sender instanceof ProxiedPlayer) {
            return true;
        }
        return false;
    }

}
