package com.code.monks.Services.impl;

import com.code.monks.Services.GenericMessageService;
import com.code.monks.config.TwilioConfig;
import com.code.monks.dtos.request.SmsRequestDto;
import com.code.monks.enums.MessageTypeEnum;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SmsServiceImpl implements GenericMessageService<SmsRequestDto> {
    private final TwilioConfig twilioConfig;
    public void sendMessage(SmsRequestDto request) {
        Message.creator(
                new PhoneNumber(request.getRecipient()),
                new PhoneNumber(twilioConfig.getFromNumber()),
                request.getContent()
        ).create();
    }

    public MessageTypeEnum getType() {
        return MessageTypeEnum.SMS;
    }

    public Class<SmsRequestDto> getRequestClass() {
        return SmsRequestDto.class;
    }
}
