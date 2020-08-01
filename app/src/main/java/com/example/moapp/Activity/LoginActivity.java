package com.example.moapp.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.moapp.REST.MoApi;
import com.example.moapp.R;
import com.example.moapp.REST.Model.Login;
import com.example.moapp.REST.Model.LoginResult;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class LoginActivity extends AppCompatActivity {
    public static final String MO_LOGIN = "https://html5.mo-apps.com/api/Account/";
    EditText login;
    EditText pass;
    Button login_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.login_layout);

        login_btn = findViewById(R.id.btn_login);
        login_btn.setOnClickListener((v) -> login());
    }


    void login() {
        login = findViewById(R.id.loginET);
        pass = findViewById(R.id.passET);

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(MO_LOGIN)
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();

        MoApi client = retrofit.create(MoApi.class);
        Call<LoginResult> call = client.login(new Login(login.getText().toString(), pass.getText().toString()));


        call.enqueue(new Callback<LoginResult>() {
            @Override
            public void onResponse(@NotNull Call<LoginResult> call, @NotNull Response<LoginResult> response) {
                LoginResult result = response.body();
                Intent i = new Intent(LoginActivity.this, AppsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("TOKEN", result.getData());
                i.putExtras(bundle);
                startActivity(i);
            }

            @Override
            public void onFailure(@NotNull Call<LoginResult> call, @NotNull Throwable t) {
                Log.d("retro", "" + t.getMessage());
            }
        });
    }


}
