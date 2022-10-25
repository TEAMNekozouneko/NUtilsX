package com.nekozouneko.nutilsx.api;

import com.nekozouneko.nutilsx.NUtilsXApi;

public class NUtilsXProvider {

    private NUtilsXProvider() {}

    private static NUtilsXApi instance = null;

    public static NUtilsXApi get() {
        return NUtilsXProvider.instance;
    }

    static void registerApi(NUtilsXApi instance) {
        NUtilsXProvider.instance = instance;
    }

    static void unregisterApi() {
        instance = null;
    }

}
