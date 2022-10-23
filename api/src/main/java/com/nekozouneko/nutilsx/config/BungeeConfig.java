package com.nekozouneko.nutilsx.config;

import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

/**
 * BungeeCord configuration util
 * @author Taitaitatata
 * @version v2.0.1
 */
public class BungeeConfig {

    private final File configFile;
    private Configuration conf = null;
    private final ConfigurationProvider prov = YamlConfiguration.getProvider(YamlConfiguration.class);

    /**
     * BungeeCord configuration
     * @param plugin BungeeCord configuration
     */
    public BungeeConfig(Plugin plugin) {
        this.configFile = getConfigFile(plugin);

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(Files.newInputStream(this.configFile.toPath()), StandardCharsets.UTF_8));

            this.conf = prov.load(br);
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    /**
     * Get configuration file
     * @param plugin BungeeCord plugin
     * @return Configuration file
     */
    public static File getConfigFile(Plugin plugin) {
        return new File(plugin.getProxy().getPluginsFolder().getParentFile(), "config.yml");
    }

    /**
     * Get BungeeCord configuration.
     * @return BungeeCord configuration
     */
    public Configuration get() {
        return conf;
    }

    /**
     * Save BungeeCord configuration
     * @param conf configuration
     * @return is saved
     */
    public boolean save(Configuration conf) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(this.configFile.toPath()), StandardCharsets.UTF_8));
        } catch (IOException io) {
            io.printStackTrace();
        }

        if (bw != null) {
            prov.save(conf, bw);
            this.conf = conf;
            return true;
        }

        return false;
    }

}
