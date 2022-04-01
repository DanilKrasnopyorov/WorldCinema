package com.example.newproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

import com.example.newproject.network.models.DataManager;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements  BottomNavigationView.OnNavigationItemSelectedListener {

    MainFragment mainFragment = new MainFragment();
    ProfileFragment profileFragment = new ProfileFragment();
    CollectionsFragment collectionsFragment = new CollectionsFragment();
    CompilationFragment compilationFragment = new CompilationFragment();
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.navigation_main);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item){
        switch(item.getItemId()){
            case R.id.navigation_main:
                getSupportFragmentManager().beginTransaction().replace(R.id.mainFrameLayout, mainFragment).commit();
                return true;
            case R.id.navigation_compilation:
                getSupportFragmentManager().beginTransaction().replace(R.id.mainFrameLayout, compilationFragment).commit();
                return true;
            case R.id.navigation_profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.mainFrameLayout, profileFragment).commit();
                return true;
            case R.id.navigation_collections:
                getSupportFragmentManager().beginTransaction().replace(R.id.mainFrameLayout, collectionsFragment).commit();
                return true;
        }
        return false;
    }

    public void moveToLoginScreen(View view) {
        Intent i = new Intent(getApplicationContext(), LoginActivity.class);
        DataManager.token = null;
        finish();
        startActivity(i);
    }

    public void moveToCreateCollection(View view) {
        Intent i = new Intent(getApplicationContext(), CreateCollectionActivity.class);
        startActivity(i);
    }
}