package com.ngopi.jeneponto;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.annotation.Obsolete;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.ngopi.jeneponto.R;
import com.ngopi.jeneponto.adapter.AdapterProsedur;
import com.ngopi.jeneponto.app.AppController;
import com.ngopi.jeneponto.data.DataProsedur;

public class Prosedur extends AppCompatActivity {
    TextView persyaratan;
    Spinner spinnerIzin;
    ProgressDialog pDialog;
    Adapter adapter;
    List<DataProsedur> listIzin = new ArrayList<DataProsedur>();

    public static final String url = "http://192.168.43.198/prosedur/db_config.php";
    private static final String TAG = Prosedur.class.getSimpleName();
    public static final String TAG_ID = "id";
    public static final String TAG_IZIN = "izin";

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_prosedur);

        persyaratan = (TextView) findViewById(R.id.persyaratan);
        spinnerIzin = (Spinner) findViewById(R.id.jenis_izin);

        spinnerIzin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                persyaratan.setText(listIzin.get(position).getPersyaratan());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        adapter = new AdapterProsedur(Prosedur.this, listIzin);
        spinnerIzin.setAdapter((SpinnerAdapter) adapter);

        callData();
    }

    private void callData() {
        listIzin.clear();

        pDialog = new ProgressDialog(Prosedur.this);
        pDialog.setCancelable(false);
        pDialog.setMessage("Loading...");
        showDialog();

        JsonArrayRequest jArr = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>(){
                    @Override
                    public void onResponse (JSONArray response){
                        Log.e(TAG, response.toString());

                        for (int i = 0; i<response.length(); i++){
                            try {
                                JSONObject obj = response.getJSONObject(i);
                                DataProsedur item = new DataProsedur();
                                item.setId(obj.getString(TAG_ID));
                                item.setNamaIzin(obj.getString(TAG_IZIN));

                                listIzin.add(item);
                            }
                            catch (JSONException e){
                                e.printStackTrace();
                            }
                        }

                        adapter.notify();
                        hideDialog();
                    }
                }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){
                VolleyLog.e(TAG, "Error: "+error.getMessage());
                Toast.makeText(Prosedur.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                hideDialog();
            }
        }
        );
        AppController.getInstance().addToRequestQueue(jArr);
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.show();
    }

    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

}