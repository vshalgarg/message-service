package com.code.monks.Service;

import com.code.monks.config.TwilioConfig;
import com.code.monks.dtos.request.SmsRequestDto;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WhatsAppService {

    private final TwilioConfig twilioConfig;
    public void sendWhatsapp(SmsRequestDto smsRequest) {
        if (smsRequest.getPhoneNumber() == null || smsRequest.getMessage() == null || twilioConfig.getFromNumber() == null) {
            throw new IllegalArgumentException("Phone number, message or fromNumber cannot be null");
        }

        Message.creator(
                new PhoneNumber("whatsapp:" + smsRequest.getPhoneNumber()),
                new PhoneNumber("whatsapp:14155238886"),
                smsRequest.getMessage()
        ).create();
    }
}
