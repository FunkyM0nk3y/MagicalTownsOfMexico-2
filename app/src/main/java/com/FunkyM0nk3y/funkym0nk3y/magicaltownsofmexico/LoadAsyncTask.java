package com.FunkyM0nk3y.funkym0nk3y.magicaltownsofmexico;

import android.app.ListFragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by FunkyM0nk3y on 8/29/15.
 */
public class LoadAsyncTask extends AsyncTask<String, String, ArrayList<MagicalTown>> {
    private Context context;
    private ListFragment listMT;
    private ProgressDialog dialog;
    static private String loadTitle = "Loading...";

    public LoadAsyncTask(Context c, ListFragment f) {
        context = c;
        listMT = f;
        dialog = new ProgressDialog(context);
    }

    @Override
    protected void onPreExecute() {
        // TODO Auto-generated method stub
        super.onPreExecute();
        dialog.setTitle(loadTitle);
        dialog.setCancelable(false);
        dialog.show();
    }

    @Override
    protected void onProgressUpdate(String... values) {
        // TODO Auto-generated method stub
        super.onProgressUpdate(values);
    }

    private String dameJSON(String jsonURL) {
        HttpURLConnection connection = null;
        StringBuilder builder = new StringBuilder();
        try {
            URL url = new URL(jsonURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Accept-Charset", "utf-8");
            connection.connect();

            int status = connection.getResponseCode();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            String line = "";
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        } catch (Exception ex) {
            Log.e("Error", "File not found. e: " + ex);
        } finally {
            connection.disconnect();
        }
        return builder.toString();
    }

    @Override
    protected ArrayList<MagicalTown> doInBackground(String... params) {
        ArrayList<MagicalTown> objets = new ArrayList<MagicalTown>();
        String json = dameJSON(params[0]);

        try {
            JSONObject objet = new JSONObject(json);
            JSONArray array = objet.getJSONArray("rows");

            for (int i = 0; i < array.length(); i++) {
                JSONArray ob = array.getJSONArray(i);
                String magicaltown = ob.getString(0);
                String state = ob.getString(1);
                String latitude = ob.getString(2);
                String longitude = ob.getString(3);
                objets.add(new MagicalTown(magicaltown, state, latitude, longitude));
            }

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return objets;
    }

    @Override
    protected void onPostExecute(ArrayList<MagicalTown> result) {
        // TODO Auto-generated method stub
        super.onPostExecute(result);
        MagicalTownListAdapter adp = new MagicalTownListAdapter(context, result);
        listMT.setListAdapter(null);
        listMT.setListAdapter(adp);

        dialog.dismiss();
    }
}
