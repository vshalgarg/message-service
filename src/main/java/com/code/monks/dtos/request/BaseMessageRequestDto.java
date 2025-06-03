package com.code.monks.dtos.request;

import lombok.Data;

@Data
public abstract class BaseMessageRequestDto {

    private String recipient;
    private String content;
}
