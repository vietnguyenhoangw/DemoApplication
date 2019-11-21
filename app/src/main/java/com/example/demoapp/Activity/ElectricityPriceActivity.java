package com.example.demoapp.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.demoapp.Fragment.ElectricityCaculatoFragment;
import com.example.demoapp.Fragment.HolesaleFragment;
import com.example.demoapp.Fragment.HourlySellingFragment;
import com.example.demoapp.Fragment.RetailFragment;
import com.example.demoapp.Fragment.SpecialTypeFragment;
import com.example.demoapp.R;
import com.github.chrisbanes.photoview.PhotoView;
import com.google.android.material.navigation.NavigationView;

public class ElectricityPriceActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView img_Left;
    Toolbar toolbar;
    TextView toolBarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electricity_price);

        /*
         * Toolbar custom
         * */
        toolbar = findViewById(R.id.toolbar);
        img_Left = toolbar.findViewById(R.id.img_left);
        toolBarTitle = toolbar.findViewById(R.id.toolbarTitle);
        navigationView = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.drawer_layout);

        img_Left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        displayFragment(R.id.menu_retail_price);

        /* NavigationView select */
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                displayFragment(menuItem.getItemId());
                drawerLayout.closeDrawers();

                return false;
            }
        });
    }

    /* Navigation Drawers's item select */
    public void displayFragment(int id) {
        Fragment fragment = null;

        switch (id) {
            case R.id.menu_retail_price:
                fragment = new RetailFragment();
                toolBarTitle.setText(R.string.menu_retail_price);
                break;
            case R.id.menu_holesale_price:
                fragment = new HolesaleFragment();
                toolBarTitle.setText(R.string.menu_holesale_price);
                break;
            case R.id.menu_hourly_selling_price:
                fragment = new HourlySellingFragment();
                toolBarTitle.setText(R.string.menu_hourly_selling_price);
                break;
            case R.id.menu_special_type_price:
                fragment = new SpecialTypeFragment();
                toolBarTitle.setText(R.string.menu_special_type_price);
                break;
            case R.id.menu_electricity_caculator:
                fragment = new ElectricityCaculatoFragment();
                toolBarTitle.setText(R.string.menu_electricity_caculator);
                break;
                default:
                    return;
        }

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content, fragment);

        ft.addToBackStack(null);

        ft.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        finish();
    }
}
