package fr.sixczero.hud;

import fr.sixczero.hud.hudData;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

public class hudLoader {
    private static final MinecraftClient client = MinecraftClient.getInstance();

    public static void drawAsync(DrawContext context) {
        CompletableFuture<Void> hud = CompletableFuture.runAsync(() -> drawHud(context), MinecraftClient.getInstance()::executeTask);
        CompletableFuture.allOf(hud);
    }

    public static void drawHud(DrawContext context) {
        ArrayList<Text> hud = new ArrayList<>();

        hud.add(hudData.getCoordinates());
        hud.add(hudData.getGame());
        hud.add(hudData.getIrl());

        TextRenderer textRenderer = client.textRenderer;
        int textHeight = textRenderer.fontHeight;

        int x = 6;
        int y = 6;

        for (int i = 0; i < hud.size(); i++) {
            context.drawText(textRenderer, hud.get(i), x, y + i * (textHeight + 2), 0xFFFF00, true);
        }
    }

}