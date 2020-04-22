package com.alioguzhancicek.mymobiledietician;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

//import com.alioguzhancicek.mymobiledietician.api.AddNewUserAsyncTask;
import com.alioguzhancicek.mymobiledietician.api.ApiUtils;
import com.alioguzhancicek.mymobiledietician.api.DieticianRetrofitClient;
import com.alioguzhancicek.mymobiledietician.api.GetUserInfoAsyncTask;
import com.alioguzhancicek.mymobiledietician.api.ResponseUserInfo;
import com.alioguzhancicek.mymobiledietician.api.UserDto;
import com.alioguzhancicek.mymobiledietician.api.UserInfoClient;
import com.alioguzhancicek.mymobiledietician.api.UserInfoRetrofitRequest;
import com.alioguzhancicek.mymobiledietician.api.enums.ActivityStatus;
import com.alioguzhancicek.mymobiledietician.api.enums.Gender;
import com.alioguzhancicek.mymobiledietician.api.enums.WhatIsNeeded;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.PUT;

public class MainActivity extends AppCompatActivity {
    Button mealsuggestionBtn,learnIdealWeightBtn,informationsBtn;

    private UserInfoRetrofitRequest userInfoRetrofitRequest;
    private UserDto testUser;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MainActivity mainActivity=this;

        learnIdealWeightBtn=findViewById(R.id.learnIdealWeightBtn);
        informationsBtn=findViewById(R.id.informationsBtn);
        mealsuggestionBtn=findViewById(R.id.mealSuggestionsBtn);
        userInfoRetrofitRequest= ApiUtils.getApiService();

        mealsuggestionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MealSuggestions.class));

//                ArrayList<Long> array=new ArrayList<>();
//                array.add((long)15);
//                GetUserInfoAsyncTask getUserInfoAsyncTask=new GetUserInfoAsyncTask(mainActivity);
//                getUserInfoAsyncTask.execute(array.get(0));


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

}
