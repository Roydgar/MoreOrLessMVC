package ua.training;


import java.util.Locale;
import java.util.ResourceBundle;

public class View {
    private static String MESSAGES_BUNDLE_NAME = "messages";
    private static ResourceBundle bundle = ResourceBundle.getBundle(
            MESSAGES_BUNDLE_NAME,
            //new Locale("ru")
            new Locale("en")
            );

    private static final String INPUT_INT_DATA      = "input.int.data";
    private static final String CONGRATULATION      = "input.congratulation";
    private static final String WRONG_INPUT         = "input.wrong.data";
    private static final String WRONG_RANGE         = "input.wrong.range";

    private static final String OPENING_SQUARE_BRACKET = "[";
    private static final String CLOSING_SQUARE_BRACKET = "]";
    private static final String SPACE_SIGN             = " ";
    private static final String COMMA_SIGN             = ",";

    private void print(String message) {
        System.out.println(message);
    }

    private String stringConcatenation(String... messages) {
        StringBuilder stringConcat = new StringBuilder();
        for (String message : messages)
            stringConcat.append(message);
        return stringConcat.toString();
    }

    public String getInputMessage(int minBarrier, int maxBarrier) {
        return stringConcatenation(bundle.getString(INPUT_INT_DATA),
                                    SPACE_SIGN,
                                    OPENING_SQUARE_BRACKET,
                                    String.valueOf(minBarrier),
                                    COMMA_SIGN,
                                    String.valueOf(maxBarrier),
                                    CLOSING_SQUARE_BRACKET);
    }

    public void printInputMessage(Model model) {
        print(getInputMessage(model.getMinBarrier(), model.getMaxBarrier()));
    }

    public void printWrongIntInput(Model model) {
        print(bundle.getString(WRONG_INPUT) + getInputMessage(model.getMinBarrier(), model.getMaxBarrier()));
    }

    public void printWrongRangeInput(Model model) {
        print(bundle.getString(WRONG_RANGE) + getInputMessage(model.getMinBarrier(), model.getMaxBarrier()));
    }

    public void printAttemptHistory(Model model) {
        if (!model.getAttemptHistory().isEmpty())
            print(model.getAttemptHistory().toString());
    }

    public void printCongratulations(Model model) {
        print(bundle.getString(CONGRATULATION));
        printAttemptHistory(model);
    }
}
