package hibi.nametagged.mixin;

import net.minecraft.client.gui.hud.PlayerListHud;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import hibi.nametagged.ModCompat;

@Mixin(PlayerListHud.class)
public class ExampleMixin {
	@Inject(
		method = "getPlayerName",
		at = @At("RETURN"),
		cancellable = true)
	private void addBadges(PlayerListEntry entry, CallbackInfoReturnable<Text> info) {
		if(ModCompat.hasEars(entry)) {
			Text out = SAMPLE_BADGE.copy().append(info.getReturnValue());
			info.setReturnValue(out);
		}
	}
	private static final MutableText SAMPLE_BADGE = (MutableText)Text.of("<3 ");
}
