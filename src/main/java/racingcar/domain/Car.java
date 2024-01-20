package racingcar.domain;

public class Car {

    private String name;
    private String steps;

    public Car(String name) {
        this.name = name;
        this.steps = "";
    }

    public void forward() {     // todo: 사실상 setter가 아닌가 ??
        this.steps += "-";
    }
}
