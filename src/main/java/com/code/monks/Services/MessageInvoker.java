package com.code.monks.Services;

import com.code.monks.dtos.request.BaseMessageRequestDto;
import com.code.monks.enums.MessageTypeEnum;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/*
This class is responsible for routing messages
to the correct service based on their type (like EMAIL, SMS, etc.)
 */
@Component
public class MessageInvoker {

    private final Map<MessageTypeEnum, GenericMessageService<? extends BaseMessageRequestDto>> serviceMap = new EnumMap<>(MessageTypeEnum.class);

    @Autowired
    public MessageInvoker(List<GenericMessageService<? extends BaseMessageRequestDto>> services) {
        for (GenericMessageService<? extends BaseMessageRequestDto> service : services) {
            serviceMap.put(service.getType(), service);
        }
    }

    public void dispatch(String typeStr, String jsonPayload) throws Exception {
        MessageTypeEnum type = MessageTypeEnum.fromString(typeStr);
        GenericMessageService<? extends BaseMessageRequestDto> service = serviceMap.get(type);

        if (service == null) throw new IllegalArgumentException("No service for type: " + type);

        BaseMessageRequestDto req = new ObjectMapper().readValue(jsonPayload, service.getRequestClass());
        sendMessageTyped(service, req);
    }

    /*
     Purpose:
Handles the type casting safely and
then calls the actual sendMessage(...) method.
     */
    @SuppressWarnings("unchecked")
    private <T extends BaseMessageRequestDto> void sendMessageTyped(GenericMessageService<T> service, BaseMessageRequestDto req) {
        service.sendMessage((T) req);
    }
}
