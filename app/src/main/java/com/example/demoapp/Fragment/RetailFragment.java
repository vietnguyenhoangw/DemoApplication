package com.example.demoapp.Fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.demoapp.R;
import com.github.chrisbanes.photoview.PhotoView;

/**
 * A simple {@link Fragment} subclass.
 */
public class RetailFragment extends Fragment {

    PhotoView photoView;
    String flag;

    public RetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_retail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        photoView = (PhotoView) view.findViewById(R.id.photo_view);
        flag = getArguments().getString("flag");

        if (flag.equals("electric")) {
            photoView.setImageResource(R.drawable.giabanledien);
        }
        else {
            photoView.setImageResource(R.drawable.water);
        }
    }
}
