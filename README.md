# PacketFix
Packet fix for every one

Good ez.
![image](https://user-images.githubusercontent.com/87124020/180162521-19283f36-4ad7-473b-8399-9d9fded5ba2d.png)

修复右键ban方法
1. 找到你的net.minecraft.network.play.client.C08PacketPlayerBlockPlacement中的
```
public void readPacketData(PacketBuffer buf) throws IOException
```
和
```
public void writePacketData(PacketBuffer buf) throws IOException
```

2. 找到里面的
```
this.facingX = (float) buf.readUnsignedByte() / 16.0F;
this.facingY = (float) buf.readUnsignedByte() / 16.0F;
this.facingZ = (float) buf.readUnsignedByte() / 16.0F;
```
和
```
buf.writeByte((int) (this.facingX * 16.0F));
buf.writeByte((int) (this.facingY * 16.0F));
buf.writeByte((int) (this.facingZ * 16.0F));
```

3. 像这样把16.0F改成FixEngine.fixRightClick()

```
this.facingX = (float) (buf.readUnsignedByte() * FixEngine.fixRightClick());
this.facingY = (float) (buf.readUnsignedByte() * FixEngine.fixRightClick());
this.facingZ = (float) (buf.readUnsignedByte() * FixEngine.fixRightClick());
```
```
buf.writeByte((int) (this.facingX * FixEngine.fixRightClick()));
buf.writeByte((int) (this.facingY * FixEngine.fixRightClick()));
buf.writeByte((int) (this.facingZ * FixEngine.fixRightClick()));
```

4. 大功告成, Enjoy free source and buy Float Client :3
