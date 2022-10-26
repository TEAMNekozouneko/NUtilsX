package com.nekozouneko.nutilsx.command;

import com.nekozouneko.nutilsx.NServer;
import net.md_5.bungee.api.chat.BaseComponent;

import java.util.UUID;

public interface Sender {

    void sendMessage(String s);

    void sendMessage(String... s);

    void sendMessage(BaseComponent bc);

    void sendMessage(BaseComponent... bc);

    String getName();

    NServer getServer();

    boolean hasPermission(String perm);

}
