package com.ngopi.jeneponto;

import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
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
import android.view.MenuItem;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

        
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

            Intent anIntent = new Intent(getApplicationContext(), MianActivity.class);
            anIntent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(anIntent);
//            drawerLayout.closeDrawers();
        } else if (id == R.id.wisata) {
            Sdialog();
        } else if (id == R.id.peluang) {
            Sdialog();
        } else if (id == R.id.prosedur) {
//            Intent ipros = new Intent(getApplicationContext(), Prosedur.class);
//            startActivity(ipros);
            Sdialog();
        } else if (id == R.id.tracking) {
            Sdialog();
        } else if (id == R.id.kalkulator) {
            Intent ikalk = new Intent(getApplicationContext(), Kalkulator.class);
            startActivity(ikalk);
            drawerLayout.closeDrawers();
        } else if (id == R.id.keluhan) {
            Sdialog();
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


}
