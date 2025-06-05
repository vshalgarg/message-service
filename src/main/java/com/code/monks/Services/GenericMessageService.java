package com.code.monks.Services;

import com.code.monks.dtos.request.BaseMessageRequestDto;

public interface GenericMessageService <T extends BaseMessageRequestDto> {
    void sendMessage(T request);
}

