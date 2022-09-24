package com.example.dogapp.view;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dogapp.R;
import com.example.dogapp.databinding.FragmentDetailsBinding;
import com.example.dogapp.model.DogBreed;


public class DetailsFragment extends Fragment {

    private FragmentDetailsBinding fragmentDetailsBinding;
    private DogBreed dogBreed;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            dogBreed = (DogBreed) getArguments().getSerializable("dogBreed");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentDetailsBinding = DataBindingUtil.inflate(getLayoutInflater(),
                R.layout.fragment_details, null, false);
        View viewRoot = fragmentDetailsBinding.getRoot();
        fragmentDetailsBinding.setDog(dogBreed);

//        return inflater.inflate(R.layout.fragment_details, container, false);
        return viewRoot;
    }
}