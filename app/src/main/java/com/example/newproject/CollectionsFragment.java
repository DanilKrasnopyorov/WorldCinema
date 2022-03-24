package com.example.newproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class CollectionsFragment extends Fragment {
    public CollectionsFragment(){

    }
    public static CollectionsFragment newInstance(String param1, String param2){
        return new CollectionsFragment();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_collections, container, false);
    }
}
