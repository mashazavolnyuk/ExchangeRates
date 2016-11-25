package com.mashazavolnyuk.exchangerates;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.mashazavolnyuk.exchangerates.API.ApiClient;
import com.mashazavolnyuk.exchangerates.API.DataCurrencies;
import com.mashazavolnyuk.exchangerates.API.IRequest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashActivity extends AppCompatActivity {
    List<Currency> currencyList;
    final int PERMISSION_INTERNET = 1;
    String[] permissions = new String[]{
            Manifest.permission.INTERNET,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        currencyList = new LinkedList<>();
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setIndeterminate(false);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        setContentView(R.layout.activity_main);
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkPermissions();
        }

        IRequest apiService =
                ApiClient.getClient().create(IRequest.class);
        Call<List<Currency>> call = apiService.getCurrency();
        call.enqueue(new Callback<List<Currency>>() {
            @Override
            public void onResponse(Call<List<Currency>> call, Response<List<Currency>> response) {
                currencyList = response.body();
                Intent loginact = new Intent(SplashActivity.this, MainActivity.class);
                DataCurrencies.getInstance().setCurrencies(currencyList);
                progressDialog.dismiss();
                startActivity(loginact);
            }
            @Override
            public void onFailure(Call<List<Currency>> call, Throwable t) {

            }
        });
        progressDialog.onStart();

    }

    private boolean checkPermissions() {
        int result;
        List<String> listPermissionsNeeded = new ArrayList<>();
        for (String p : permissions) {
            result = ContextCompat.checkSelfPermission(this, p);
            if (result != PackageManager.PERMISSION_GRANTED) {
                listPermissionsNeeded.add(p);
            }
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), PERMISSION_INTERNET);
            return false;
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_INTERNET: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    getContact();
                } else {
                    // Toast.makeText(this, "No permission for contacts",Toast.LENGTH_LONG).show();
                }
                return;
            }
        }
    }
}
