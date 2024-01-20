package racingcar.dto;

import java.util.List;

public class GameResponse {

    private List<String> carNames;
    private Integer trynum;
    private List<String> result;
    private List<String> winners;

    public GameResponse(GameRequest gameRequest, List<String> result, List<String> winners) {
        this.carNames = gameRequest.getCarNames();
        this.trynum = gameRequest.getTrynum();
        this.result = result;
        this.winners = winners;
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public Integer getTrynum() {
        return trynum;
    }

    public List<String> getResult() {
        return result;
    }

    public List<String> getWinners() {
        return winners;
    }
}
