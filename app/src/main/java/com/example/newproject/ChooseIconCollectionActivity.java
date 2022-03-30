package com.example.newproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class ChooseIconCollectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_icon_collection);
    }

    public void setImageInCollection(View view){
        ImageButton icon = (ImageButton) view;
        Toast.makeText(this, icon.getId() + "", Toast.LENGTH_SHORT).show();
//        Intent i = new Intent(getApplicationContext(), CreateCollectionActivity.class);
//        i.putExtra("icon", )
//        startActivity(i);
    }
    public void moveToCreateCollection(View view){
        Intent i = new Intent(getApplicationContext(), CreateCollectionActivity.class);
        startActivity(i);
    }
    
}