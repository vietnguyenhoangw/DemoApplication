package com.example.demoapp;
import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Locale;

public class LoginActivity extends AppCompatActivity {

    Button btnButton;
    TextView tvLanguageSelect;
    ImageView icon;
    EditText edtUsername, edtPassword;

    Locale mLocale;
    RadioGroup rdGR;
    RadioButton rd1, rd2;

    String language;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        createWidget();
        setLanguageIcon();

        btnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);

                finish();

//                if (edtUsername.getText().length() <= 0) {
//                    edtUsername.setError(getString(R.string.username_empty));
//                }
//                else {
//                    if (edtPassword.getText().length() <= 0) {
//                        edtPassword.setError(getString(R.string.password_empty));
//                    }
//                    else {
//                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                        startActivity(intent);
//
//                        finish();
//                    }
//                }
            }
        });

        tvLanguageSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                craeteDialog();
            }
        });
    }

    // Create widget
    private void createWidget() {
        btnButton = findViewById(R.id.btn_signin);
        tvLanguageSelect = findViewById(R.id.tv_language_select);
        icon = findViewById(R.id.img_languague);
        edtUsername = findViewById(R.id.edt_username);
        edtPassword = findViewById(R.id.edt_password);
    }

    // check to set icon language
    private void setLanguageIcon() {
        if (tvLanguageSelect.getText().equals("Language")) {
            icon.setImageResource(R.drawable.united_states_of_america_flag_country_nation_union_empire_33135);
        }
        else {
            icon.setImageResource(R.drawable.vietnam_flag_country_nation_union_empire_33148);
        }
    }

    // Languague list select
    private void craeteDialog() {
        LayoutInflater li = LayoutInflater.from(LoginActivity.this);
        final View dialogView = li.inflate(R.layout.languague_list_dialog, null);

        final AlertDialog alertDialogBuilder = new AlertDialog.Builder(LoginActivity.this)
                .setCancelable(false)
                .setPositiveButton(R.string.accept, null)
                .create();
        alertDialogBuilder.setView(dialogView);

        rdGR = dialogView.findViewById(R.id.rdGR);
        rd1 = dialogView.findViewById(R.id.radioButton1);
        rd2 = dialogView.findViewById(R.id.radioButton2);

        alertDialogBuilder.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                Button button =  alertDialogBuilder.getButton(AlertDialog.BUTTON_POSITIVE);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        switch (rdGR.getCheckedRadioButtonId()) {
                            case R.id.radioButton1:
                                mLocale = new Locale("en", "US");
                                language = "English";
                                onChangeLanguge(mLocale);
                                alertDialogBuilder.dismiss();
                                break;
                            case R.id.radioButton2:
                                mLocale = new Locale("vi", "VN");
                                language = "Tiếng Việt";
                                onChangeLanguge(mLocale);
                                alertDialogBuilder.dismiss();
                                break;
                        }
                    }
                });
            }
        });

        alertDialogBuilder.show();

        WindowManager.LayoutParams lp = alertDialogBuilder.getWindow().getAttributes();
        lp.dimAmount=0.5f;
        alertDialogBuilder.getWindow().setAttributes(lp);
        alertDialogBuilder.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
    }

    // Language change
    private void onChangeLanguge(Locale locale) {
        DisplayMetrics displayMetrics = getBaseContext().getResources().getDisplayMetrics();

        Configuration configuration = new Configuration();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            configuration.setLocale(locale);
        }
        else {
            configuration.locale = locale;
        }

        getBaseContext().getResources().updateConfiguration(configuration, displayMetrics);

        Intent refresh = new Intent(LoginActivity.this, LoginActivity.class);
        startActivity(refresh);

        finish();
    }
}
