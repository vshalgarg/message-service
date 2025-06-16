package com.code.monks.Services;

public interface GenericMessageService <T> {
    void sendMessage(T request);
}

