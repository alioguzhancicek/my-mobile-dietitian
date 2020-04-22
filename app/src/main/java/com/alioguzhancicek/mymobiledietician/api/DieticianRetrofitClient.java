package com.alioguzhancicek.mymobiledietician.api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class DieticianRetrofitClient {

    private static Retrofit retrofit;
    private final static String DieticianApiBaseUrl = "http://192.168.1.20:8080/";

    static Retrofit getInstance() {

        if (retrofit == null) {

            synchronized (DieticianRetrofitClient.class) {

                if (retrofit == null) {

                    retrofit = new Retrofit.Builder()
                            .baseUrl(DieticianApiBaseUrl)
                            .addConverterFactory(GsonConverterFactory.create())
                            .client(new OkHttpClient())
                            .build();

                }
            }
        }

        return retrofit;
    }


}
