package hibi.nametagged;

import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class Badges {
	private static final Identifier badge_font = new Identifier("nametagged:badges");
	private static final Style badge_style = Style.EMPTY.withFont(badge_font);

	public static final MutableText
		EARS_BADGE = ((MutableText)Text.of("\u0045"));

	/**
	 * Standardized prepend function that retains the style of the original text.
	 * @param badge The text to be prepended.
	 * @param after The text to be appended.
	 */
	public static Text prepend(MutableText badge, Text after) {
		MutableText name = (MutableText)after;
		return badge.copy().fillStyle(badge_style).append(name.setStyle(name.getStyle().withFont(Style.DEFAULT_FONT_ID)));
	}

	private Badges() {};
}
