package com.example.eoin.madforgames;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class GameDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_details);
        int pos = getIntent().getIntExtra("gameId",-999);
        GMDBClient.getClient().getPubG().enqueue(new Callback<List<Game>>() {
            @Override
            public void onResponse(Call<List<Game>> call, Response<List<Game>> response) {
                Log.e("PASS","PASS");
                TextView x = findViewById(R.id.textViewDetails);
                x.setText(response.body().get(0).getSummary());
            }

            @Override
            public void onFailure(Call<List<Game>> call, Throwable t) {
                Log.e("FAil","Fail" + t);
            }
        });
    }
}
