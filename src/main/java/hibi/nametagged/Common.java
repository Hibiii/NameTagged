package hibi.nametagged;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class Common {
	/**
	 * Storage for the badge collection.
	 * Since badges can be represented as characters, we can just store them as 
	 */
	public static final Map<UUID,String> store = new HashMap<UUID,String>();

	private static final Identifier badge_font = new Identifier("nametagged:badges");
	private static final Style badge_style = Style.EMPTY.withFont(badge_font);

	/**
	 * Standardized prepend function that retains the style of the original text.
	 * @param before The text to be prepended.
	 * @param after The text to be appended.
	 */
	public static Text prepend(Text before, Text after) {
		MutableText name = (MutableText)after;
		return before.copy().fillStyle(badge_style).append(name.setStyle(name.getStyle().withFont(Style.DEFAULT_FONT_ID)));
	}

	private Common() {};
}
