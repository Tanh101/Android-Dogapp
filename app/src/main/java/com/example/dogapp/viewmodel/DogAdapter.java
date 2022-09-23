package com.example.dogapp.viewmodel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dogapp.R;
import com.example.dogapp.model.DogBreed;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.NavigableMap;

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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dogs_item,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DogAdapter.ViewHolder holder, int position) {
        holder.tvName.setText(dogList.get(position).getName());
        holder.tvOrigin.setText(dogList.get(position).getOrigin());
        Picasso.get().load(dogList.get(position).getUrl()).into(holder.ivAvatar);
    }

    @Override
    public int getItemCount() {
        return dogList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName;
        public TextView tvOrigin;
        public ImageView ivAvatar;

        public ViewHolder(View view) {
            super(view);
            tvName = (TextView) view.findViewById(R.id.tv_name);
            tvOrigin = view.findViewById(R.id.tv_origin);
            ivAvatar = view.findViewById(R.id.iv_avatar);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    DogBreed dog = dogList.get(getAdapterPosition());
//                    Bundle bundle = new Bundle();
//                    bundle.putSerializable("dog", dog);
//                    Navigation.findNavController(view).navigate(R.id.detailsFragment2, bundle);
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


