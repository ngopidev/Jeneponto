package com.ngopi.jeneponto;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Config;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ngopi.jeneponto.*;
import com.ngopi.jeneponto.ConfigPerizinan;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;

//import butterknife.Bind;
//import butterknife.ButterKnife;

/**
 * Created by pranadana on 8/9/2017.
 */

public class Perizinan extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinnerIzin = (Spinner) findViewById(R.id.pilih_izin);
    TextView hasilPersyaratan = (TextView) findViewById(R.id.persyaratan);
    TextView hasilLamaProses = (TextView) findViewById(R.id.lama_proses);
    TextView hasilBiaya = (TextView) findViewById(R.id.biaya);
    TextView hasilJangkaWaktu = (TextView) findViewById(R.id.jangka_waktu);


    //An ArrayList for Spinner Items
    private ArrayList<String> izin;

    //JSON Array
    private JSONArray result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_perizinan);

//        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View rootView = inflater.inflate(R.layout.layout_perizinan, container, false);

        //Initializing the ArrayList
        izin = new ArrayList<String>();

        //Adding an Item Selected Listener to our Spinner
        //As we have implemented the class Spinner.OnItemSelectedListener to this class iteself we are passing this to setOnItemSelectedListener
        spinnerIzin.setOnItemSelectedListener(this);

        //This method will fetch the data from the URL
        getData();

//        ButterKnife.bind(this, rootView);
//        return rootView;
    }

    private void getData(){
        //Creating a string request
        StringRequest stringRequest = new StringRequest(ConfigPerizinan.DATA_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject j = null;
                        try {
                            //Parsing the fetched Json String to JSON Object
                            j = new JSONObject(response);

                            //Storing the Array of JSON String to our JSON Array
                            result = j.getJSONArray(ConfigPerizinan.JSON_ARRAY);

                            //Calling method getStudents to get the students from the JSON Array
                            getIzin(result);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //Creating a request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        //Adding request to the queue
        requestQueue.add(stringRequest);
//        Volley.newRequestQueue(getActivity().getApplicationContext());
    }

    private void getIzin(JSONArray j){
        //Traversing through all the items in the json array
        for(int i=0;i<j.length();i++){
            try {
                //Getting json object
                JSONObject json = j.getJSONObject(i);

                //Adding the name of the student to array list
                izin.add(json.getString(ConfigPerizinan.TAG_JENIS_IZIN));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        //Setting adapter to show the items in the spinner
        spinnerIzin.setAdapter(new ArrayAdapter<String>(Perizinan.this, android.R.layout.simple_spinner_dropdown_item, izin));
    }

    //Method to get student name of a particular position
    private String getPersyaratan(int position){
        String persyaratan="";
        try {
            //Getting object of given index
            JSONObject json = result.getJSONObject(position);

            //Fetching name from that object
            persyaratan = json.getString(ConfigPerizinan.TAG_PERSYARATAN);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //Returning the name
        return persyaratan;
    }

    //Doing the same with this method as we did with getName()
    private String getLama(int position){
        String lamaProses="";
        try {
            JSONObject json = result.getJSONObject(position);
            lamaProses = json.getString(ConfigPerizinan.TAG_LAMA_PROSES);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return lamaProses;
    }

    //Doing the same with this method as we did with getName()
    private String getBiaya(int position){
        String biaya="";
        try {
            JSONObject json = result.getJSONObject(position);
            biaya = json.getString(ConfigPerizinan.TAG_BIAYA);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return biaya;
    }

    private String getJangkaWaktu(int position){
        String jangkaWaktu="";
        try {
            JSONObject json = result.getJSONObject(position);
            jangkaWaktu = json.getString(ConfigPerizinan.TAG_JANGKA_WAKTU);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jangkaWaktu;
    }


    //this method will execute when we pic an item from the spinner
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //Setting the values to textviews for a selected item
        hasilPersyaratan.setText(getPersyaratan(position));
        hasilLamaProses.setText(getLama(position));
        hasilBiaya.setText(getBiaya(position));
        hasilJangkaWaktu.setText(getJangkaWaktu(position));
    }

    //When no item is selected this method would execute
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        hasilPersyaratan.setText("");
        hasilLamaProses.setText("");
        hasilBiaya.setText("");
        hasilJangkaWaktu.setText("");
    }
}