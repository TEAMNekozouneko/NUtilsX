package com.nekozouneko.nutilsx;

import com.nekozouneko.nutilsx.api.NUtilsXApiRegisterUtil;
import com.nekozouneko.nutilsx.api.NUtilsXProvider;
import com.nekozouneko.nutilsx.command.GameModeCommand;
import com.nekozouneko.nutilsx.language.Translator;
import net.md_5.bungee.config.YamlConfiguration;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;
import me.lucko.commodore.Commodore;
import me.lucko.commodore.CommodoreProvider;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class NUtilsXSpigot extends JavaPlugin implements NUtilsX {

    private static NUtilsXSpigot instance = null;
    private NUtilsXApi api = null;
    private final Map<String, Entry<PluginCommand, CommandExecutor>> cmdMap = new HashMap<>();
    private long startedTime = 0;

    /* API */
    private static Commodore commodore;

    public static Commodore getCommodore() {
        return commodore;
    }

    public static NUtilsXSpigot getInstance() {
        return instance;
    }

    @Override
    public void onLoad() {
        this.startedTime = System.currentTimeMillis()/1000L;
    }

    @Override
    public void onEnable() {
        NUtilsXSpigot.instance = this;
        NUtilsXApiRegisterUtil.registerProv(NUtilsXSpigot.instance);
        this.api = NUtilsXProvider.get();

        commodore = CommodoreProvider.getCommodore(this);


        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

        initCommand();
        registerCommand();
        loadLanguage();
    }

    @Override
    public void onDisable() {
        NUtilsXSpigot.instance = null;
        this.api = null;
        NUtilsXApiRegisterUtil.unregisterProv();
    }

    private void initCommand() {
        final Entry<PluginCommand, CommandExecutor> GameMode = new SimpleEntry<>(getCommand("gamemode"), new GameModeCommand());

        cmdMap.put(GameMode.getKey().getName(), GameMode);
    }

    private void registerCommand() {
        for (String k : cmdMap.keySet()) {
            Entry<PluginCommand, CommandExecutor> cmd = cmdMap.get(k);

            cmd.getKey().setExecutor(cmd.getValue());
        }

        if (CommodoreProvider.isSupported()) {
            GameModeCommand.registerBrigadier(this, cmdMap.get("gamemode").getKey());
        }
    }

    private void loadLanguage() {
        Translator.loadTrans("ja_jp",YamlConfiguration.getProvider(YamlConfiguration.class).load(getResource("ja_jp.yml")),true);
        Translator.loadTrans("en_us",YamlConfiguration.getProvider(YamlConfiguration.class).load(getResource("en_us.yml")),true);
    }

    @Override
    public NUtilsXApi getApi() {
        return api;
    }

    @Override
    public Platform getPlatform() {
        return Platform.SPIGOT;
    }

    @Override
    public String getVersion() {
        return getDescription().getVersion();
    }

    @Override
    public long getStartUpTime() {
        return this.startedTime;
    }
}
