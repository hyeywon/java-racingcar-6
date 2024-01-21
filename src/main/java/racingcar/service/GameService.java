package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.dto.GameRequest;
import racingcar.dto.GameResponse;

public class GameService {

    public GameResponse play(GameRequest gameRequest) {
        Cars cars = createCars(gameRequest.getCarNames());
        List<String> result = new ArrayList<>();

        for (int i = 0; i < gameRequest.getTrynum(); i++) {
            result.addAll(cars.move());
        }
        return new GameResponse(gameRequest, result, cars.findWinners());
    }

    private Cars createCars(List<String> carNames) {
        return new Cars(carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList()));
    }
}
