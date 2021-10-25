package connect4.types;

public enum Color {

    X,
    O,
    NULL;

    public static Color get(int ordinal) {
        assert ordinal >= 0 && ordinal < NULL.ordinal();

        return Color.values()[ordinal];
    }

    public boolean isNull() {
        return this == NULL;
    }
    
}