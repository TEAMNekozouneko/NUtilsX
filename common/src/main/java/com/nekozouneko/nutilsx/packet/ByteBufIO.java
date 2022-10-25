package com.nekozouneko.nutilsx.packet;

import io.netty.buffer.ByteBuf;

import java.nio.charset.StandardCharsets;

public class ByteBufIO {

    public static boolean writeString(String s, ByteBuf out) {

        if (s.length() > Short.MAX_VALUE) {
            return false;
        }

        byte[] b = s.getBytes(StandardCharsets.UTF_8);
        writeVarInt(b.length, out);
        out.writeBytes(b);
        return true;
    }

    public static void writeVarInt(int value, ByteBuf output) {
        int part;
        while ( true ) {
            part = value & 0x7F;

            value >>>= 7;
            if (value != 0) {
                part |= 0x80;
            }

            output.writeByte(part);

            if (value == 0) {
                break;
            }
        }

    }

    public static byte[] toArray(ByteBuf buf)
    {
        byte[] ret = new byte[ buf.readableBytes() ];
        buf.readBytes( ret );

        return ret;
    }
}
