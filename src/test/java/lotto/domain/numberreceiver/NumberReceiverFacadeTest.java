package lotto.domain.numberreceiver;

import lotto.domain.AdjustableClock;
import lotto.domain.numberreceiver.NumberReceiverFacade;
import lotto.domain.numberreceiver.dto.InputNumberResultDto;
import lotto.domain.numberreceiver.dto.TicketDto;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class NumberReceiverFacadeTest {

    AdjustableClock clock = new AdjustableClock(LocalDateTime.of(2023, 2, 15, 12, 0, 0)
            .toInstant(ZoneOffset.UTC), ZoneId.systemDefault());

    NumberReceiverFacade numberReceiverFacade = new NumberReceiverFacade(
            new NumberValidator(),
            new InMemoryNumberReceiverRepositoryTestImpl(),
            clock
    );

    @Test
    void should_return_success_when_user_gave_six_numbers() {
        Set<Integer> numbersFromUser = Set.of(6, 7, 8, 40, 1, 78);
        InputNumberResultDto result = numberReceiverFacade.inputNumbers(numbersFromUser);
        assertThat(result.message()).isEqualTo("Success");
    }

    @Test
    void should_return_failed_when_user_gave_more_than_six_numbers() {
        Set<Integer> numbersFromUser = Set.of(6, 7, 8, 40, 1, 78, 65, 43);
        InputNumberResultDto result = numberReceiverFacade.inputNumbers(numbersFromUser);
        assertThat(result.message()).isEqualTo("Fail");
    }

    @Test
    void should_return_failed_when_user_gave_less_than_six_numbers() {
        Set<Integer> numbersFromUser = Set.of(6, 7, 8, 40);
        InputNumberResultDto result = numberReceiverFacade.inputNumbers(numbersFromUser);
        assertThat(result.message()).isEqualTo("Fail");
    }

    @Test
    void should_return_failed_when_user_gave_at_least_one_number_out_of_range_of_1_to_99() {
        Set<Integer> numbersFromUser = Set.of(1, 1000, 3, 5, 8, 9);
        InputNumberResultDto result = numberReceiverFacade.inputNumbers(numbersFromUser);
        assertThat(result.message()).isEqualTo("Fail");
    }

    @Test
    void should_save_to_database_when_user_gave_six_numbers() {
        //given
        Set<Integer> numbersFromUser = Set.of(1, 2, 3, 4, 5, 6);
        InputNumberResultDto result = numberReceiverFacade.inputNumbers(numbersFromUser);
        LocalDateTime drawDate = LocalDateTime.of(2023, 2, 15, 13, 0, 0);
        //when
        List<TicketDto> ticketDtos = numberReceiverFacade.userNumbers(drawDate);
        assertThat(ticketDtos).contains(
                TicketDto.builder()
                        .ticketId(result.ticketId())
                        .drawDate(drawDate)
                        .numbersFromUser(result.numbersFromUser())
                        .build()
        );
    }
}