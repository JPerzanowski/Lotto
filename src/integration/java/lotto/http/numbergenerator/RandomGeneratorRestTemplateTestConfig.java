package lotto.http.numbergenerator;

import lotto.domain.numbergenerator.RandomNumberGenerable;
import lotto.infrastructure.numbergenerator.http.RandomGeneratorClientConfig;
import org.springframework.web.client.RestTemplate;

public class RandomGeneratorRestTemplateTestConfig extends RandomGeneratorClientConfig {

    public RandomNumberGenerable remoteNumberGeneratorClient(int port, int connectionTimeout, int readTimeout) {
        RestTemplate restTemplate = restTemplate(connectionTimeout, readTimeout, restTemplateResponseErrorHandler());
        return remoteNumberGeneratorClient(restTemplate, "http://localhost", port);
    }
}
