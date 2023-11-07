package lotto.domain.numbergenerator;

import java.time.LocalDateTime;
import java.util.Optional;

//@Repository
public interface WinningNumbersRepository {
    Optional<WinningNumbers> findNumbersByDate(LocalDateTime date);

    boolean existsByDate(LocalDateTime nextDrawDate);

    WinningNumbers save(WinningNumbers winningNumbers);
}
