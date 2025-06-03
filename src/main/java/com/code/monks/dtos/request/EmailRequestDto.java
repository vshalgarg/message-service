package com.code.monks.dtos.request;

import lombok.Data;

@Data
public class EmailRequestDto extends BaseMessageRequestDto{

    private String subject;
}
