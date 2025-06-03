package com.code.monks.enums;

public enum MessageTypeEnum {
    SMS("sms"),
    EMAIL("email"),
    WHATSAPP("whatsapp");

    private final String type;

    MessageTypeEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static MessageTypeEnum fromString(String type) {
        for (MessageTypeEnum mt : values()) {
            if (mt.type.equalsIgnoreCase(type)) return mt;
        }
        throw new IllegalArgumentException("Unknown type: " + type);
    }
}
