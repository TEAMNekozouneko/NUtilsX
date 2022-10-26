package com.nekozouneko.nutilsx.command;

/**
 * @todo  2022/10/26 ゲームモードコマンド実装したい
 */
public class GamemodeCommand implements NUtilsXCommand {

    @Override
    public Boolean run(Sender sender) {
        return true;
    }

    @Override
    public String getUsage() {
        return "/<command>";
    }

    @Override
    public String getPermission() {
        return null;
    }
}
