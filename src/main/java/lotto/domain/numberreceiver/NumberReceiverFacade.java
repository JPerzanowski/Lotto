package lotto.domain.numberreceiver;

import java.util.List;

public class NumberReceiverFacade {
    public String inputNumbers(List<Integer> numbers) {
        int size = numbers.size();
        if (size != 6)
            return "Fail";
        return "Success";
    }
}
