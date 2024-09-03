package fr.sixczero.hud.data;

import fr.sixczero.utils.format;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import net.minecraft.world.World;

public class Coordinates {
    private static int x = 0, y = 0, z = 0;
    private static int xN = 0, yN = 0, zN = 0;
    private static Text text;
    private static final MinecraftClient client = MinecraftClient.getInstance();

    public static Text get(){
        assert client.player != null;

        x = (int)client.player.getX();
        y = (int)client.player.getY();
        z = (int)client.player.getZ();

        xN = x / 8;
        zN = z / 8;

        if (client.world.getRegistryKey() == World.OVERWORLD){
            text = format.StringToText("§eXYZ: §f %d %d %d (§c%d %d %d§f)", x, y, z, xN, y, zN);
        } else if (client.world.getRegistryKey() == World.NETHER) {
            text = format.StringToText("§eXYZ: §f %d %d %d (§a%d %d %d§f)", x, y, z, x * 8, y, z * 8);
        } else if (client.world.getRegistryKey() == World.END) {
            text = format.StringToText("§eXYZ: §f %d %d %d", x, y, z);
        } else {
            text = Text.of("Error");
        }

        return text;
    }
}