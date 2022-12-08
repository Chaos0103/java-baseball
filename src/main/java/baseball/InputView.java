package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private final Validate validate = new Validate();

    public List<Integer> readNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
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

    public String readRetry() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();

        validate.checkRetry(input);

        return input;
    }
}
