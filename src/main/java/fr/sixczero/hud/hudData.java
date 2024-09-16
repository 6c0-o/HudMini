package fr.sixczero.hud;

import fr.sixczero.utils.format;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.time.LocalTime;

public class hudData {
    private static int x = 0, y = 0, z = 0;
    private static Text text;
    private static final MinecraftClient client = MinecraftClient.getInstance();

    public static Text getCoordinates(){
        assert client.player != null;

        x = (int)client.player.getX();
        y = (int)client.player.getY();
        z = (int)client.player.getZ();

        if (client.world.getRegistryKey() == World.OVERWORLD){
            text = format.StringToText("§eXYZ: §f %d %d %d (§c%.0f %d %.0f§f)", x, y, z, (float)x / 8, y, (float)z / 8);
        } else if (client.world.getRegistryKey() == World.NETHER) {
            text = format.StringToText("§eXYZ: §f %d %d %d (§a%d %d %d§f)", x, y, z, x * 8, y, z * 8);
        } else if (client.world.getRegistryKey() == World.END) {
            text = format.StringToText("§eXYZ: §f %d %d %d", x, y, z);
        } else {
            text = format.StringToText("§eXYZ: §f %d %d %d", x, y, z);
        }

        return text;
    }

    public static Text getGame(){
        long time = client.player.getWorld().getTimeOfDay();
        long worldDay = time / 24000L;

        long hour = Long.parseLong(format.formatTime((time / 1000 + 6) % 24));
        int minute = Integer.parseInt(format.formatTime((int) ((time % 1000) / 1000.0 * 60)));

        return format.StringToText("§eDays:§f %d (%d:%02d)", worldDay, hour, minute);
    }

    public static Text getIrl(){
        LocalTime timeIRL = LocalTime.now();
        String hIRL = format.formatTime(timeIRL.getHour());
        String mIRL = format.formatTime(timeIRL.getMinute());

        return format.StringToText("§eIrl:§f %s:%s", hIRL,mIRL);
    }
}
