package fr.sixczero.hud;

import fr.sixczero.hud.data.Coordinates;
import fr.sixczero.hud.data.GameInfo;
import fr.sixczero.hud.data.IrlInfo;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;

public class hudLoader {
    private static final MinecraftClient client = MinecraftClient.getInstance();
    private static void renderText(DrawContext drawContext, Text text, int index){
        TextRenderer textRenderer = client.textRenderer;

        int textHeight = textRenderer.fontHeight;
        int padding = 5;

        drawContext.drawText(textRenderer, text, padding + 1, 1 + padding + index * (textHeight), 0xFFFF00, false);
    }

    public static void drawHud(DrawContext context) {
        final int[] index = {0};
        renderText(context, Coordinates.get(), index[0]++);
        renderText(context, GameInfo.get(), index[0]++);
        renderText(context, IrlInfo.get(), index[0]++);
    }

}