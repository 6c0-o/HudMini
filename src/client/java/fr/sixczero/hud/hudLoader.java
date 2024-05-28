package fr.sixczero.hud;

import fr.sixczero.hud.data.Coordinates;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;

public class hudLoader implements HudRenderCallback {
    private int i = 0;
    @Override
    public void onHudRender(DrawContext drawContext, float tickDelta) {
        i = 0;
        MinecraftClient client = MinecraftClient.getInstance();
        TextRenderer textRenderer = client.textRenderer;

        int textHeight = textRenderer.fontHeight;
        int screenHeight = client.getWindow().getScaledHeight();
        int padding = 5;


        drawContext.drawText(textRenderer, Coordinates.main(), padding + 1, (screenHeight - textHeight * (i++ + 1) - padding - 1), 0xFFFF00, false);
        drawContext.drawText(textRenderer, "ouio", padding + 1, (screenHeight - textHeight * (i++ + 1) - padding - 1), 0xFFFF00, false);
        drawContext.drawText(textRenderer, "d", padding + 1, (screenHeight - textHeight * (i++ + 1) - padding - 1), 0xFFFF00, false);
    }
}
