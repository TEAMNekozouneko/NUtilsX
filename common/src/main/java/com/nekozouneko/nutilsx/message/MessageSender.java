package com.nekozouneko.nutilsx.message;

import net.md_5.bungee.api.chat.BaseComponent;

public interface MessageSender {

    void sendMessage(String s);

    void sendMessage(String... s);

    void sendMessageWithPrefix(String s);

    void sendMessageWithPrefix(String... s);

    void sendMessage(BaseComponent bc);

    void sendMessageWithPrefix(BaseComponent bc);

    void sendMessage(BaseComponent... bc);

    void sendMessageWithPrefix(BaseComponent... bc);
}
