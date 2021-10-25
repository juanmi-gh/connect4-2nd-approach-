package utils.views;

public class YesNoDialog extends WithConsoleView {

    private static final char AFFIRMATIVE = 'y';
    private static final char NEGATIVE = 'n';
    private static final String SUFFIX = "? (AFFIRMATIVE/NEGATIVE): ";
    private static final String INVALID_VALUE = "The value must be 'AFFIRMATIVE' or 'NEGATIVE'";

	public boolean read(String title) {
		assert title != null;
		
		char answer;
		boolean ok;
		do {
			answer = console.readChar(title + SUFFIX);
			ok = isAfirmative(answer) || isNegative(answer);
			if (!ok) {
				console.writeln(INVALID_VALUE);
			}
		} while (!ok);
		return YesNoDialog.isAfirmative(answer);
	}

	private static boolean isAfirmative(char answer) {
		return Character.toLowerCase(answer) == AFFIRMATIVE;
	}

	private static boolean isNegative(char answer) {
		return Character.toLowerCase(answer) == NEGATIVE;
    }
}
