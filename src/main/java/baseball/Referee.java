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

        StringBuilder message = new StringBuilder();
        if (ball != 0) {
            message.append(ball).append("볼 ");
        }
        if (strike != 0) {
            message.append(strike).append("스트라이크");
        }

        return String.valueOf(message);
    }
}
