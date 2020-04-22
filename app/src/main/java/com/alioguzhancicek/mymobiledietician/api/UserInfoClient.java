package com.alioguzhancicek.mymobiledietician.api;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

public class UserInfoClient {


    private UserInfoRetrofitRequest userInfoRetrofitRequest;


    public UserInfoClient() {
        Retrofit retrofit = DieticianRetrofitClient.getInstance();
        userInfoRetrofitRequest = retrofit.create(UserInfoRetrofitRequest.class);
    }


    public ResponseUserInfo getUserInfo(long id) {

        Call<ResponseUserInfo> call =
                userInfoRetrofitRequest.getUserInfo(id);

        ResponseUserInfo responseBody = null;
        try {
            Response<ResponseUserInfo> response = call.execute();
            responseBody = response.body();
        } catch (Exception ex) {
            System.out.println("An exception occurred = " + ex.getMessage());
        }

        return responseBody;
    }


}
