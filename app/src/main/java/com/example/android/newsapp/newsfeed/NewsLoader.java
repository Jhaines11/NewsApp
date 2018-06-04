package com.example.android.newsapp.newsfeed;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * Created by Jeremy on 28/12/2016.
 */
class NewsLoader extends AsyncTaskLoader<List<News>> {

    NewsLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Override
    public List<News> loadInBackground() {
        List<News> listOfNews = null;
        try {
            URL url = OnLoaderCompleted.createUrl();
            String jsonResponse = OnLoaderCompleted.makeHttpRequest(url);
            listOfNews = OnLoaderCompleted.parseJson(jsonResponse);
        } catch (IOException e) {
            Log.e("Onloadercompleted", "Error Loader LoadInBackground: ", e);
        }
        return listOfNews;
    }
}
