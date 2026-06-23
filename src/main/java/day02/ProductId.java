package day02;

public record ProductId(long value) {

    public boolean isInvalid() {
        String text = String.valueOf(value);

        if (text.length() % 2 != 0) {
            return false;
        }

        return isRepeatedPattern(text, text.length() / 2);
    }

    public boolean isInvalidWithRepeatedPattern() {
        String text = String.valueOf(value);

        for (int patternLength = 1; patternLength <= text.length() / 2; patternLength++) {
            if (isRepeatedPattern(text, patternLength)) {
                return true;
            }
        }

        return false;
    }

    private boolean isRepeatedPattern(String text, int patternLength) {
        if (patternLength == 0 || text.length() % patternLength != 0) {
            return false;
        }

        String pattern = text.substring(0, patternLength);

        for (int index = patternLength; index < text.length(); index += patternLength) {
            if (!text.substring(index, index + patternLength).equals(pattern)) {
                return false;
            }
        }

        return true;
    }
}