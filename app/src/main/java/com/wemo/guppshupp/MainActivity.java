package com.wemo.guppshupp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private ViewPager myViewPager;
    private TabLayout mTabLayout;
    private TabsAccessorAdapter myTabAccessorAdapter;
    private FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setToolbar();
        tabAccessorAdapter();
        tabLayoutViewPager();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(currentUser == null){
            sendUserToLoginActivity();
        }
    }

    private void sendUserToLoginActivity() {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    private void tabLayoutViewPager() {
        mTabLayout.setupWithViewPager(myViewPager);
    }

    private void initViews() {
        mToolbar = findViewById(R.id.main_page_toolbar);
        myViewPager = findViewById(R.id.main_tabs_pager);
        mTabLayout = findViewById(R.id.main_tabs);
    }

    private void tabAccessorAdapter() {
        myTabAccessorAdapter = new TabsAccessorAdapter(getSupportFragmentManager());
        myViewPager.setAdapter(myTabAccessorAdapter);
    }

    private void setToolbar() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Gupp Shupp");
    }
}