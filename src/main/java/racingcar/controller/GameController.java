package racingcar.controller;

import racingcar.dto.GameDto;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final GameService gameService = new GameService();

    public void play() {    // todo: refactor
        outputView.carName();
        String carNames = inputView.carNames();

        outputView.trynum();
        String trynum = inputView.trynum();

        GameDto gameDto = new GameDto(carNames, trynum);

        gameService.play(gameDto);

    }
}
