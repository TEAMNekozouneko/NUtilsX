package com.nekozouneko.nutilsx.command;

public interface NUtilsXCommand {

    default Boolean run(Sender sender) {
        return false;
    }

    default String getUsage() {
        return "/<command>";
    }

    String getPermission();

}
