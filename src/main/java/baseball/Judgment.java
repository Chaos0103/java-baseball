package baseball;

import java.util.List;

public class Judgment {

    public int correctCount(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        int count = 0;
        for (Integer playerNumber : playerNumbers) {
            if (computerNumbers.contains(playerNumber)) {
                count++;
            }
        }
        return count;
    }

    public boolean hasPlace() {
        return true;
    }
}
