package fr.sixczero.hud.data;

import fr.sixczero.utils.format;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class GameInfo {
    private static final MinecraftClient client = MinecraftClient.getInstance();

    public static Text get(){
        long timeOfDay = client.world.getTimeOfDay();
        long worldDay = timeOfDay / 24000L;

        int totalMinutes = (int)((timeOfDay % 24000L) / 16.6667);
        String hourIGM = format.Time((totalMinutes / 60 + 6) % 24);
        String minuteIGM = format.Time(totalMinutes % 60);

        return format.StringToText("§eDays:§f %d (%s:%s)", worldDay, hourIGM, minuteIGM);
    }
}
