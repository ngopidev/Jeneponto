package com.ngopi.jeneponto;

import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityOptionsCompat;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private String TAG = Home.class.getSimpleName();

    private ProgressDialog pDialog;
    private ListView lv;

    // URL to get contacts JSON
    private static String url = "http://visitjeneponto.id/getdata.php/";

    ArrayList<HashMap<String, String>> contactList;

//    this method for showing the dialog
    public void Sdialog() {
        AlertDialog mDialog = new AlertDialog.Builder(this)
                .setTitle("Aplikasi Jeneponto")
                .setMessage("Maaf Fitur Ini Belun Tersedia")
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Log.i("MyTag", "Click YES");
                            }
                        })
                .create();

        mDialog.show();
    }

//    this one using for show everything in apps
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.yellowHard));
        setSupportActionBar(toolbar);

        contactList = new ArrayList<>();

        lv = (ListView) findViewById(R.id.list);

        new GetContacts().execute();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

//    this one is using for controlling the back press
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
//            super.onBackPressed();
            AlertDialog mDialog = new AlertDialog.Builder(this)
                    .setTitle("Aplikasi Jeneponto")
                    .setMessage("Apa Anda Yakin Ingin Keluar?")
                    .setPositiveButton("Ya",
                            new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Log.i("MyTag", "Click Ya");
                                    System.exit(0);
//                                    onDestroy();
                                }

                            })
                    .setNegativeButton("Tidak",
                            new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Log.i("MyTag", "Click Tidak");

                                }

                            })
                    .create();

            mDialog.show();
        }
    }

//    using this code if you want to generate onBackPressed in anothe screen
    public void onBackPressed2(){

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

//            this one for navigate beranda
        if (id == R.id.beranda) {

            Intent anIntent = new Intent(getApplicationContext(), Home.class);
            anIntent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(anIntent);
//            drawerLayout.closeDrawers();
        } else if (id == R.id.wisata) {
            Sdialog();
        } else if (id == R.id.peluang) {

        } else if (id == R.id.prosedur) {

        } else if (id == R.id.tracking) {
            Sdialog();
        } else if (id == R.id.kalkulator) {

        } else if (id == R.id.keluhan) {

        } else if (id == R.id.hubungi) {

            if (R.id.FContent == R.layout.layout_contact) {
                    //do Nothing
            }else{
                Intent anIntent = new Intent(getApplicationContext(), Contact.class);
                anIntent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(anIntent);
                drawerLayout.closeDrawers();
            }
        } else if (id == R.id.bahasa) {
          Sdialog();
        }

        DrawerLayout drawer = drawerLayout;
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private class GetContacts extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(getApplicationContext());
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url);

            Log.e(TAG, "Response from url: " + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array node
                    JSONArray contacts = jsonObj.getJSONArray("berita");

                    // looping through All Contacts
                    for (int i = 0; i < contacts.length(); i++) {
                        JSONObject c = contacts.getJSONObject(i);

//                        String id = c.getString("id");
                        String kode = c.getString("kode");
                        String image = c.getString("image");
                        String judul = c.getString("judul");
                        String isikonten = c.getString("isi_konten");
                        String tanggal = c.getString("tanggal_rilis");
                        String by = c.getString("created_by");

                        // Phone node is JSON Object
//                        JSONObject phone = c.getJSONObject("phone");
//                        String mobile = phone.getString("mobile");
//                        String home = phone.getString("home");
//                        String office = phone.getString("office");

                        // tmp hash map for single contact
                        HashMap<String, String> contact = new HashMap<>();

                        // adding each child node to HashMap key => value
//                        contact.put("kode", id);
                        contact.put("judul", judul);
                        contact.put("isi_konten", isikonten);
                        contact.put("tanggal", tanggal);
                        contact.put("created_by", by);

                        // adding contact to contact list
                        contactList.add(contact);
                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });

                }
            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });

            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
            /**
             * Updating parsed JSON data into ListView
             * */
            ListAdapter adapter = new SimpleAdapter(
                    getApplicationContext(), contactList,
                    R.layout.list_item, new String[]{"tanggal", "judul",
                    "isi_konten","created_by"}, new int[]{R.id.tanggal, R.id.judul,
                    R.id.konten, R.id.author});

            lv.setAdapter(adapter);
        }

    }

}
