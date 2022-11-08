package com.nekozouneko.nutilsx.language;

import net.md_5.bungee.config.Configuration;

import static com.nekozouneko.nutilsx.Util.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Translator {

    private static final Map<String, Configuration> loadedTrans = new HashMap<>();

    private Translator() {

    }

    public static Set<String> availableLanguages() {
        return loadedTrans.keySet();
    }

    public static boolean loadTrans(String l, Configuration lf, boolean overwrite) {
        boolean exists;
        try {
            loadedTrans.get(l.toLowerCase());
            exists = true;
        } catch (NullPointerException e) {
            exists = false;
        }

        if (!exists || overwrite) loadedTrans.put(l.toLowerCase(), lf);
        else return false;

        return true;
    }

    public static String gen(String l, String p) {
        return gen(l, p, new String[0]);
    }
    
    public static String gen(String l, String p, String... args) {
        Configuration lang = loadedTrans.get(l.toLowerCase());
        String w = lang.getString(p);
        System.out.println(w);

        Matcher a = Pattern.compile("\\{[\\d+?]\\}").matcher(w);

        for (String b : args) {
            if (a.find()) {
                System.out.println(a.group(0));
                w = w.replace(a.group(0), b);
            } else break;
        }

        return colorFromWebColor(replaceColorCode('&', w));
    }



}
