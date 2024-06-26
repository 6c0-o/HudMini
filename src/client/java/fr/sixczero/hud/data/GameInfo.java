package fr.sixczero.hud.data;

import fr.sixczero.utils.format;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class GameInfo {
    private static final MinecraftClient client = MinecraftClient.getInstance();

    public static Text get(){
        long time = client.player.getWorld().getTimeOfDay();
        long worldDay = time / 24000L;

        long hour = Long.parseLong(format.formatTime((time / 1000 + 6) % 24));
        int minute = Integer.parseInt(format.formatTime((int) ((time % 1000) / 1000.0 * 60)));

        return format.StringToText("§eDays:§f %d (%d:%02d)", worldDay, hour, minute);
    }
}
