package com.Authentification.System.Enum;

public enum role {
    ADMIN(1),
    USER(2);

    private final int value;

    role(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
