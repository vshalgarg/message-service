package com.code.monks.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmailRequestDto {
    private String email;
    private String subject;
    private String body;
}
