package com.alioguzhancicek.mymobiledietician.api;

public class ApiUtils {
    private ApiUtils(){}
    public static final String BASE_URL="http://192.168.1.20:8080/";

    public static UserInfoRetrofitRequest getApiService(){
        return RetrofitClient.getClient(BASE_URL).create(UserInfoRetrofitRequest.class);
    }
}
