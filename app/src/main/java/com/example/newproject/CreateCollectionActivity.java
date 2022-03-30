package com.example.newproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CreateCollectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_collection);
    }

    public void moveToCollections(View view) {
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }

    public void addIcon(View view) {
        Intent i = new Intent(getApplicationContext(), ChooseIconCollectionActivity.class);
        startActivity(i);
    }

    public void saveIcon(View view) {
    }

    public void setImageInCollection(View view) {
    }

}