package com.example.moapp.REST;

import com.example.moapp.REST.Model.AppsResult;
import com.example.moapp.REST.Model.Auth;
import com.example.moapp.REST.Model.Login;
import com.example.moapp.REST.Model.LoginResult;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface MoApi {

    @POST("Login")
    Call<LoginResult> login(@Body Login mLogin);

    @POST("application")
    Call<AppsResult> getApplications(@Body Auth mAuth);
}
