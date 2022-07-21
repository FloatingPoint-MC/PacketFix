package me.vlouboos.packetfix.injection.mixins;

import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.util.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import me.vlouboos.packetfix.utils.FixEngine;

import java.io.IOException;

@Mixin(C08PacketPlayerBlockPlacement.class)
public class MixinC08PacketPlayerBlockPlacement {
    @Shadow
    private BlockPos position;
    @Shadow
    private int placedBlockDirection;
    @Shadow
    private ItemStack stack;
    @Shadow
    private float facingX;
    @Shadow
    private float facingY;
    @Shadow
    private float facingZ;

    /**
     * @author vlouboos
     * @reason Fix
     */
    @Overwrite
    public void writePacketData(PacketBuffer buf) throws IOException {
        buf.writeBlockPos(this.position);
        buf.writeByte(this.placedBlockDirection);
        buf.writeItemStackToBuffer(this.stack);
        buf.writeByte((int) (this.facingX * FixEngine.fixRightClick()));
        buf.writeByte((int) (this.facingY * FixEngine.fixRightClick()));
        buf.writeByte((int) (this.facingZ * FixEngine.fixRightClick()));
    }

    /**
     * @author vlouboos
     * @reason Fix
     */
    @Overwrite
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.position = buf.readBlockPos();
        this.placedBlockDirection = buf.readUnsignedByte();
        this.stack = buf.readItemStackFromBuffer();
        this.facingX = buf.readUnsignedByte() / FixEngine.fixRightClick();
        this.facingY = buf.readUnsignedByte() / FixEngine.fixRightClick();
        this.facingZ = buf.readUnsignedByte() / FixEngine.fixRightClick();
    }
}
