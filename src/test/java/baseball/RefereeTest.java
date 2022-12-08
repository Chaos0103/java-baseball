package baseball;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

class RefereeTest {

    private final Referee referee = new Referee();
    private final List<Integer> computerNumbers = List.of(1, 2, 3);

    @ParameterizedTest
    @CsvSource({"123,3스트라이크", "321,2볼 1스트라이크", "356,1볼", "456, 낫싱"})
    void compare(String player, String expected) {
        List<Integer> playerNumbers = getNumbers(player);

        String message = referee.compare(computerNumbers, playerNumbers);

        assertThat(message).isEqualTo(expected);
    }

    private List<Integer> getNumbers(String input) {
        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}