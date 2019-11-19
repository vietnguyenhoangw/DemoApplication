package com.example.demoapp;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.demoapp.Fragment.HomeFragment;
import com.example.demoapp.Fragment.SettingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView navView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createWidget();

        // always open nav's home item
        loadFragment(new HomeFragment());

        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                navbarSelect(item);
                return true;
            }
        });
    }

    // Create widget
    private void createWidget() {
        navView = findViewById(R.id.nav_view);
    }


    /*
    *  Bottom navigation
    * */

    // Bottomnav bar select
    private void navbarSelect(MenuItem item) {
        Fragment fragment;

        switch (item.getItemId()) {
            case R.id.navigation_home:
                fragment = new HomeFragment();
                loadFragment(fragment);
                break;
            case R.id.navigation_setting:
                fragment = new SettingFragment();
                loadFragment(fragment);
                break;
        }
    }

    // Load fragment
    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.nav_host_fragment, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
