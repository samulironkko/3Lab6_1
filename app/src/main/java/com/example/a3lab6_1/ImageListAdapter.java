package com.example.a3lab6_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.flickr4java.flickr.photos.Photo;
import com.flickr4java.flickr.photos.PhotoList;
import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ImageListAdapter extends ArrayAdapter {

    private Context context;
    private LayoutInflater inflater;
    private PhotoList<Photo> photos;


    public ImageListAdapter(@NonNull Context context, PhotoList<Photo> photoList) {
        super(context, R.layout.list_item, photoList);

        this.context = context;
        this.photos = photoList;

        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (null == convertView) {
            convertView = inflater.inflate(R.layout.list_item, parent, false);
        }

        Picasso
                .get()
                .load("https://farm" + photos.get(position).getFarm() +".staticflickr.com/" + photos.get(position).getServer() + "/" + photos.get(position).getId() + "_" + photos.get(position).getSecret() + ".jpg")
                .fit()
                .into((ImageView) convertView);

        return convertView;
    }
}
