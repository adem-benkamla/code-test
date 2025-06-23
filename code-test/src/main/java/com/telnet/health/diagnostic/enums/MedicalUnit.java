package com.telnet.health.diagnostic.enums;

public enum MedicalUnit {
    CARDIOLOGY("Cardiologie"),
    TRAUMATOLOGY("Traumatologie");

    private final String displayName;

    MedicalUnit(String displayName) {
        this.displayName = displayName;
    }
    public String getDisplayName() { return displayName; }
}
