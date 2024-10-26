package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class GameResult {
    private final List<GameRoundResult> roundResults;

    public GameResult() {
        this.roundResults = new ArrayList<>();
    }

    public List<GameRoundResult> getRoundResults() {
        return this.roundResults;
    }

    public Integer findMaxMoveCount() {
        return roundResults.stream()
                .flatMap(roundResult -> roundResult.getCars().getCars().stream())
                .mapToInt(Car::getMoveCount)
                .max()
                .orElse(0);
    }

    public void saveRoundResult(GameRoundResult gameRoundResult) {
        this.roundResults.add(gameRoundResult);
    }

    public Cars getCarsAtFinalRound() {
        return this.roundResults
                .getLast()
                .getCars();
    }
}
