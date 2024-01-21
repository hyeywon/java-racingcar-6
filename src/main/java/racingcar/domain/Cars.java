package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<String> move() {
        cars.forEach(this::stepForwardByRandom);
        return cars.stream()
                .map(Car::getSteps)
                .toList();
    }

    private void stepForwardByRandom(Car car) {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            car.forward();
        }
    }

    public List<String> findWinners() {
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
