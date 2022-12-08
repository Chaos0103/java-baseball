package baseball;

import java.util.List;

public class Referee {

    private final Judgment judgment = new Judgment();

    public String compare(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        int strike = 0;
        int ball = judgment.correctCount(computerNumbers, playerNumbers);

        for (int i = 0; i < Constants.SIZE; i++) {
            boolean isStrike = judgment.hasPlace(computerNumbers, i, playerNumbers.get(i));
            if (isStrike) {
                strike++;
                ball--;
            }
        }

        if (strike == 0 && ball == 0) {
            return "낫싱";
        }
        if (strike == 0) {
            return ball + "볼";
        }
        if (ball == 0) {
            return strike + "스트라이크";
        }
        return ball + "볼 " + strike + "스트라이크";
    }
}
