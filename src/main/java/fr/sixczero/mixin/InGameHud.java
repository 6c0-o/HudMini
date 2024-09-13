package fr.sixczero.mixin;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import fr.sixczero.hud.hudLoader;

@Mixin(net.minecraft.client.gui.hud.InGameHud.class)
public class InGameHud {
	@Inject(method = "render", at = @At("HEAD"))
	private void onDraw(DrawContext context, RenderTickCounter tickCounter, CallbackInfo ci) {
		hudLoader.drawHud(context);
	}
}