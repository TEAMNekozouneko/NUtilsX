package com.nekozouneko.nutilsx;

import org.junit.jupiter.api.Test;
import static com.nekozouneko.nutilsx.Util.*;

public class UtilTest {

    @Test
    public void colorCodeTest() {
        String w = "&4Dark Red &r| &cLight Red &r| &x&F&0&0 hex color (red / R:255, G:0, B:0)\n&lBold &nUnderlined &mStrikeThrough &kObfuscated";

        System.out.println(replaceColorCode('&', w));
    }

    @Test
    public void webColorCodeTest() {
        String w = "#FF0000Full color code #00F Short color code";

        System.out.println(replaceColorCode('&', colorFromWebColor(w)));
    }
}
