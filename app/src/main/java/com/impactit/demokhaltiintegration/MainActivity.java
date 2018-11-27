package com.impactit.demokhaltiintegration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.HashMap;

import khalti.checkOut.api.Config;
import khalti.checkOut.api.OnCheckOutListener;
import khalti.checkOut.helper.KhaltiCheckOut;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnKhalti).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Config config = new Config("test_public_key_1d57e4d159794c6790a62f8953124053", "Product ID", "Product Name", "Product Url", (long) 1000, new OnCheckOutListener() {

                    @Override
                    public void onSuccess(HashMap<String, Object> data) {
                        Log.i("Payment confirmed", data + "");
                    }

                    @Override
                    public void onError(String action, String message) {
                        Log.i(action, message);
                    }
                });
                KhaltiCheckOut khaltiCheckOut = new KhaltiCheckOut(MainActivity.this, config);
                khaltiCheckOut.show(config);
            }
        });
    }
}
