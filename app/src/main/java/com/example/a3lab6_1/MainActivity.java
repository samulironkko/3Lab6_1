package com.example.a3lab6_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.flickr4java.flickr.photos.Photo;
import com.flickr4java.flickr.photos.PhotoList;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, LoadPictures.MyInterface {

    EditText searcText;
    Button button;
    ImageView imageView;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searcText = findViewById(R.id.editText);
        imageView = findViewById(R.id.listItem);
        listView = findViewById(R.id.listView);

        button = findViewById(R.id.loadButton);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        LoadPictures loadPictures = new LoadPictures(this, searcText.getText().toString());
        loadPictures.start();
    }

    public void returnImages(final PhotoList<Photo> photoList) {
        MainActivity.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //Picasso.get().load("https://farm" + photoList.get(1).getFarm() +".staticflickr.com/" + photoList.get(1).getServer() + "/" + photoList.get(1).getId() + "_" + photoList.get(1).getSecret() + ".jpg").into(imageView);
                listView.setAdapter(new ImageListAdapter(MainActivity.this, photoList));
            }
        });
    }
}
