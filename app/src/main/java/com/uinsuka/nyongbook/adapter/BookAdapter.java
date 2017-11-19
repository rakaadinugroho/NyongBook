package com.uinsuka.nyongbook.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.uinsuka.nyongbook.R;
import com.uinsuka.nyongbook.models.Item;

import java.util.List;

/**
 * Created by Raka Adi Nugroho on 11/19/17.
 *
 * @Github github.com/rakaadinugroho
 * @Contact nugrohoraka@gmail.com
 */

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookHolder> {

    private List<Item> items;
    private Context context;

    public BookAdapter(List<Item> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public BookHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view   = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book, parent, false);
        BookHolder holder = new BookHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(BookHolder holder, int position) {
        Item item   = items.get(position);

        holder.item_title.setText(item.getVolumeInfo().getTitle().toString());
        Picasso.with(context).load(item.getVolumeInfo().getImageLinks().getSmallThumbnail()).into(holder.item_thumbnail);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class BookHolder extends RecyclerView.ViewHolder{
        public TextView item_title;
        public ImageView item_thumbnail;

        public BookHolder(View itemView) {
            super(itemView);

            item_title  = (TextView) itemView.findViewById(R.id.item_title);
            item_thumbnail  = (ImageView) itemView.findViewById(R.id.item_thumbnail);
        }
    }
}
