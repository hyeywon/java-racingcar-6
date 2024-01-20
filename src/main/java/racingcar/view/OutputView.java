package racingcar.view;

import racingcar.dto.GameResponse;

public class OutputView {

    public void carName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void trynum() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void result(GameResponse gameResponse) {
        System.out.println("\n실행 결과");

        for (int i = 0; i < gameResponse.getTrynum(); i++) {
            for (String name : gameResponse.getCarNames()) {
                System.out.println(name + " : " + gameResponse.getResult().remove(0));
            }
            System.out.println();
        }

        String winners = gameResponse.getWinners().toString();
        System.out.println("최종 우승자 : " + winners.substring(1, winners.length()-1));
    }
}
