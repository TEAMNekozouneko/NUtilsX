package com.nekozouneko.nutilsx.api;


import com.nekozouneko.nutilsx.NUtilsX;
import com.nekozouneko.nutilsx.NUtilsXApi;
import com.nekozouneko.nutilsx.Platform;

class ImplNUtilsXApi implements NUtilsXApi {

    private final String version;
    private final Platform platform;

    ImplNUtilsXApi(NUtilsX instance) {
        this.version = instance.getVersion();
        this.platform = instance.getPlatform();
    }

    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public Platform getPlatform() {
        return platform;
    }
}
