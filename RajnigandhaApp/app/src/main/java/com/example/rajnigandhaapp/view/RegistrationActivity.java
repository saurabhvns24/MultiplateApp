package com.example.rajnigandhaapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import com.example.rajnigandhaapp.R;

public class RegistrationActivity extends AppCompatActivity {

    private Button log_in_button;
    private EditText name_edittext, mobile_edittext, password_edittext, date_of_birth_edittext;
    private RelativeLayout state_spinner_relative_layout;
    private Spinner city_edittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        loadUI();
        loadController();
    }

    private void loadController() {
    }

    private void loadUI() {
        name_edittext = findViewById(R.id.name_edittext);
        mobile_edittext = findViewById(R.id.mobile_edittext);
        password_edittext = findViewById(R.id.password_edittext);
        state_spinner_relative_layout = findViewById(R.id.state_spinner_relative_layout);
        state_spinner_relative_layout.setVisibility(View.VISIBLE);
        log_in_button = findViewById(R.id.log_in_button);
        city_edittext = findViewById(R.id.city_edittext);
        date_of_birth_edittext = findViewById(R.id.date_of_birth_edittext);
        date_of_birth_edittext.setVisibility(View.VISIBLE);
        name_edittext.setVisibility(View.VISIBLE);
        mobile_edittext.setVisibility(View.VISIBLE);
        password_edittext.setVisibility(View.VISIBLE);
        log_in_button.setVisibility(View.VISIBLE);
        city_edittext.setVisibility(View.VISIBLE);
    }
}