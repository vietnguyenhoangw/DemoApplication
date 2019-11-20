package com.example.demoapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.demoapp.R;
import com.github.chrisbanes.photoview.PhotoView;

public class ElectricityPriceActivity extends AppCompatActivity {

    PhotoView photoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electricity_price);

        photoView = (PhotoView) findViewById(R.id.photo_view);
        photoView.setImageResource(R.drawable.giabanledien);
    }
}
