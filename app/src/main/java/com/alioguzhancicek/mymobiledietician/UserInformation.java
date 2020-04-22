package com.alioguzhancicek.mymobiledietician;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.alioguzhancicek.mymobiledietician.api.ApiUtils;
import com.alioguzhancicek.mymobiledietician.api.UserDto;
import com.alioguzhancicek.mymobiledietician.api.UserInfoRetrofitRequest;
import com.alioguzhancicek.mymobiledietician.api.enums.ActivityStatus;
import com.alioguzhancicek.mymobiledietician.api.enums.Gender;
import com.alioguzhancicek.mymobiledietician.api.enums.WhatIsNeeded;
import com.google.firebase.auth.FirebaseAuth;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserInformation extends AppCompatActivity {
    private UserInfoRetrofitRequest userInfoRetrofitRequest;

    TextView agetv,weighttv,heighttv;
    RadioGroup genderRadioGroup,activityRadioGroup,purposeRadioGroup;
    RadioButton malebutton,femalebutton,inactivebutton,lessactivebutton,activebutton,veryactivebutton,superactivebutton,loseweightbutton,saveweightbutton,gainweightbutton;
    Button calculatebutton;
    UserDto userDto;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_information);
        agetv=findViewById(R.id.ageTv);
        weighttv=findViewById(R.id.weightTv);
        heighttv=findViewById(R.id.heightTv);
        genderRadioGroup=findViewById(R.id.radioGroup);
        activityRadioGroup=findViewById(R.id.activityRgrp);
        malebutton=findViewById(R.id.maleRbtn);
        femalebutton=findViewById(R.id.femaleRbtn);
        inactivebutton=findViewById(R.id.inactiveRbtn);
        lessactivebutton=findViewById(R.id.lessactiveRbtn);
        activebutton=findViewById(R.id.activeRbtn);
        veryactivebutton=findViewById(R.id.veryactiveRbtn);
        superactivebutton=findViewById(R.id.superactiveRbtn);
        calculatebutton=findViewById(R.id.calculaterButton);
        purposeRadioGroup=findViewById(R.id.purposeRadioGroup);
        loseweightbutton=findViewById(R.id.loseWeightBtn);
        saveweightbutton=findViewById(R.id.saveWeightBtn);
        gainweightbutton=findViewById(R.id.gainWeightBtn);

        userInfoRetrofitRequest= ApiUtils.getApiService();
        userDto=new UserDto();
        firebaseAuth=FirebaseAuth.getInstance();

        Bundle extras=getIntent().getExtras();
        if(extras!=null){
            userDto.setName(extras.getString("name"));
        }
        

        calculatebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int genderRadioGroupCheckedRadioButtonId =genderRadioGroup.getCheckedRadioButtonId();
                int activityRadioGroupCheckedRadioButtonId = activityRadioGroup.getCheckedRadioButtonId();
                int purposeRadioGroupCheckedRadioButtonId=purposeRadioGroup.getCheckedRadioButtonId();

                //startActivity(new Intent(getApplicationContext(),MainActivity.class));
                userDto.setEmail(firebaseAuth.getCurrentUser().getEmail());
                userDto.setAge(Integer.parseInt(agetv.getText().toString()));
                userDto.setHeight(Integer.parseInt(heighttv.getText().toString()));
                userDto.setWeight(Integer.parseInt(weighttv.getText().toString()));
                userDto.setDisability(false);

                if(genderRadioGroupCheckedRadioButtonId==malebutton.getId()){
                    userDto.setGender(Gender.MALE);
                }
                else{
                    userDto.setGender(Gender.FEMALE);
                }

                if(activityRadioGroupCheckedRadioButtonId==inactivebutton.getId()) {
                    userDto.setActivityStatus(ActivityStatus.INACTIVE);
                }else if(activityRadioGroupCheckedRadioButtonId==lessactivebutton.getId()){
                    userDto.setActivityStatus(ActivityStatus.LESSACTIVE);
                }else if(activityRadioGroupCheckedRadioButtonId==activebutton.getId()){
                    userDto.setActivityStatus(ActivityStatus.ACTIVE);
                }else if(activityRadioGroupCheckedRadioButtonId==veryactivebutton.getId()){
                    userDto.setActivityStatus(ActivityStatus.VERYACTIVE);
                }else{
                    userDto.setActivityStatus(ActivityStatus.SUPERACTIVE);
                }

                if(purposeRadioGroupCheckedRadioButtonId==loseweightbutton.getId()){
                    userDto.setWhatIsNeeded(WhatIsNeeded.LOSEWEIGHT);
                }else if(purposeRadioGroupCheckedRadioButtonId==saveweightbutton.getId()){
                    userDto.setWhatIsNeeded(WhatIsNeeded.SAVEWEIGHT);
                }else{
                    userDto.setWhatIsNeeded(WhatIsNeeded.GAINWEIGHT);
                }


                sendRequest(userDto);

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.options_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.logOutOption:

                FirebaseAuth.getInstance().signOut();
                Toast.makeText(this,"You logged out!",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),Login.class));
                break;

        }
        return true;
    }

    public void sendRequest(UserDto userDto){
        userInfoRetrofitRequest.addNewUser(userDto).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });

    }

}

