package com.nekozouneko.nutilsx;

import com.nekozouneko.nutilsx.api.NUtilsXApiRegisterUtil;
import com.nekozouneko.nutilsx.api.NUtilsXProvider;
import com.nekozouneko.nutilsx.command.Test;
import net.md_5.bungee.api.plugin.Plugin;

public class NUtilsXBungee extends Plugin implements NUtilsX {

    private static NUtilsX instance = null;
    private NUtilsXApi api = null;

    public static NUtilsX getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        NUtilsXBungee.instance = this;
        NUtilsXApiRegisterUtil.registerProv(this);
        this.api = NUtilsXProvider.get();

        //getProxy().getPluginManager().registerCommand(this, new Test());
    }

    @Override
    public void onDisable() {
        NUtilsXBungee.instance = null;
        NUtilsXApiRegisterUtil.unregisterProv();
        this.api = null;
    }

    @Override
    public NUtilsXApi getApi() {
        return api;
    }

    @Override
    public Platform getPlatform() {
        return Platform.BUNGEECORD;
    }

    @Override
    public String getVersion() {
        return getDescription().getVersion();
    }
}
