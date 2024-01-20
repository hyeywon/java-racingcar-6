package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.dto.GameDto;

public class GameService {

    public void play(GameDto gameDto) {
        List<Car> cars = initCars(gameDto.getCarNames());
        List<String> result = new ArrayList<>();

        for (int i = 0; i < gameDto.getTrynum(); i++) {
            result.addAll(turn(cars).stream()
                    .map(Car::getSteps)
                    .toList());
        }

    }

    private List<Car> initCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new).collect(Collectors.toList());
    }

    private List<Car> turn(List<Car> cars) {  // todo: 메소드명
        cars.forEach(this::stepForwardByRandom);
        return cars;
    }

    private void stepForwardByRandom(Car car) {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            car.forward();
        }
    }
}
