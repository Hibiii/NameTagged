package hibi.nametagged.mixin;

import net.minecraft.client.gui.hud.PlayerListHud;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.text.Text;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import hibi.nametagged.Common;

@Mixin(PlayerListHud.class)
public class PlayerListHudMixin {
	@Inject(
		method = "getPlayerName",
		at = @At("RETURN"),
		cancellable = true)
	private void addBadges(PlayerListEntry entry, CallbackInfoReturnable<Text> info) {
		Text out = Common.prepend(Text.of(Common.store.get(entry.getProfile().getId())), info.getReturnValue());
		info.setReturnValue(out);
	}
}
