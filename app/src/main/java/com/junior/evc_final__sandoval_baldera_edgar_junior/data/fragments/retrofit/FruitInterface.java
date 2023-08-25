package com.junior.evc_final__sandoval_baldera_edgar_junior.data.fragments.retrofit;

import com.junior.evc_final__sandoval_baldera_edgar_junior.data.fragments.response.FruitResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FruitInterface {

    @GET("10bbaa40-cb37-499c-87af-7aee919c0776")
    Call<FruitResponse> getFruits();

}
