package com.spam.maddy.kratindemoproject.maps;

import android.content.Context;
import android.os.AsyncTask;

import com.google.android.gms.maps.GoogleMap;

public class GooglePlacesReadTask extends AsyncTask<Object, Integer, String> {
    String googlePlacesData = null;
    GoogleMap googleMap;

    Context context;

    public GooglePlacesReadTask(Context context)
    {
     this.context = context;
    }
    @Override
    protected String doInBackground(Object... inputObj) {
        try {
            googleMap = (GoogleMap) inputObj[0];
            String googlePlacesUrl = (String) inputObj[1];
            Http http = new Http();
            googlePlacesData = http.read(googlePlacesUrl);
            android.util.Log.d("Google Place Read Task",googlePlacesData);
        } catch (Exception e) {
            android.util.Log.d("Google Place Read Task", e.toString());
        }
        return googlePlacesData;
    }

    @Override
    protected void onPostExecute(String result) {
        PlacesDisplayTask placesDisplayTask = new PlacesDisplayTask(context);
        Object[] toPass = new Object[2];
        toPass[0] = googleMap;
        toPass[1] = result;
        placesDisplayTask.execute(toPass);
    }
}