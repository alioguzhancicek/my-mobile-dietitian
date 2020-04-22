package com.alioguzhancicek.mymobiledietician.api.enums;

public enum WhatIsNeeded {

    LOSEWEIGHT(1),
    SAVEWEIGHT(2),
    GAINWEIGHT(3);


    private final int  val;

    private WhatIsNeeded(int val) {
        this.val = val;
    }
}
