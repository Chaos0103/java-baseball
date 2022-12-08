package baseball;

public class Validate {

    public void checkType(String input) {
        if (!isDigit(input)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isDigit(String input) {
        return input.chars().allMatch(Character::isDigit);
    }

    public void checkRange() {

    }

    public void checkNumberRange() {

    }

    public void checkNumberDuplicate() {

    }

    public void checkRetry() {

    }
}
