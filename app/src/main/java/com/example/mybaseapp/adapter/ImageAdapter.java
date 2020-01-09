package com.example.mybaseapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.mybaseapp.R;
import com.example.mybaseapp.data.Image;

import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.MyViewHolder> {

    FragmentActivity activity;
    ArrayList<Image> images;

    public ImageAdapter(FragmentActivity activity, ArrayList<Image> images) {
        this.activity = activity;
        this.images = images;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_login, parent);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        if (images.get(position).xtImage != null && !images.get(position).xtImage.isEmpty()) {
            Glide.with(activity).load(images.get(position).xtImage).into(holder.logoIV);
        } else {
            holder.logoIV.setImageResource(R.mipmap.ic_launcher);
        }
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView logoIV;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            logoIV = itemView.findViewById(R.id.logoIV);
        }
    }
}
