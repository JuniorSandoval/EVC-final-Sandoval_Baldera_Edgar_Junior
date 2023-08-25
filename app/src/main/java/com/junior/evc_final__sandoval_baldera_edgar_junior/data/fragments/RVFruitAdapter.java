package com.junior.evc_final__sandoval_baldera_edgar_junior.data.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.junior.evc_final__sandoval_baldera_edgar_junior.Model.Fruits;
import com.junior.evc_final__sandoval_baldera_edgar_junior.R;
import com.junior.evc_final__sandoval_baldera_edgar_junior.databinding.ItemFruitBinding;

import java.util.List;

public class RVFruitAdapter extends RecyclerView.Adapter<RVFruitAdapter.FruitViewHolder> {

    private List<Fruits> fruits;

    public RVFruitAdapter(List<Fruits> fruits){
        this.fruits = fruits;
    }

    @NonNull
    @Override
    public FruitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFruitBinding binding = ItemFruitBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new FruitViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FruitViewHolder holder, int position) {
        holder.bind(fruits.get(position));
    }

    @Override
    public int getItemCount() {
        return fruits.size();
    }

    public class FruitViewHolder extends RecyclerView.ViewHolder{
        private ItemFruitBinding binding;
        public FruitViewHolder(@NonNull ItemFruitBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Fruits fruits) {
            binding.txtNombreFruta.setText(fruits.getNombre());
            Glide.with(itemView.getContext()).load(fruits.getImageUrl()).into(binding.imgFruit);
        }
    }

}
