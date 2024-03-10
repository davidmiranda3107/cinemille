package com.lascaux.cinemille.enums;

public enum State {
	ACTIVE(1), INACTIVE(0);
	
	private final int value;

    State(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
