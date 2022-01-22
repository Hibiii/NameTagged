package hibi.nametagged.mixin;

import net.minecraft.client.gui.hud.PlayerListHud;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.text.Text;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import hibi.nametagged.Badges;
import hibi.nametagged.ModCompat;

@Mixin(PlayerListHud.class)
public class PlayerListHudMixin {
	@Inject(
		method = "getPlayerName",
		at = @At("RETURN"),
		cancellable = true)
	private void addBadges(PlayerListEntry entry, CallbackInfoReturnable<Text> info) {
		if(ModCompat.hasEars(entry)) {
			Text out = Badges.prepend(Badges.EARS_BADGE, info.getReturnValue());
			info.setReturnValue(out);
		}
	}
}
