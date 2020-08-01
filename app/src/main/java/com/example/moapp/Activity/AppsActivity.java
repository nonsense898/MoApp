package com.example.moapp.Activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moapp.Adapter.MoListAdapter;
import com.example.moapp.R;
import com.example.moapp.REST.MoApi;
import com.example.moapp.REST.Model.AppsResult;
import com.example.moapp.REST.Model.Auth;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppsActivity extends AppCompatActivity {
    public static final String MO_URL_APPS = "https://html5.mo-apps.com/api/";
    RecyclerView recyclerView;
    MoListAdapter moListAdapter = new MoListAdapter();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.apps_layout);
        fetchApps();
    }

    private void fetchApps() {
        Bundle bundle = getIntent().getExtras();
        String token = bundle.getString("TOKEN");

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(MO_URL_APPS)
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();
        MoApi client = retrofit.create(MoApi.class);

        Call<AppsResult> call = client.getApplications(new Auth(0, 1000, 0, token));

        // Set up progress before call
        final ProgressDialog progressDialog;
        progressDialog = new ProgressDialog(AppsActivity.this);
        progressDialog.setMax(100);
        progressDialog.setMessage("Please, wait");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        // show it
        progressDialog.show();
        call.enqueue(new Callback<AppsResult>() {
            @Override
            public void onResponse(@NotNull Call<AppsResult> call, @NotNull Response<AppsResult> response) {

                AppsResult results = response.body();
                recyclerView = findViewById(R.id.recycleView);
                recyclerView.setLayoutManager(new LinearLayoutManager(AppsActivity.this));
                moListAdapter.setData(results.getData(), AppsActivity.this);
                progressDialog.dismiss();
                recyclerView.setAdapter(moListAdapter);
                recyclerView.setHasFixedSize(true);

            }

            @Override
            public void onFailure(@NotNull Call<AppsResult> call, @NotNull Throwable t) {
                Log.d("retro", "" + t.getMessage());
            }
        });
    }
}
