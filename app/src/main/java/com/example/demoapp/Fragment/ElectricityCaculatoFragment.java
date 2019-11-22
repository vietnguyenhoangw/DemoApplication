package com.example.demoapp.Fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demoapp.R;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * A simple {@link Fragment} subclass.
 */
public class ElectricityCaculatoFragment extends Fragment {

    NumberFormat formatter = new DecimalFormat("#000");
    NumberFormat formatter_2 = new DecimalFormat("#000.00");

    EditText edt_oldIndex, edt_newIndex;
    Double oldIndex, newIndex, used, totalPrice;
    Button acceptButton;
    TextView oldIndexResult, newIndexResult, price;

    RelativeLayout layout_result;

    public ElectricityCaculatoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_electricity_caculato, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        createWidget(view);

        acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult();
            }
        });
    }

    private void createWidget(View view) {
        edt_oldIndex = view.findViewById(R.id.edt_oldindex);
        edt_newIndex = view.findViewById(R.id.edt_newindex);
        acceptButton = view.findViewById(R.id.btnAccept);
        oldIndexResult = view.findViewById(R.id.tv_oldIndexResult);
        newIndexResult = view.findViewById(R.id.tv_newIndexResult);
        price = view.findViewById(R.id.tv_total_price_result);
        layout_result = view.findViewById(R.id.layout_result);

    }

    private double price_caculator() {

        used = newIndex - oldIndex;

        if(used <= 100) {
            totalPrice = used * 1000;
        }
        else {
            if(used <= 150) {
                totalPrice = 100 * 1000 + (used - 100) * 1200;
            }
            else {
                if(used <= 200) {
                    totalPrice = 100 * 1000 + 50 * 1200 + (used - 150) * 2000;
                }
                else {
                    if(used >= 201) {
                        totalPrice = 100 * 1000 + 50 * 1200 + 50 * 2000 + (used - 200) * 2500;
                    }
                }
            }
        }

        return totalPrice;
    }

    private void setResult() {
        try {
            oldIndex = Double.parseDouble(edt_oldIndex.getText().toString());
            newIndex = Double.parseDouble(edt_newIndex.getText().toString());

            oldIndexResult.setText(formatter_2.format(oldIndex) + "");
            newIndexResult.setText(formatter_2.format(newIndex) + "");
            price.setText(formatter.format(price_caculator()) + " VND");

            layout_result.setVisibility(View.VISIBLE);
        }
        catch (Exception ex) {
            Toast.makeText(getContext(), R.string.invalid, Toast.LENGTH_SHORT).show();
        }

    }
}
