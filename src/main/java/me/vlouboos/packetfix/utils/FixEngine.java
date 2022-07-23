package me.vlouboos.packetfix.utils;

import de.enzaxd.viaforge.ViaForge;

public class FixEngine {
    /**
     * Fix for right-clicking
     * Made by vlouboos
     */
    public static float fixRightClick() {
        if (ViaForge.getInstance().getVersion() == 47) {
            return 16.0F;
        } else {
            return 1.0F;
        }
    }
}
