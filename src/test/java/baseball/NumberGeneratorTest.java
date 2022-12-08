package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

class NumberGeneratorTest {

    private final NumberGenerator numberGenerator = new NumberGenerator();
    private List<Integer> randomNumbers;

    @BeforeEach
    void setUp() {
        randomNumbers = numberGenerator.createRandomNumbers();
    }

    @Test
    void createRandomNumbersSize() {
        assertThat(randomNumbers.size()).isEqualTo(3);
    }

    @Test
    void createRandomNumbersDuplicate() {
        List<Integer> collect = randomNumbers.stream().distinct().collect(Collectors.toList());

        assertThat(randomNumbers.size()).isEqualTo(collect.size());
    }

    @Test
    void createRandomNumbersRange() {
        for (Integer number : randomNumbers) {
            assertThat(number).isBetween(Constants.MIN_RANGE, Constants.MAX_RANGE);
        }
    }
}