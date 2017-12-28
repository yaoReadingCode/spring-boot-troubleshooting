package com.example.bitbythecron.springboottroubleshooting

import com.example.bitbythecron.springboottroubleshooting.ErrorResponse
import groovy.util.logging.Slf4j
import org.apache.commons.lang3.exception.ExceptionUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@Slf4j
@ControllerAdvice
class AppExceptionMapper extends ResponseEntityExceptionHandler {
    static HttpStatus CLIENT_ERROR = HttpStatus.BAD_REQUEST
    static HttpStatus SERVER_ERROR = HttpStatus.INTERNAL_SERVER_ERROR

    @ExceptionHandler(value = Throwable)
    ResponseEntity<ErrorResponse> handleUncaughtException(Throwable throwable) {
        buildServerErrorResponse(throwable)
    }

    ResponseEntity<ErrorResponse> buildClientErrorResponse(Throwable throwable, String details) {
        buildErrorResponse(throwable, true, details)
    }

    ResponseEntity<ErrorResponse> buildServerErrorResponse(Throwable throwable) {
        buildErrorResponse(throwable, false, 'Oops! Something went wrong.')
    }

    ResponseEntity<ErrorResponse> buildErrorResponse(Throwable throwable, boolean isClientError, String details) {
        log.error(ExceptionUtils.getStackTrace(throwable))

        String receipt = UUID.randomUUID().toString()

        new ResponseEntity<ErrorResponse>(new ErrorResponse(receipt, details),
            isClientError? CLIENT_ERROR : SERVER_ERROR)
    }
}
