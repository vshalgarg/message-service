package com.code.monks.Services.impl;

import com.code.monks.Services.GenericMessageService;
import com.code.monks.dtos.request.SmsRequestDto;
import com.code.monks.enums.MessageTypeEnum;
import org.springframework.stereotype.Service;

@Service
public class SmsServiceImpl implements GenericMessageService<SmsRequestDto> {
    public void sendMessage(SmsRequestDto request) {
        System.out.println("Sending SMS to " + request.getRecipient());
    }

    public MessageTypeEnum getType() {
        return MessageTypeEnum.SMS;
    }

    public Class<SmsRequestDto> getRequestClass() {
        return SmsRequestDto.class;
    }
}
