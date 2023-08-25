package com.junior.evc_final__sandoval_baldera_edgar_junior.data.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.junior.evc_final__sandoval_baldera_edgar_junior.Model.Fruits;
import com.junior.evc_final__sandoval_baldera_edgar_junior.R;
import com.junior.evc_final__sandoval_baldera_edgar_junior.data.fragments.response.FruitResponse;
import com.junior.evc_final__sandoval_baldera_edgar_junior.data.fragments.retrofit.RetrofitHelper;
import com.junior.evc_final__sandoval_baldera_edgar_junior.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_home, container, false);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        /*super.onViewCreated(view, savedInstanceState);
        RVFruitAdapter adapter = new RVFruitAdapter(getData());
        binding.rvFruit.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false);
        binding.rvFruit.setLayoutManager(layoutManager);*/
        RetrofitHelper.getService().getFruits().enqueue(new Callback<FruitResponse>() {
            @Override
            public void onResponse(Call<FruitResponse> call, Response<FruitResponse> response) {
                if (response.isSuccessful()) {
                    //assert response.body() != null;
                    fruit_tb(response.body().getFruitsList());
                }
            }

            @Override
            public void onFailure(Call<FruitResponse> call, Throwable t) {

            }
        });
    }
    private void fruit_tb(List<Fruits> fruitsList) {
        RVFruitAdapter adapter = new RVFruitAdapter(fruitsList);
        binding.rvFruit.setAdapter(adapter);
    }

    /*private List<Fruits> getData(){
        List<Fruits> fruits = new ArrayList<>();
        fruits.add(new Fruits("Fresa",29,5.4,5.5, 0.5, "https://cdn.pixabay.com/photo/2017/10/14/15/51/strawberry-2850845_640.png"));
        fruits.add(new Fruits("Manzana",52,10.3,11.4, 0.3, "https://cdn.pixabay.com/photo/2017/10/14/15/50/apple-2850838_1280.png"));
        fruits.add(new Fruits("Platano",96,17.2,22.0, 1.0, "https://cdn.pixabay.com/photo/2017/10/14/15/50/banana-2850841_1280.png"));
        fruits.add(new Fruits("Ceresa",50,8.0,12.1, 1.0, "https://cdn.pixabay.com/photo/2017/10/14/15/52/cherry-2850850_1280.png"));
        fruits.add(new Fruits("Naranja",43,8.2,8.3, 1.2, "https://cdn.pixabay.com/photo/2017/10/14/15/51/orange-2850848_640.png"));
        fruits.add(new Fruits("Sandia",30,6.1,8.0, 0.6, "https://cdn.pixabay.com/photo/2017/10/14/15/50/fruit-2850840_640.png"));
        return fruits;

    }*/

}