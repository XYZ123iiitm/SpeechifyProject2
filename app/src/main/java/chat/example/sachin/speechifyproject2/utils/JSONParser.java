package chat.example.sachin.speechifyproject2.utils;

/**
 * Created by Sachin on 26-03-2016.
 */

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class JSONParser {
    static InputStream is = null;
    static JSONObject jObj = null;
    static JSONArray jAry = null;
    static String json = "";

    // constructor
    public JSONParser() {}

    public JSONObject getJSONFromUrl(String stringUrl) {
        // Making HTTP request
        Log.d("dsf5",stringUrl);
        BufferedReader bufferedReader;
        try {

            URL url=new URL(stringUrl);
            HttpURLConnection urlConnection= (HttpURLConnection) url.openConnection();
            urlConnection.getDoInput();

            is=urlConnection.getInputStream();

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                Log.d("line",line);
                sb.append(line);
                sb.append("\r\n");
            }
            is.close();
            json = sb.toString();
            Log.e("JSONOBJECT",json);
        } catch (Exception e) {
            Log.e("Buffer Error", "Error converting result " + e.toString());
        }
        // try parse the string to a JSON object
        try {
            jObj = new JSONObject(json);
        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        }
        Log.d("dsf6",jObj.toString());
        return jObj;
    }

    public JSONArray getJSONArray(String stringUrl) {
        // Making HTTP request
        BufferedReader bufferedReader;
        try {

            URL url=new URL(stringUrl);
            HttpURLConnection urlConnection= (HttpURLConnection) url.openConnection();
            urlConnection.getDoInput();

            is=urlConnection.getInputStream();

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
                sb.append("\r\n");
            }
            is.close();
            json = sb.toString();
            Log.e("JSONARRAY",json);
        } catch (Exception e) {
            Log.e("Buffer Error", "Error converting result " + e.toString());
        }
        // try parse the string to a JSON object
        try {
            jAry = new JSONArray(json);
        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        }
        // return JSON String
        return jAry;
    }
}
