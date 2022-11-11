package com.nekozouneko.nutilsx.command;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.TabExecutor;

public class GlobalTeleportCommand extends Command implements TabExecutor {

    public GlobalTeleportCommand() {
        super("bnutilsx", "nutilsx.command.nutilsx", "bnutils");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

    }

    @Override
    public Iterable<String> onTabComplete(CommandSender sender, String[] args) {
        return null;
    }
}
