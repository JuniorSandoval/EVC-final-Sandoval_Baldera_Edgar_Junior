package com.junior.evc_final__sandoval_baldera_edgar_junior.data.fragments.retrofit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class RetrofitHelper {

    public static Retrofit instance;
    public static FruitInterface service;

    public RetrofitHelper() {
    }

    public static Retrofit getInstance() {
        if(instance == null){
            //https://run.mocky.io/v3/10bbaa40-cb37-499c-87af-7aee919c0776
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://run.mocky.io/v3/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(getLogginBuilder().build())
                    .build();
            instance = retrofit;
        }
        return instance;
    }

    public static OkHttpClient.Builder getLogginBuilder(){

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(interceptor);
        return builder;
    }

    public static FruitInterface getService(){
        if (service == null){
            service = getInstance().create(FruitInterface.class);
        }
        return service;
    }

}
