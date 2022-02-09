package hibi.nametagged;

public enum Badge {
	EARS("\u0045"),
	FIGURA("\u00F1"),
	FIGURA_DEV("\uF1DE");

	public final String codepoint;
	Badge(String codepoint) {
		this.codepoint = codepoint;
	}
}
