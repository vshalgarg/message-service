package com.code.monks.Service;

import com.code.monks.dtos.request.MessageRequest;

public interface MessageService <T extends MessageRequest> {
    void sendMessage(T request);
}
