package lotto.infrastructure.resultannoucer.controller.error;

import lombok.extern.log4j.Log4j2;
import lotto.domain.resultchecker.PlayerResultNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Log4j2
public class ResultAnnouncerControllerErrorHandler {
    @ExceptionHandler(PlayerResultNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResultAnnouncerErrorResponse handlerPlayerResultNotFound(PlayerResultNotFoundException exception) {
        String message = exception.getMessage();
        log.info(message);
        return new ResultAnnouncerErrorResponse(message, HttpStatus.NOT_FOUND);
    }
}