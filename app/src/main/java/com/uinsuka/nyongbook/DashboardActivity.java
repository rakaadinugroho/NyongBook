package com.uinsuka.nyongbook;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.uinsuka.nyongbook.adapter.BookAdapter;
import com.uinsuka.nyongbook.models.Item;
import com.uinsuka.nyongbook.models.ResponseBooks;
import com.uinsuka.nyongbook.network.NetworkClient;
import com.uinsuka.nyongbook.network.NetworkStores;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    private RecyclerView list_book;
    private SwipeRefreshLayout book_container;

    private List<Item> items;
    private BookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        initViews();

        loadData();

    }

    private void loadData() {
        book_container.setRefreshing(true);
        NetworkStores api   = NetworkClient.getRetrofit().create(NetworkStores.class);
        Call<ResponseBooks> response = api.getBooks("Machine Learning");
        response.enqueue(new Callback<ResponseBooks>() {
            @Override
            public void onResponse(Call<ResponseBooks> call, Response<ResponseBooks> response) {
                if (items.size() > 0){
                    items.clear();
                }
                items.addAll(response.body().getItems());
                adapter.notifyDataSetChanged();

                book_container.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<ResponseBooks> call, Throwable t) {
                Toast.makeText(DashboardActivity.this, "Error : " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                book_container.setRefreshing(false);
            }
        });
    }

    private void initViews() {
        list_book = (RecyclerView) findViewById(R.id.list_book);
        book_container  = (SwipeRefreshLayout) findViewById(R.id.book_container);

        items   = new ArrayList<>();
        adapter = new BookAdapter(items, getApplicationContext());

        RecyclerView.LayoutManager layoutManager    = new GridLayoutManager(getApplicationContext(), 2);
        list_book.setLayoutManager(layoutManager);
        list_book.addOnItemTouchListener(clickData());
        list_book.setItemAnimator(new DefaultItemAnimator());
        list_book.setAdapter(adapter);

        book_container.setOnRefreshListener(this);
    }

    private RecyclerItemClickListener clickData() {
        return new RecyclerItemClickListener(getApplicationContext(), list_book, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                String rawDetail    = new Gson().toJson(items.get(position));
                Intent intent   = new Intent(DashboardActivity.this, DetailActivity.class);
                intent.putExtra("detail_book", rawDetail);
                startActivity(intent);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        });
    }

    @Override
    public void onRefresh() {
        book_container.setRefreshing(true);
    }
}
