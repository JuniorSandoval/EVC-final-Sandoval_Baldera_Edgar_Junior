package com.junior.evc_final__sandoval_baldera_edgar_junior.data.fragments.response;

import com.google.gson.annotations.SerializedName;
import com.junior.evc_final__sandoval_baldera_edgar_junior.Model.Fruits;

import java.util.List;

public class FruitResponse {

    @SerializedName("fruits")
    public List<Fruits> fruitsList;

    public List<Fruits> getFruitsList(){

        return fruitsList;

    }

    public void setFruitsList(List<Fruits> fruitsList){
        this.fruitsList=fruitsList;
    }

}
