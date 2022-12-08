package baseball;

import java.util.List;
import java.util.stream.Collectors;

public class Validate {

    public void checkType(String input) {
        if (!isDigit(input)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isDigit(String input) {
        return input.chars().allMatch(Character::isDigit);
    }

    public void checkRange(List<Integer> numbers) {
        if (numbers.size() != Constants.SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public void checkNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (isOutOfRange(number)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private boolean isOutOfRange(int number) {
        return !(Constants.MIN_RANGE <= number && number <= Constants.MAX_RANGE);
    }

    public void checkNumberDuplicate(List<Integer> numbers) {
        List<Integer> target = numbers.stream().distinct().collect(Collectors.toList());
        if (numbers.size() != target.size()) {
            throw new IllegalArgumentException();
        }
    }

    public void checkRetry() {

    }
}
