package racingcar.domain;

public class Car {

    private final static String STEP = "-";
    private String name;
    private String steps;

    public Car(String name) {
        this.name = name;
        this.steps = "";
    }

    public void forward() {
        this.steps += STEP;
    }

    public String getName() {
        return name;
    }

    public String getSteps() {
        return steps;
    }
}
