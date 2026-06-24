package day03;

public class MaxPairJoltageStrategy implements JoltageStrategy {

    private static final int REQUIRED_BATTERIES = 2;

    @Override
    public long calculate(BatteryBank batteryBank) {
        return findMaximumNumber(batteryBank.ratings(), REQUIRED_BATTERIES);
    }

    private long findMaximumNumber(String digits, int requiredDigits) {
        StringBuilder result = new StringBuilder();
        int lastSelectedIndex = -1;

        for (int position = 0; position < requiredDigits; position++) {
            int remainingDigits = requiredDigits - position - 1;
            int searchLimit = digits.length() - remainingDigits;

            char bestDigit = '0' - 1;
            int bestIndex = -1;

            for (int index = lastSelectedIndex + 1; index < searchLimit; index++) {
                char current = digits.charAt(index);

                if (current > bestDigit) {
                    bestDigit = current;
                    bestIndex = index;
                }
            }

            result.append(bestDigit);
            lastSelectedIndex = bestIndex;
        }

        return Long.parseLong(result.toString());
    }
}