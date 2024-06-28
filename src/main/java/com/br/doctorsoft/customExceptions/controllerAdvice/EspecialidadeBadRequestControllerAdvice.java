package com.br.doctorsoft.customExceptions.controllerAdvice;

import com.br.doctorsoft.customExceptions.exceptionHandler.ApiError;
import com.br.doctorsoft.customExceptions.exceptionHandler.GeneralErrorResponse;
import com.br.doctorsoft.exceptions.Medicos.EspecialidadeMedicaBadRequest;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class EspecialidadeBadRequestControllerAdvice {

    @ExceptionHandler(EspecialidadeMedicaBadRequest.class)
    public ResponseEntity<ApiError> especialidadeNaoExiste(EspecialidadeMedicaBadRequest exception,
                                                                       HttpServletRequest request){

        var messageErrors =
                ApiError.DataMessageErrors
                        .builder()
                        .message("A especialidade não foi encontrada")
                        .description(exception.getMessage())
                        .localDateTime(LocalDateTime.now())
                        .statusValue(HttpStatus.BAD_REQUEST.value())
                        .build();

        var apiError = ApiError.builder()
                               .dataMessageErrors(messageErrors)
                               .httpStatus(HttpStatus.BAD_REQUEST)
                               .build();

        return new ResponseEntity<ApiError>(apiError,HttpStatus.BAD_REQUEST);

    }
}
