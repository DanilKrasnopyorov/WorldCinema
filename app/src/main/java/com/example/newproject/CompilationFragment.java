package com.example.newproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.CompletionInfo;

import androidx.fragment.app.Fragment;

public class CompilationFragment extends Fragment {
    public CompilationFragment(){

    }
    public static CompilationFragment newInstance(String param1, String param2){
        return new CompilationFragment();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_compilation, container, false);
    }
}
