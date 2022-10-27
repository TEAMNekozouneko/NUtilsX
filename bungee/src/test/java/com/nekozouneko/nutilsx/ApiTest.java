package com.nekozouneko.nutilsx;

import com.nekozouneko.nutilsx.api.NUtilsXApiRegisterUtil;
import com.nekozouneko.nutilsx.api.NUtilsXProvider;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ApiTest {

    private static NUtilsX testInstance;

    @BeforeAll
    public static void onStart() throws Exception {
        System.out.println("Started api test.");
        System.out.println("Initializing api...");

        testInstance = new TestInstance();

        if (testInstance.getApi() == null) {
            throw new Exception("Api is null!");
        }
    }

    @Test
    public void platformCheck() {
        NUtilsXApi api = NUtilsXProvider.get();

        System.out.println("Platform: " + api.getPlatform());
    }

    @Test
    public void versionCheck() {
        NUtilsXApi api = NUtilsXProvider.get();

        System.out.println("Version: " + api.getVersion());
    }

    @AfterAll
    public static void onEnd() throws Exception {
        System.out.println("Ended api test.");
        System.out.println("Unregistering api...");
        NUtilsXApiRegisterUtil.unregisterProv();

        NUtilsXApi api = NUtilsXProvider.get();

        if (api != null) {
            throw new Exception("Api is not null!");
        }

        System.out.println("Completed Api check.");
    }

}
