package com.code.monks.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SmsRequestDto implements MessageRequest{
    private String toPhoneNumber;
    private String message;

    @Override
    public String getTo() {
        return toPhoneNumber;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
