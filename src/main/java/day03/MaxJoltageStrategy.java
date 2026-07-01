package day03;

public class MaxJoltageStrategy implements JoltageStrategy {

    private final int requiredBatteries;

    public MaxJoltageStrategy(int requiredBatteries) {
        this.requiredBatteries = requiredBatteries;
    }

    @Override
    public long calculate(BatteryBank batteryBank) {
        return findMaximumNumber(batteryBank.ratings());
    }

    private long findMaximumNumber(String digits) {
        StringBuilder result = new StringBuilder();
        int lastSelectedIndex = -1;

        for (int position = 0; position < requiredBatteries; position++) {

            int remainingDigits = requiredBatteries - position - 1;
            int searchLimit = digits.length() - remainingDigits;

            char bestDigit = Character.MIN_VALUE;
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