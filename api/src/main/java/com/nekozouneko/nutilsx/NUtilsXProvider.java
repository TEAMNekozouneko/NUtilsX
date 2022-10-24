package com.nekozouneko.nutilsx;

public class NUtilsXProvider {

    private static NUtilsXApi instance = null;

    public static NUtilsXApi get() {
        return NUtilsXProvider.instance;
    }

    static void registerProv(NUtilsXApi instance) {
        NUtilsXProvider.instance = instance;
    }

    static void unregisterProv() {
        instance = null;
    }

}
