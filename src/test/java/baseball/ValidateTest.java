package baseball;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

class ValidateTest {

    private final Validate validate = new Validate();

    @ParameterizedTest
    @ValueSource(strings = {"123", "404", "1234", "12"})
    void checkType(String input) {
        validate.checkType(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"12,", "28A", "2 3"})
    void checkTypeException(String input) {
        assertThatThrownBy(() -> validate.checkType(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "404"})
    void checkRange(String input) {
        List<Integer> numbers = getNumbers(input);
        validate.checkRange(numbers);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1234", "41"})
    void checkRangeException(String input) {
        List<Integer> numbers = getNumbers(input);
        assertThatThrownBy(() -> validate.checkRange(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "392", "414"})
    void checkNumberRange(String input) {
        List<Integer> numbers = getNumbers(input);
        validate.checkNumberRange(numbers);
    }

    @ParameterizedTest
    @ValueSource(strings = {"103", "092", "130"})
    void checkNumberRangeException(String input) {
        List<Integer> numbers = getNumbers(input);
        assertThatThrownBy(() -> validate.checkNumberRange(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "927", "128"})
    void checkNumberDuplicate(String input) {
        List<Integer> numbers = getNumbers(input);
        validate.checkNumberDuplicate(numbers);
    }

    @ParameterizedTest
    @ValueSource(strings = {"121", "111", "112", "211"})
    void checkNumberDuplicateException(String input) {
        List<Integer> numbers = getNumbers(input);
        assertThatThrownBy(() -> validate.checkNumberDuplicate(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private List<Integer> getNumbers(String input) {
        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}