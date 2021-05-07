package Math;

public enum FrameType {
	SINGLELEAF("��������������"),
	BIVALVE("��������������"),
	TRICUSPID("�������������"),
	BIVALVETRANSOM("�������������� � ��������"),
	TRICUSPIDTRANSOM("������������� � ��������");

    private String text;

    FrameType(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public static FrameType fromString(String text) {
        for (FrameType b : FrameType.values()) {
            if (b.text.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }
}