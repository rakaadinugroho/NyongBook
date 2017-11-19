package com.uinsuka.nyongbook;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.uinsuka.nyongbook.models.ResponseBooks;
import com.uinsuka.nyongbook.network.NetworkClient;
import com.uinsuka.nyongbook.network.NetworkStores;

import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    /* Abaikan */
    private static final String TAG = MainActivity.class.getSimpleName();
    private TextView textResult;
    /* Abaikan */

    private TextView textLoaded;
    private TextView textPreload;
    private Button buttonLoad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Abaikan */
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textResult = (TextView) findViewById(R.id.textResult);
        //loadData();
        /* Abaikan */

        textLoaded    = (TextView) findViewById(R.id.textLoad);
        textPreload = (TextView) findViewById(R.id.textPreload);
        buttonLoad  = (Button) findViewById(R.id.buttonLoad);

        buttonLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new PerhitunganAsync(textLoaded).execute();
                textPreload.setText("Aku nggak masuk hitungan");

            }
        });

    }

    private void hitung() {
        Random random   = new Random();
        int i   = random.nextInt(11);

        int s   = i * 400;

        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        textLoaded.setText("Ini Aku Dihitung , jadi" + s);
    }





    private void loadData() {
        NetworkStores api   = NetworkClient.getRetrofit().create(NetworkStores.class);
        Call<ResponseBooks> booksCall   = api.getBooks("Programming");
        booksCall.enqueue(new Callback<ResponseBooks>() {
            @Override
            public void onResponse(Call<ResponseBooks> call, Response<ResponseBooks> response) {
                Log.d(TAG, "onResponse: " + new Gson().toJson(response));
                String data = new Gson().toJson(response);
                textResult.setText(data);
            }

            @Override
            public void onFailure(Call<ResponseBooks> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Gagal : " + t.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
