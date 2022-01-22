package hibi.nametagged;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.mojang.authlib.GameProfile;
import com.unascribed.ears.api.features.EarsFeatures;
import com.unascribed.ears.common.EarsFeaturesHolder;
import com.unascribed.ears.common.EarsFeaturesStorage;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.client.texture.AbstractTexture;

public class ModCompat {

	public static boolean earsInstalled() {
		return hasEarsInstalled;
	}

	/**
	 * Returns true if the player has a skin with Ears features. Should work at any range. 
	 * @param entry The PlayerListEntry of the player to be queried.
	 */
	public static boolean hasEars(PlayerListEntry entry) {
		if(!hasEarsInstalled) return false;
		GameProfile profile = entry.getProfile();
		if(!cachedPlayerSkins.contains(profile.getId())) {
			AbstractTexture tex = MinecraftClient.getInstance().getTextureManager().getTexture(entry.getSkinTexture());
			if(tex instanceof EarsFeaturesHolder) {
				EarsFeaturesStorage.INSTANCE.put(profile.getName(), profile.getId(), ((EarsFeaturesHolder)tex).getEarsFeatures());
			}
			cachedPlayerSkins.add(profile.getId());
		}
		return EarsFeatures.getById(profile.getId()) != EarsFeatures.DISABLED;
	}

	private ModCompat() {};

	/** Controls if Ears is installed and can be used for its internal API. */
	private static boolean hasEarsInstalled = true;

	static {
		try {
			Class.forName("com.unascribed.ears.EarsMod");
			Class.forName("com.unascribed.ears.api.features.EarsFeatures");
		}
		catch (ClassNotFoundException e) {
			hasEarsInstalled = false;
		}
	}

	private static List<UUID> cachedPlayerSkins = new ArrayList<UUID>();
}
