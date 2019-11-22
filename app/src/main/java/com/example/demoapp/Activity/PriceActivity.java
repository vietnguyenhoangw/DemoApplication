package com.example.demoapp.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demoapp.Fragment.ElectricityCaculatoFragment;
import com.example.demoapp.Fragment.HolesaleFragment;
import com.example.demoapp.Fragment.HourlySellingFragment;
import com.example.demoapp.Fragment.RetailFragment;
import com.example.demoapp.Fragment.SpecialTypeFragment;
import com.example.demoapp.R;
import com.github.chrisbanes.photoview.PhotoView;
import com.google.android.material.navigation.NavigationView;

public class PriceActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView img_Left;
    Toolbar toolbar;
    TextView toolBarTitle;

    String flag;

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

        flag = getIntent().getStringExtra("flag");


        displayWater_or_Electric_menu();

        img_Left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

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
                Bundle b1 = new Bundle();
                b1.putString("flag", flag);

                fragment = new RetailFragment();
                fragment.setArguments(b1);

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
            case R.id.menu_retail_price_water:
                Bundle b2 = new Bundle();
                b2.putString("flag", flag);

                fragment = new RetailFragment();
                fragment.setArguments(b2);

                toolBarTitle.setText(R.string.menu_retail_price_water);
                break;
                default:
                    return;
        }

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content, fragment);

        ft.addToBackStack(null);

        ft.commit();
    }

    private void displayWater_or_Electric_menu() {
        Menu nav_Menu = navigationView.getMenu();

        if (flag.equals("electric")) {
            displayFragment(R.id.menu_retail_price);

            nav_Menu.findItem(R.id.menu_retail_price_water).setVisible(false);

            nav_Menu.findItem(R.id.menu_retail_price).setVisible(true);
            nav_Menu.findItem(R.id.menu_holesale_price).setVisible(true);
            nav_Menu.findItem(R.id.menu_hourly_selling_price).setVisible(true);
            nav_Menu.findItem(R.id.menu_special_type_price).setVisible(true);
        }
        else {
            displayFragment(R.id.menu_retail_price_water);

            nav_Menu.findItem(R.id.menu_retail_price).setVisible(false);
            nav_Menu.findItem(R.id.menu_holesale_price).setVisible(false);
            nav_Menu.findItem(R.id.menu_hourly_selling_price).setVisible(false);
            nav_Menu.findItem(R.id.menu_special_type_price).setVisible(false);

            nav_Menu.findItem(R.id.menu_retail_price_water).setVisible(true);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        finish();
    }
}
