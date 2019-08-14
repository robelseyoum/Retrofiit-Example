package com.robelseyoum3.retrofitexample.network;

import com.robelseyoum3.retrofitexample.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstances {

    private static Retrofit retrofit;

    public static Retrofit getRetrofitInstances(){

        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
