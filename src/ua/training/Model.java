package ua.training;

import java.util.Random;

public class Model {
    private int searchedNumber;

    private static final int DEFAULT_MIN_BARRIER = 0;
    private static final int DEFAULT_MAX_BARRIER = 100;
    private int minBarrier;
    private int maxBarrier;

    private AttemptHistory attemptHistory = new AttemptHistory();

    public Model() {
        minBarrier = DEFAULT_MIN_BARRIER;
        maxBarrier = DEFAULT_MAX_BARRIER;
        searchedNumber = (int)Math.ceil(Math.random() *
                (maxBarrier - minBarrier - 1) + minBarrier);
    }

    public AttemptResult checkValue(int value) {
        if (value > searchedNumber) {
            maxBarrier = value;
            attemptHistory.put(value, AttemptResult.BIGGER);
            return AttemptResult.BIGGER;
        }
        else if (value < searchedNumber) {
            minBarrier = value;
            attemptHistory.put(value, AttemptResult.SMALLER);
            return AttemptResult.SMALLER;
        }
        attemptHistory.put(value, AttemptResult.EQUAL);
        return AttemptResult.EQUAL;
    }

    public boolean guessed(int value) {
        return checkValue(value) == AttemptResult.EQUAL ? true : false;
    }

    public int getMinBarrier() { return minBarrier; }
    public int getMaxBarrier() { return maxBarrier; }
    public AttemptHistory getAttemptHistory() { return attemptHistory; }
}
