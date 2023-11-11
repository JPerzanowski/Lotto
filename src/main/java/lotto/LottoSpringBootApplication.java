package lotto;

import lotto.infrastructure.AasdasdRepository;
import lotto.infrastructure.Ticket;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LottoSpringBootApplication implements CommandLineRunner {

    @Autowired
    AasdasdRepository aasdasd;

    public static void main(String[] args) {
        SpringApplication.run(LottoSpringBootApplication.class, args);
    }

    @Override
    public void run(String... args) {
        aasdasd.save(new Ticket("asdasd"));
    }
}