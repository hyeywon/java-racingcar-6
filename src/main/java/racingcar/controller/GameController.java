package racingcar.controller;

import racingcar.dto.GameRequest;
import racingcar.dto.GameResponse;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final GameService gameService = new GameService();

    public void play() {
        outputView.carName();
        String carNames = inputView.carNames();
        outputView.trynum();
        String trynum = inputView.trynum();

        GameRequest gameRequest = new GameRequest(carNames, trynum);

        GameResponse gameResponse = gameService.play(gameRequest);

        outputView.result(gameResponse);
    }
}
