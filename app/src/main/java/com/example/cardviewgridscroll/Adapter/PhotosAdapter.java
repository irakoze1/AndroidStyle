package com.example.cardviewgridscroll.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cardviewgridscroll.ModelClass.Photos;
import com.example.cardviewgridscroll.R;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.List;

public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.PhotosViewHolder>{

    private List<Photos> pList = new ArrayList<>();

    public PhotosAdapter(List<Photos> pList){
        this.pList = pList;
    }

    @NonNull
    @Override
    public PhotosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.each_item, parent, false);
        return new PhotosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotosViewHolder holder, int position) {
        holder.imageView.setImageResource(pList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return pList.size();
    }

    public class PhotosViewHolder extends RecyclerView.ViewHolder{
        RoundedImageView imageView;

        public PhotosViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
