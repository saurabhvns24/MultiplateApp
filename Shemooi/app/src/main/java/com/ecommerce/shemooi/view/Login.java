package com.ecommerce.shemooi.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.ecommerce.shemooi.R;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Context mContext = Login.this;
        findViewById(R.id.register_tv).setOnClickListener(v -> startActivity(new Intent(mContext, Signup.class)));
    }
}