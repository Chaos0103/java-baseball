package baseball;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

class JudgmentTest {

    private final Judgment judgment = new Judgment();
    private final List<Integer> computerNumbers = List.of(1, 2, 3);

    @ParameterizedTest
    @CsvSource({"123,3", "124,2", "145,1", "987,0"})
    void correctCount(String player, int expected) {
        List<Integer> playerNumbers = getNumbers(player);

        int count = judgment.correctCount(computerNumbers, playerNumbers);

        assertThat(count).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"0,1,true", "1,2,true", "2,3,true", "0,2,false"})
    void hasPlace(int placeIndex, int playerNumber, boolean expected) {
        boolean result = judgment.hasPlace(computerNumbers, placeIndex, playerNumber);

        assertThat(result).isEqualTo(expected);
    }

    private List<Integer> getNumbers(String input) {
        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}