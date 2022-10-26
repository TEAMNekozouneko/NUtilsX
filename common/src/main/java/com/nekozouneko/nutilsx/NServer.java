package com.nekozouneko.nutilsx;

import net.md_5.bungee.api.ProxyServer;
import org.bukkit.Server;

public class NServer {

    private Server bukkitServer;
    private ProxyServer bungeeServer;

    private NServer() {}

    public static NServer create(Server server) {
        return new NServer(server);
    }

    public static NServer create(ProxyServer server) {
        return new NServer(server);
    }

    private NServer(Server server) {
        this.bukkitServer = server;
        this.bungeeServer = null;
    }

    private NServer(ProxyServer server) {
        this.bukkitServer = null;
        this.bungeeServer = server;
    }

    public Server toBukkitServer() {
        return this.bukkitServer;
    }

    public ProxyServer toBungeeServer() {
        return this.bungeeServer;
    }

}
