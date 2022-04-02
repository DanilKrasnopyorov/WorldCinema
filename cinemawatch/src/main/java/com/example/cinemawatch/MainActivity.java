package com.example.cinemawatch;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.cinemawatch.databinding.ActivityMainBinding;

public class MainActivity extends Activity {

    private TextView mTextView;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}