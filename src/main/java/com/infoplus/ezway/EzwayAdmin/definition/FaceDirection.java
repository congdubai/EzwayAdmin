package com.infoplus.ezway.EzwayAdmin.definition;

import lombok.Getter;

@Getter
public enum FaceDirection {
    FRONT("F"),
    LEFT("L"),
    RIGHT("R"),
    DEPTH("D");
    private final String value;

    FaceDirection(String value) {
        this.value = value;
    }
}
