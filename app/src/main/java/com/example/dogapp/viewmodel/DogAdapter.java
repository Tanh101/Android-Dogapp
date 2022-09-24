package com.example.dogapp.viewmodel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dogapp.R;
import com.example.dogapp.databinding.DogsItemBinding;
import com.example.dogapp.model.DogBreed;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DogAdapter extends RecyclerView.Adapter<DogAdapter.ViewHolder> implements Filterable {


    private ArrayList<DogBreed> dogList;
    private ArrayList<DogBreed> tmpList;
    private CustomFilter cs;

    public DogAdapter(ArrayList<DogBreed> dogList) {
        this.dogList = dogList;
        this.tmpList = dogList;
    }

    @Override
    public Filter getFilter() {
        return null;
    }

    @NonNull
    @Override
    public DogAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dogs_item,parent, false);
        DogsItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.dogs_item,
                parent,
                false);

        return new ViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull DogAdapter.ViewHolder holder, int position) {
        holder.binding.setDog(dogList.get(position));
        Picasso.get().load(dogList.get(position).getUrl()).into(holder.binding.ivAvatar);
    }

    @Override
    public int getItemCount() {
        return dogList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public DogsItemBinding binding;

        public ViewHolder(DogsItemBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;

            binding.ivAvatar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DogBreed dog = dogList.get(getAdapterPosition());
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("dogBreed", dog);
                    Navigation.findNavController(view).navigate(R.id.detailsFragment, bundle);
//                    Navigation.findNavController(view).navigate(R.id.detailsFragment2);
                }
            });
        }

    }

    public class CustomFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            FilterResults result = new FilterResults();
            if (charSequence != null && charSequence.length() > 0) {
                charSequence = charSequence.toString().toUpperCase();
                ArrayList<DogBreed> filters = new ArrayList<>();
                for (int i = 0; i < tmpList.size(); i++) {
                    if (tmpList.get(i).getName().toUpperCase().contains(charSequence)) {
                        DogBreed dogBreed = new DogBreed(tmpList.get(i).getName(),
                                tmpList.get(i).getLifeSpan(), tmpList.get(i).getOrigin(),
                                tmpList.get(i).getUrl());
                        filters.add(dogBreed);
                    }

                }
                result.count = filters.size();
                result.values = filters;
            } else {
                result.count = tmpList.size();
                result.values = tmpList;
            }
            return result;
        }


        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            dogList = (ArrayList<DogBreed>) filterResults.values;
            notifyDataSetChanged();
        }


    }
}


