package com.nekozouneko.nutilsx.api;

import com.nekozouneko.nutilsx.NUtilsX;
import com.nekozouneko.nutilsx.NUtilsXApi;

import java.lang.reflect.Method;

public class NUtilsXApiRegisterUtil {

    private static Method REGISTER = null;
    private static Method UNREGISTER = null;

    static {
        try {
            REGISTER = NUtilsXProvider.class.getDeclaredMethod("registerApi", NUtilsXApi.class);
            REGISTER.setAccessible(true);

            UNREGISTER = NUtilsXProvider.class.getDeclaredMethod("unregisterApi");
            UNREGISTER.setAccessible(true);
        } catch (NoSuchMethodException nsm) {
            throw new ExceptionInInitializerError(nsm);
        }
    }

    public static boolean registerProv(NUtilsX nutilsx) {
        try {
            REGISTER.invoke(null, new ImplNUtilsXApi(nutilsx));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean unregisterProv() {
        try {
            UNREGISTER.invoke(null);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
