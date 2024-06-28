package com.br.doctorsoft.customExceptions.exceptionHandler;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiError{

    private HttpStatus httpStatus;
    private DataMessageErrors dataMessageErrors;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DataMessageErrors{

        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
        private LocalDateTime localDateTime;
        private String message;
        private String description;
        private int statusValue;
    }


}
