package hibi.nametagged.mixin;

import java.io.InputStream;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import hibi.nametagged.compat.Ears;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.PlayerSkinTexture;

@Mixin(PlayerSkinTexture.class)
public class PlayerSkinTextureMixin {
	@Inject(
		method = "loadTexture",
		at = @At("RETURN"))
	private void ltInjection(InputStream stream, CallbackInfoReturnable<NativeImage> info) {
		NativeImage image = info.getReturnValue();
		Ears.loadTextureHook(image);
	}
}
