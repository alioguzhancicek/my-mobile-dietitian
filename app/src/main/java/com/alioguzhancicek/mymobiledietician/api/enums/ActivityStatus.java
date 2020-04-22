package com.alioguzhancicek.mymobiledietician.api.enums;

public enum ActivityStatus {


    INACTIVE(1),
    LESSACTIVE(2),
    ACTIVE(3),
    VERYACTIVE(4),
    SUPERACTIVE(5);


    private final int val;

    private ActivityStatus(int val) {
        this.val = val;
    }
}
