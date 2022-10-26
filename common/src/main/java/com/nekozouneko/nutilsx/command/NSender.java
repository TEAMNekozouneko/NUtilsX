package com.nekozouneko.nutilsx.command;

import com.nekozouneko.nutilsx.NServer;
import com.nekozouneko.nutilsx.Platform;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;

public class NSender implements Sender {

    private final Platform platform;
    private final net.md_5.bungee.api.CommandSender bungeeSender;
    private final org.bukkit.command.CommandSender spigotSender;
    private final NServer server;
    private final String name;

    private NSender() {
        throw new UnsupportedOperationException();
    }

    private NSender(net.md_5.bungee.api.CommandSender sender) {
        this.bungeeSender = sender;
        this.spigotSender = null;
        this.server = null;
        this.name = sender.getName();
        this.platform = Platform.BUNGEECORD;
    }

    private NSender(org.bukkit.command.CommandSender sender) {
        this.bungeeSender = null;
        this.spigotSender = sender;
        this.server = NServer.create(sender.getServer());
        this.name = sender.getName();
        this.platform = Platform.SPIGOT;
    }

    @Override
    public void sendMessage(String s) {
        switch (this.platform) {
            case SPIGOT:
                this.spigotSender.sendMessage(s);
                break;
            case BUNGEECORD:
                this.bungeeSender.sendMessage(new TextComponent(s));
                break;
            default:
                throw new ExceptionInInitializerError("Unknown platform: " + platform);
        }
    }

    @Override
    public void sendMessage(String... s) {
        for (String ss : s) {
            sendMessage(ss);
        }
    }

    @Override
    public void sendMessage(BaseComponent bc) {
        switch (this.platform) {
            case SPIGOT:
                this.spigotSender.spigot().sendMessage(bc);
                break;
            case BUNGEECORD:
                this.bungeeSender.sendMessage(bc);
                break;
            default:
                throw new ExceptionInInitializerError("Unknown platform: " + platform);
        }
    }

    @Override
    public void sendMessage(BaseComponent... bc) {
        for (BaseComponent bcs : bc) {
            sendMessage(bcs);
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public NServer getServer() {
        return this.server;
    }

    @Override
    public boolean hasPermission(String perm) {
        boolean has = false;
        switch (this.platform) {
            case BUNGEECORD:
                has = this.bungeeSender.hasPermission(perm);
                break;
            case SPIGOT:
                has = this.spigotSender.hasPermission(perm);
                break;
            default:
                throw new ExceptionInInitializerError("Unknown platform: " + platform);
        }

        return has;
    }
}
