package fr.sixczero.hud;

import fr.sixczero.hud.hudData;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;

import java.util.ArrayList;

public class hudLoader {
    private static final MinecraftClient client = MinecraftClient.getInstance();

    public static void drawHud(DrawContext context) {
        ArrayList<Text> hud = new ArrayList<>();

        hud.add(hudData.getCoordinates());
        hud.add(hudData.getGame());
        hud.add(hudData.getIrl());

        TextRenderer textRenderer = client.textRenderer;
        int textHeight = textRenderer.fontHeight;

        for (int i = 0; i < hud.toArray().length; i++) {
            context.drawText(textRenderer, hud.get(i), 6, 6 + i * (textHeight), 0xFFFF00, true);
        }
    }

}