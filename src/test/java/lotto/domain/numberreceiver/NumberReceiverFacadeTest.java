package lotto.domain.numberreceiver;

import lotto.domain.numberreceiver.NumberReceiverFacade;
import org.junit.jupiter.api.Test;

import java.util.List;

class NumberReceiverFacadeTest {

    @Test
    void should_return_success_when_user_give_6_numbers() {
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverFacade();
        String result = numberReceiverFacade.inputNumbers(List.of(6, 7, 8, 40, 1, 78));
        assert result.equals("Success");
    }

    @Test
    void should_return_fal_when_user_give_more_than_6_numbers() {
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverFacade();
        String result = numberReceiverFacade.inputNumbers(List.of(6, 7, 8, 40, 1, 78, 65, 43));
        assert result.equals("Fail");
    }

    @Test
    void should_return_fal_when_user_give_less_than_6_numbers() {
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverFacade();
        String result = numberReceiverFacade.inputNumbers(List.of(6, 7, 8, 40));
        assert result.equals("Fail");
    }
}