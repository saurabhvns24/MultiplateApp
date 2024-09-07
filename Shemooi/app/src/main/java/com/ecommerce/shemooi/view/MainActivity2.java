package com.ecommerce.shemooi.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ecommerce.shemooi.R;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        Button get_otp_btn = findViewById(R.id.get_otp_btn);
        get_otp_btn.setOnClickListener(v -> startActivity(new Intent(this, MainActivity3.class)));
    }
}