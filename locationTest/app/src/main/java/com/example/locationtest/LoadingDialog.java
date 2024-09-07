package com.example.locationtest;

import android.app.Activity;
import android.view.LayoutInflater;

import androidx.appcompat.app.AlertDialog;

public class LoadingDialog {
    private Activity activity;
    private AlertDialog alterDialog;

    public LoadingDialog(Activity activity) {
        this.activity = activity;
    }

    public void startLoadingDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        LayoutInflater inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.custom_dailog,null));
        builder.setCancelable(false);
        alterDialog =builder.create();
        alterDialog.show();
    }
    public void dismissDialog(){
        alterDialog.dismiss();
    }
}
