package racingcar.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameRequest {

    private List<String> carNames;
    private Integer trynum;

    public GameRequest(String carNames, String trynum) {
        validate(carNames, trynum);
    }

    private void validate(String carNames, String trynum) {     // todo: exception handling
        carNameValidate(carNames);
        trynumValidate(trynum);
    }

    private void carNameValidate(String carNames) {
        carNames = carNames.replace(" ", "");
        String[] names = carNames.split(",");

        if (Arrays.stream(names)
                .anyMatch(n -> n.length() > 5)) {
            throw new IllegalArgumentException("잘못된 이름 입력");
        }

        this.carNames = new ArrayList<>(Arrays.asList(names));
    }

    private void trynumValidate(String trynum) {
        trynum = trynum.replace(" ", "");

        this.trynum = Integer.parseInt(trynum);     // todo: 에러 메시지?
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public Integer getTrynum() {
        return trynum;
    }
}
