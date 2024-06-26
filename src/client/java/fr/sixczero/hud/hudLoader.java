package fr.sixczero.hud;

import fr.sixczero.hud.data.Coordinates;
import fr.sixczero.hud.data.GameInfo;
import fr.sixczero.hud.data.IrlInfo;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.text.Text;

public class hudLoader implements HudRenderCallback {
    private static final MinecraftClient client = MinecraftClient.getInstance();
    @Override
    public void onHudRender(DrawContext drawContext, RenderTickCounter tickCounter) {
        int index = 0;
        renderText(drawContext, Coordinates.get(), index++);
        renderText(drawContext, GameInfo.get(), index++);
        renderText(drawContext, IrlInfo.get(), index++);
    }

    private void renderText(DrawContext drawContext, Text text, int index){
        TextRenderer textRenderer = client.textRenderer;

        int textHeight = textRenderer.fontHeight;
        int padding = 5;

        drawContext.drawText(textRenderer, text, padding + 1, 1 + padding + index * (textHeight), 0xFFFF00, false);
    }

}
