package com.nekozouneko.nutilsx.message;

import com.nekozouneko.nutilsx.language.Translator;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.CommandSender;

import static com.nekozouneko.nutilsx.Util.*;

public class SpigotMessageSender implements MessageSender {

    private final CommandSender sender;
    private final String l;

    public SpigotMessageSender(CommandSender sender, String lang) {

        this.sender = sender;
        this.l = lang;
    }

    @Override
    public void sendMessage(String s) {
        this.sender.sendMessage(s);
    }

    @Override
    public void sendMessage(String... s) {
        for (String ss : s) sendMessage(ss);
    }

    @Override
    public void sendMessageWithPrefix(String s) {
        sendMessage(Translator.gen(l, "nutilsx.lang.prefix") + s);
    }

    @Override
    public void sendMessageWithPrefix(String... s) {
        for (String ss:s) sendMessageWithPrefix(ss);
    }

    @Override
    public void sendMessage(BaseComponent bc) {
        this.sender.spigot().sendMessage(bc);
    }

    @Override
    public void sendMessageWithPrefix(BaseComponent bc) {
        final BaseComponent pref = new TextComponent(Translator.gen(l, "nutilsx.lang.prefix"));
        pref.addExtra(bc);

        this.sender.spigot().sendMessage(pref);
    }

    @Override
    public void sendMessage(BaseComponent... bc) {
        for (BaseComponent bcs : bc) sendMessage(bcs);
    }

    @Override
    public void sendMessageWithPrefix(BaseComponent... bc) {
        for (BaseComponent bcs:bc) sendMessageWithPrefix(bc);
    }
}
