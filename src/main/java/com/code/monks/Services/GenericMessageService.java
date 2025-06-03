package com.code.monks.Services;

import com.code.monks.dtos.request.BaseMessageRequestDto;
import com.code.monks.enums.MessageTypeEnum;

/*
This is a generic service interface for sending messages like Email, SMS, Push Notifications, etc.
Each implementation will define how to send a message of a specific type.
 */
public interface GenericMessageService <T extends BaseMessageRequestDto> {
    void sendMessage(T request);
    MessageTypeEnum getType();
    Class<T> getRequestClass();
}

