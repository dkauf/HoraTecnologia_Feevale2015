package br.feevale.horatecnologiamobile.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import br.feevale.horatecnologiamobile.adapter.ItensAdapter;
import br.feevale.horatecnologiamobile.connection.Products;
import br.feevale.horatecnologiamobile.model.Item;
import br.feevale.horatecnologiamobile.BuildConfig;
import br.feevale.horatecnologiamobile.R;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = ( RecyclerView ) findViewById( R.id.recyclerView );
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RestAdapter restAdapter = new RestAdapter.Builder()
//                .setLogLevel(RestAdapter.LogLevel.FULL).setLog(new AndroidLog(SyncStateContract.Constants.CONTENT_DIRECTORY))
                .setEndpoint(BuildConfig.URL).build();

        Products products = restAdapter.create(Products.class);

        products.getProducts(new Callback<List<Item>>() {
            @Override
            public void success(List<Item> listItens, Response response) {
                ItensAdapter itensAdapter =new ItensAdapter(MainActivity.this, listItens );
                recyclerView.setAdapter( itensAdapter );
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(MainActivity.this, "Deu guru ao realizar o Download das informações!", Toast.LENGTH_LONG).show();
            }
        });

    }
}
