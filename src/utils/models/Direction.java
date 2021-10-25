package utils.models;

public enum Direction {

    VERTICAL,
    HORIZONTAL,
    MAIN_DIAGONAL,
    INVERSE_DIAGONAL,
    NULL;

    public boolean isNull() {
        return this.equals(NULL);
    }   

}