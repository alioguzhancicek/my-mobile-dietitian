package com.alioguzhancicek.mymobiledietician.api;

import com.alioguzhancicek.mymobiledietician.api.enums.ActivityStatus;
import com.alioguzhancicek.mymobiledietician.api.enums.DietTypes;
import com.alioguzhancicek.mymobiledietician.api.enums.Gender;
import com.alioguzhancicek.mymobiledietician.api.enums.WhatIsNeeded;

import lombok.Getter;

@Getter
public class ResponseUserInfo {

    private String email;

    private int age;

    private Gender gender;

    private ActivityStatus activityStatus;

    private int weight;

    private int height;

    private WhatIsNeeded whatIsNeeded;

    private boolean disability;

    public double neededCalori;

    public double bki;

    public double idealWeight;

    private DietTypes whichDietType;

}
