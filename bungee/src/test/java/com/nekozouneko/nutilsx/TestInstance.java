package com.nekozouneko.nutilsx;

import com.nekozouneko.nutilsx.NUtilsX;
import com.nekozouneko.nutilsx.NUtilsXApi;
import com.nekozouneko.nutilsx.Platform;
import com.nekozouneko.nutilsx.api.NUtilsXApiRegisterUtil;
import com.nekozouneko.nutilsx.api.NUtilsXProvider;

public class TestInstance implements NUtilsX {

    private NUtilsXApi api;

    public TestInstance() {
        NUtilsXApiRegisterUtil.registerProv(this);
        this.api = NUtilsXProvider.get();
    }

    public void unregister() {
        NUtilsXApiRegisterUtil.unregisterProv();
        this.api = null;
    }

    @Override
    public NUtilsXApi getApi() {
        return this.api;
    }

    @Override
    public Platform getPlatform() {
        return Platform.BUNGEECORD;
    }

    @Override
    public String getVersion() {
        return "Test";
    }
}
