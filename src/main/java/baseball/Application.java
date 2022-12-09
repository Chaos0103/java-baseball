package baseball;

import java.util.List;

import static baseball.Constants.*;

public class Application {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final NumberGenerator numberGenerator = new NumberGenerator();
    private static final Referee referee = new Referee();

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computerNumber = numberGenerator.createRandomNumbers();

        while (true) {
            List<Integer> playerNumbers = inputView.readNumbers();

            String message = referee.compare(computerNumber, playerNumbers);
            outputView.printResult(message);

            if (message.equals("3스트라이크")) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                String retry = inputView.readRetry();
                if (retry.equals(RETRY)) {
                    computerNumber = numberGenerator.createRandomNumbers();
                    continue;
                }
                break;
            }
        }
    }
}
