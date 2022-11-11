package com.nekozouneko.nutilsx.command;

import com.mojang.brigadier.tree.LiteralCommandNode;
import com.nekozouneko.nutilsx.NUtilsXSpigot;
import static com.nekozouneko.nutilsx.Util.*;

import com.nekozouneko.nutilsx.language.Translator;
import com.nekozouneko.nutilsx.message.SpigotMessageSender;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import me.lucko.commodore.file.CommodoreFileReader;
import org.bukkit.plugin.Plugin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @todo  2022/11/08 ゲームモードフル実装したい
 */
public class GameModeCommand implements CommandExecutor , TabCompleter {

    NUtilsXSpigot plugin = NUtilsXSpigot.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(Translator.gen("ja_jp", "nutilsx.lang.common.error.show-usage", Translator.gen("ja", "nutilsx.lang.command.gamemode.usage")));
            return true;
        }

        if (sender instanceof Player) {
            Player p = (Player) sender;
            SpigotMessageSender sms = new SpigotMessageSender(p, p.getLocale());

            if (args.length == 1) {
                p.setGameMode(toGameMode(args[0]));
                sms.sendMessageWithPrefix(
                        Translator.gen(
                                p.getLocale(), "nutilsx.lang.command.gamemode.self", Translator.gen(p.getLocale(),
                                "nutilsx.lang.common.gamemode." + toGameMode(args[0]).name().toLowerCase())
                        )
                );
                return true;
            } else if (args.length >= 2) {
                Player t = plugin.getServer().getPlayer(args[1]);
                if (t == null) {
                    sender.sendMessage(Translator.gen(p.getLocale(), "nutilsx.lang.common.error.player-not-found"));
                    return true;
                }

                t.setGameMode(toGameMode(args[0]));
                t.sendMessage();
            }
        }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        final List<String> tab = new ArrayList<>();
        final List<String> arg1tab = Arrays.asList("a", "adventure", "c", "creative", "s", "sp", "spectator", "survival");
        if (args.length == 1) {
            for (String g:arg1tab) {
                if (startsWithIgnoreCase(g, args[0])) {
                    tab.add(g);
                }
            }
        } else if (args.length == 2) {
            List<String> pL = new ArrayList<>();
            plugin.getServer().getOnlinePlayers().forEach(p -> pL.add(p.getName()));

            for (String p:pL) {
                if (startsWithIgnoreCase(p, args[1])) {
                    tab.add(p);
                }
            }
        }

        return tab;
    }

    public static void registerBrigadier(Plugin plugin, Command cmd) {
        try {
            LiteralCommandNode<?> GameModeCommand = CommodoreFileReader.INSTANCE.parse(plugin.getResource("gamemode.commodore"));
            NUtilsXSpigot.getCommodore().register(cmd, GameModeCommand);
        } catch (IOException ignored) {}
    }

}
