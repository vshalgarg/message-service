package com.code.monks.Services.impl;

import com.code.monks.Services.GenericMessageService;
import com.code.monks.config.TwilioConfig;
import com.code.monks.dtos.request.SmsRequestDto;
import com.twilio.exception.TwilioException;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SmsServiceImpl implements GenericMessageService<SmsRequestDto> {
    private final TwilioConfig twilioConfig;
    public void sendMessage(SmsRequestDto request) {
        try {
            log.info("Attempting to send SMS to {}", request.getRecipient());
            Message message =  Message.creator(
                    new PhoneNumber(request.getRecipient()),
                    new PhoneNumber(twilioConfig.getFromNumber()),
                    request.getContent()
            ).create();
            log.debug("SMS sent successfully. SID: {}", message.getSid());
        }
        catch (TwilioException e){
            log.error("Twilio general exception when sending SMS", e);
            throw e;
        }
    }
}
