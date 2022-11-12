package com.nekozouneko.nutilsx;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class Util {

    private static final Map<Integer, GameMode> gmnMap = new HashMap<>();
    private static final Map<String, GameMode> gmsMap = new HashMap<>();

    static {
        gmnMap.put(0, GameMode.SURVIVAL);
        gmnMap.put(1, GameMode.CREATIVE);
        gmnMap.put(2, GameMode.ADVENTURE);
        gmnMap.put(3, GameMode.SPECTATOR);

        gmsMap.put("adventure", GameMode.ADVENTURE);
        gmsMap.put("a", GameMode.ADVENTURE);
        gmsMap.put("creative", GameMode.CREATIVE);
        gmsMap.put("c", GameMode.CREATIVE);
        gmsMap.put("spectator", GameMode.SPECTATOR);
        gmsMap.put("sp", GameMode.SPECTATOR);
        gmsMap.put("survival", GameMode.SURVIVAL);
        gmsMap.put("s", GameMode.SURVIVAL);
        gmsMap.put("0", GameMode.SURVIVAL);
        gmsMap.put("1", GameMode.CREATIVE);
        gmsMap.put("2", GameMode.ADVENTURE);
        gmsMap.put("3", GameMode.SPECTATOR);
    }

    private Util() {
        throw new UnsupportedOperationException("Constructor is disabled");
    }

    public static boolean isPlayer(org.bukkit.command.CommandSender sender) {
        if (sender instanceof Player) {
            return true;
        }
        return false;
    }

    public static boolean isPlayer(net.md_5.bungee.api.CommandSender sender) {
        if (sender instanceof ProxiedPlayer) {
            return true;
        }
        return false;
    }

    /**
     * to GameMode Util
     * @param gm GameMode value
     * @throws IllegalArgumentException Thrown if you enter an unsupported class or number
     * @throws ExceptionInInitializerError Error in initializing GameMode map
     * @return Bukkit GameMode
     */
    public static GameMode toGameMode(Object gm) {
        if (gm instanceof Long || gm instanceof Integer || gm instanceof Short) {
            int gmn = (int) gm;
            if (gmn <= -1 || gmn >= 4) {
                throw new IllegalArgumentException("Supported 0-3 numbers.");
            }

            try {
                return gmnMap.get(gmn);
            } catch (NullPointerException e) {
                throw new ExceptionInInitializerError("An internal error has occurred. Please report this issue to the NUtilsX repository. Debug GMN: " + gmn);
            }
        } else if (gm instanceof String) {
            try {
                return gmsMap.get(((String) gm).toLowerCase());
            } catch (NullPointerException e) {
                throw new IllegalArgumentException(gm + " is not supported word. Please use [a, adventure, c, creative, s, sp, spectator and survival].");
            }
        } else {
            throw new IllegalArgumentException("Class " + gm.getClass().getName() + " is not supported class! Please use Long, Integer, Short and String!");
        }
    }

    /**
     * 大文字と小文字を区別しないように指定された文字列から始まっているか確認します。
     * @param e 引数 's' から始まっているかチェックする文字列
     * @param s 引数 'e' の接頭辞と一致するかチェックする文字列
     * @return trueはsの接頭辞がeと一致すると返し、falseは一致しなければ返します
     * @see String#startsWith(String)
     */
    public static boolean startsWithIgnoreCase(String e, String s) {
        final String e1 = e.toLowerCase();
        final String s1 = s.toLowerCase();

        return e1.startsWith(s1);
    }

    /**
     * #FF0000などをMinecraft 1.16で実装されたHEXカラーに変換します
     * @param s ウェブカラーコードを含む文字列
     * @return HEXカラーに置き換えした文字列
     */
    public static String colorFromWebColor(String s) {
        return replaceColorCode(s.replaceAll(
                "#([0-9a-fA-F])([0-9a-fA-F])([0-9a-fA-F])([0-9a-fA-F])([0-9a-fA-F])([0-9a-fA-F])",
                "&x&$1&$2&$3&$4&$5&$6"
        ).replaceAll(
                "#([0-9a-fA-F])([0-9a-fA-F])([0-9a-fA-F])",
                "&x&$1&$2&$3"
        ));
    }

    /**
     * {@link net.md_5.bungee.api.ChatColor#translateAlternateColorCodes(char, String) ChatColor.translateAlternateColorCodes()}
     * にMinecraft 1.16に実装されたHEXカラーを対応させたものです。
     * @param s 代替の色コードを含む文字列
     * @return 代替の色コードを '\u00A7' に置き換えた文字列
     * @see net.md_5.bungee.api.ChatColor#translateAlternateColorCodes(char, String)
     * @see #replaceColorCode(char, String)
     */
    public static String replaceColorCode(String s) {
        return replaceColorCode('&', s);
    }

    /**
     * {@link net.md_5.bungee.api.ChatColor#translateAlternateColorCodes(char, String) ChatColor.translateAlternateColorCodes()}
     * にMinecraft 1.16に実装されたHEXカラーを対応させたものです。
     * @param acc 代替の色コード
     * @param s 代替の色コードを含む文字列
     * @return 代替の色コードを '\u00A7' に置き換えた文字列
     * @see net.md_5.bungee.api.ChatColor#translateAlternateColorCodes(char, String)
     */
    public static String replaceColorCode(char acc, String s) {
        return s.replaceAll(acc + "([0-9a-fA-FrRk-oK-OxX])", "§$1");
    }
}
