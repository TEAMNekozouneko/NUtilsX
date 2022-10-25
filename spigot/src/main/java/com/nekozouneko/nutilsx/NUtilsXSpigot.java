package com.nekozouneko.nutilsx;

import com.nekozouneko.nutilsx.api.NUtilsXApiRegisterUtil;
import com.nekozouneko.nutilsx.api.NUtilsXProvider;
import com.nekozouneko.nutilsx.command.Test;
import org.bukkit.plugin.java.JavaPlugin;

public class NUtilsXSpigot extends JavaPlugin implements NUtilsX {

    private static NUtilsXSpigot instance = null;
    private NUtilsXApi api = null;

    public static NUtilsX getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        NUtilsXSpigot.instance = this;
        NUtilsXApiRegisterUtil.registerProv(NUtilsXSpigot.instance);
        this.api = NUtilsXProvider.get();

        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        //getCommand("test").setExecutor(new Test());
    }

    @Override
    public void onDisable() {
        NUtilsXSpigot.instance = null;
        this.api = null;
        NUtilsXApiRegisterUtil.unregisterProv();
    }

    @Override
    public NUtilsXApi getApi() {
        return api;
    }

    @Override
    public Platform getPlatform() {
        return Platform.SPIGOT;
    }

    @Override
    public String getVersion() {
        return getDescription().getVersion();
    }
}
