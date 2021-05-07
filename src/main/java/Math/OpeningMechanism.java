package Math;

public enum OpeningMechanism {
	DULL("������"), 
	FOLDING("��������"), 
	SWIVIEL("����������"),
	SWINGOUT("���������-��������");

	private String text;

	OpeningMechanism(String text) {
		this.text = text;
	}

	public String getText() {
		return this.text;
	}

	public static OpeningMechanism fromString(String text) {
		for (OpeningMechanism b : OpeningMechanism.values()) {
			if (b.text.equalsIgnoreCase(text)) {
				return b;
			}
		}
		return null;
	}
}