package com.example.newsapp;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIUtilities {
private static Retrofit retrofit = null;

public static apiInterface getApiInterface(){
    if(retrofit == null){
        retrofit = new Retrofit.Builder().baseUrl(apiInterface.BaseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    return retrofit.create(apiInterface.class);
}


}
