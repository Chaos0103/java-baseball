package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private final Validate validate = new Validate();

    public List<Integer> readNumbers() {
        String input = Console.readLine();

        validate.checkType(input);
        List<Integer> numbers = Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        validate.checkRange(numbers);
        validate.checkNumberRange(numbers);
        validate.checkNumberDuplicate(numbers);

        return numbers;
    }

    public void readRetry() {

    }
}
