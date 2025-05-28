package com.code.monks.Service;

import com.code.monks.config.TwilioConfig;
import com.code.monks.dtos.request.SmsRequest;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SmsService {
    private final TwilioConfig twilioConfig;

    public void sendSms(SmsRequest smsRequest) {

        if (smsRequest.getPhoneNumber() == null || smsRequest.getMessage() == null || twilioConfig.getFromNumber() == null) {
            throw new IllegalArgumentException("Phone number, message or fromNumber cannot be null");
        }
        Message.creator(
                new PhoneNumber(smsRequest.getPhoneNumber()),
                new PhoneNumber(twilioConfig.getFromNumber()),
                smsRequest.getMessage()
        ).create();
    }
}
