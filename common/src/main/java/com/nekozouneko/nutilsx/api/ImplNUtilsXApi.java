package com.nekozouneko.nutilsx.api;


import com.nekozouneko.nutilsx.NUtilsX;
import com.nekozouneko.nutilsx.NUtilsXApi;
import com.nekozouneko.nutilsx.Platform;

class ImplNUtilsXApi implements NUtilsXApi {

    private final String version;
    private final Platform platform;
    private final long uptime;

    ImplNUtilsXApi(NUtilsX instance) {
        this.version = instance.getVersion();
        this.platform = instance.getPlatform();
        this.uptime = instance.getStartUpTime();
    }

    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public Platform getPlatform() {
        return platform;
    }

    @Override
    public long getUptime() {
        return (System.currentTimeMillis()/1000L) - uptime;
    }
}
