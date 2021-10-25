package utils.views;

public class YesNoDialog {

    private static final char AFFIRMATIVE = 'y';
    private static final char NEGATIVE = 'n';
    private static final String SUFFIX = "? (AFFIRMATIVE/NEGATIVE): ";
    private static final String INVALID_VALUE = "The value must be 'AFFIRMATIVE' or 'NEGATIVE'";
    private String answer;

    public void read(String message) {
        assert message != null;

        Console console = Console.getInstance();
        boolean ok;
        do {
            console.write(message);
            answer = console.readString(SUFFIX);
            
            ok = this.isAffirmative() || this.isNegative();
            if (!ok) {
                console.writeln(INVALID_VALUE);
            }
        } while (!ok);
    }
    
    public boolean isAffirmative() {
        return getAnswer() == AFFIRMATIVE;
    }
    
    private char getAnswer(){
        return Character.toLowerCase(answer.charAt(0));
    }

    public boolean isNegative() {
        return this.getAnswer() == NEGATIVE;
    }
}
