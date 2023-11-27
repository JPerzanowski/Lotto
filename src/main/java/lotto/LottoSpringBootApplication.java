package lotto;

import lotto.domain.numbergenerator.WinningNumbersGeneratorFacadeConfigurationProperties;
import lotto.infrastructure.security.jwt.JwtConfigurationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableConfigurationProperties(value = {WinningNumbersGeneratorFacadeConfigurationProperties.class, JwtConfigurationProperties.class})
@EnableMongoRepositories
public class LottoSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(LottoSpringBootApplication.class, args);
    }
}