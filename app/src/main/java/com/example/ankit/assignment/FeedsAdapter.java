package com.example.ankit.assignment;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FeedsAdapter extends RecyclerView.Adapter<FeedsAdapter.MyViewHolder> {

    private ArrayList<Feeds> feeds;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, time, text, nlikes, ncomments;
        public ImageView icon, image;
        public TextView like, comment, share;


        public MyViewHolder(View view) {
            super(view);
            this.name = view.findViewById(R.id.name);
            this.time = view.findViewById(R.id.time);
            this.text = view.findViewById(R.id.text);
            this.nlikes = view.findViewById(R.id.nlike);
            this.ncomments = view.findViewById(R.id.ncomments);
            this.icon = view.findViewById(R.id.imageView);
            this.image = view.findViewById(R.id.img);
            this.like = view.findViewById(R.id.like);
            this.comment = view.findViewById(R.id.comment);
            this.share = view.findViewById(R.id.share);
        }
    }

    public FeedsAdapter(ArrayList<Feeds> feeds) {
        this.feeds = feeds;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layoutcards, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Feeds feed = feeds.get(position);
        holder.name.setText(feed.getName());
        holder.time.setText(feed.getTime());
        holder.text.setText(feed.getText());
        holder.ncomments.setText(String.valueOf(feed.getNcomments()));
        holder.nlikes.setText(String.valueOf(feed.getNlikes()));
        holder.icon.setImageResource(feed.getImageicon());
        holder.image.setImageBitmap(feed.getImag());
        holder.like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.like.getCurrentTextColor()== Color.rgb(0,0,0)){
                    holder.like.setTextColor(Color.rgb(0,0,255));
                    holder.like.setTypeface(Typeface.DEFAULT_BOLD);
                    holder.nlikes.setText(String.valueOf(Integer.parseInt(holder.nlikes.getText().toString())+1)+"");
                }
                else{
                    holder.like.setTextColor(Color.rgb(0,0,0));
                    holder.like.setTypeface(Typeface.DEFAULT);
                    holder.nlikes.setText(String.valueOf(Integer.parseInt(holder.nlikes.getText().toString())-1)+"");
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return feeds.size();
    }
}
