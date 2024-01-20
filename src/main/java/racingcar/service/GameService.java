package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.dto.GameDto;

public class GameService {

    public void play(GameDto gameDto) {
        Cars cars = create(gameDto.getCarNames());

    }

    private Cars create(List<String> carNames) {
        return new Cars(carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList()));
    }
}
