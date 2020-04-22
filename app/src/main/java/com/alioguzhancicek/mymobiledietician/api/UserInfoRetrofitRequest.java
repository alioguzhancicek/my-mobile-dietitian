package com.alioguzhancicek.mymobiledietician.api;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface UserInfoRetrofitRequest {

    @GET("users/{id}")
    Call<ResponseUserInfo> getUserInfo(@Path("id") long id);


    @POST("users")
    @Headers({"Content-Type: application/json;charset=UTF-8"})
    Call<Void> addNewUser(@Body UserDto userDto);
}
