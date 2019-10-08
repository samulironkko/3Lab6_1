package com.example.a3lab6_1;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.photos.Photo;
import com.flickr4java.flickr.photos.PhotoList;
import com.flickr4java.flickr.photos.SearchParameters;
import com.flickr4java.flickr.test.TestInterface;

import static com.flickr4java.flickr.photos.SearchParameters.RELEVANCE;

public class LoadPictures extends Thread {

  String searchString;

  public interface MyInterface {
    void returnImages(PhotoList<Photo> photoList);
  }

  public LoadPictures(MyInterface MyInterface, String search) {
    callBackInterface = MyInterface;
    searchString = search;
  }

  MyInterface callBackInterface = null;

  public void run() {
    try {
        String apiKey = "5ffc55344f85a9afa23dffe6370339c6";
        String sharedSecret = "007aeb5ce6608f33";
        Flickr flickr = new Flickr(apiKey, sharedSecret, new REST());

        SearchParameters searchParameters = new SearchParameters();
        searchParameters.setText(searchString);
        searchParameters.setSort(RELEVANCE);

        PhotoList<Photo> photoList = flickr.getPhotosInterface().search(searchParameters, 50, 1);

        callBackInterface.returnImages(photoList);


    }catch (Exception e){
        e.printStackTrace();
    }
  }

}
