package com.example.reactive.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorBodyDTO {
    private String type;
    private String title;
    private int status;
    private String detail;
}
