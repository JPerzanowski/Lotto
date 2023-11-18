package lotto.infrastructure.resultannoucer.controller;

import lombok.AllArgsConstructor;
import lotto.domain.resultannoucer.ResultAnnouncerFacade;
import lotto.domain.resultannoucer.dto.ResultAnnouncerResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ResultAnnouncerRestController {

    ResultAnnouncerFacade resultAnnouncerFacade;

    @GetMapping("/results/{id}")
    public ResponseEntity<ResultAnnouncerResponseDto> checkResultsById(@PathVariable String id) {
        ResultAnnouncerResponseDto resultAnnouncerResponseDto = resultAnnouncerFacade.checkResult(id);
        return ResponseEntity.ok(resultAnnouncerResponseDto);
    }
}
