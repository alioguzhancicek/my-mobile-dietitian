package com.alioguzhancicek.mymobiledietician.api;



import com.alioguzhancicek.mymobiledietician.api.enums.ActivityStatus;
import com.alioguzhancicek.mymobiledietician.api.enums.Gender;
import com.alioguzhancicek.mymobiledietician.api.enums.WhatIsNeeded;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {


    private String email;


    private int age;


    private Gender gender;


    private ActivityStatus activityStatus;


    private int weight;


    private int height;



    private boolean disability;


    private String name;


    private WhatIsNeeded whatIsNeeded;







}
