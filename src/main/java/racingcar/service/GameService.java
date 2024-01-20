package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.dto.GameRequest;
import racingcar.dto.GameResponse;

public class GameService {

    public GameResponse play(GameRequest gameRequest) {
        List<Car> cars = initCars(gameRequest.getCarNames());
        List<String> result = new ArrayList<>();

        for (int i = 0; i < gameRequest.getTrynum(); i++) {
            move(cars);
            result.addAll(cars.stream()
                    .map(Car::getSteps)
                    .toList());
        }
        return new GameResponse(gameRequest, result, findWinners(cars));
    }

    private List<Car> initCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new).collect(Collectors.toList());
    }

    private void move(List<Car> cars) {
        cars.forEach(this::stepForwardByRandom);
    }

    private void stepForwardByRandom(Car car) {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            car.forward();
        }
    }

    private List<String> findWinners(List<Car> cars) {
        int maxval = findMaxval(cars);
        return cars.stream()
                .filter(car -> car.getSteps().length() == maxval)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int findMaxval(List<Car> cars) {
        return cars.stream()
                .mapToInt(car -> car.getSteps().length())
                .max()
                .orElse(0);
    }
}
