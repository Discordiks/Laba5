package com.example.anew;

import android.app.NotificationManager;
import android.graphics.Color;
//import android.support.v7.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView
                = findViewById(R.id.bottomNav);
        bottomNavigationView
                .setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.Test);
    }
    ContactFragment ContactFragment = new ContactFragment();
    TestFragment TestFragment = new TestFragment();
    NotificationFragment NotificationFragment = new NotificationFragment();

    @Override
    public boolean
    onNavigationItemSelected(@NonNull MenuItem item)
    {
        switch (item.getItemId()) {
            case R.id.Contact:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flFragment, ContactFragment)
                        .commit();
                return true;

            case R.id.Test:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flFragment, TestFragment)
                        .commit();
                return true;

            case R.id.Notification:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flFragment, NotificationFragment)
                        .commit();
                return true;
        }
        return false;
    }
}