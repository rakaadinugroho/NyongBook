package com.uinsuka.nyongbook;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.uinsuka.nyongbook.models.Item;

public class DetailActivity extends AppCompatActivity {
    TextView detail_writer;
    TextView detail_desc;
    ImageView detail_pict;

    private Item detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.setDisplayHomeAsUpEnabled(true);
        initViews();
    }

    private void initViews() {
        detail_writer   = (TextView) findViewById(R.id.detail_writer);
        detail_desc = (TextView) findViewById(R.id.detail_desc);
        detail_pict = (ImageView) findViewById(R.id.detail_pict);

        String rawDetail  = getIntent().getStringExtra("detail_book");
        detail  = new Gson().fromJson(rawDetail, Item.class);

        Picasso.with(this)
                .load(detail.getVolumeInfo().getImageLinks().getThumbnail())
                .into(detail_pict);

        detail_writer.setText(detail.getVolumeInfo().getAuthors().get(0).toString());
        detail_desc.setText(detail.getVolumeInfo().getDescription());
        setTitle(detail.getVolumeInfo().getTitle().toString());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
