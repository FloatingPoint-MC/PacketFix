package me.vlouboos.packetfix.utils;

import viamcp.ViaMCP;

public class FixEngine {
    /**
     * Fix for right-clicking
     * Made by vlouboos
     */
    public static float fixRightClick() {
        if (ViaMCP.getInstance().getVersion() == ViaMCP.PROTOCOL_VERSION) {
            return 16.0F;
        } else {
            return 1.0F;
        }
    }
}
