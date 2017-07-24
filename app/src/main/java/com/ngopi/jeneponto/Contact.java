package com.ngopi.jeneponto;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

/**
 * Created by Irfan Assidiq on 7/22/2017.
 */

public class Contact extends Home{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.FContent); //Remember this is the FrameLayout area within your activity_main.xml
        getLayoutInflater().inflate(R.layout.layout_contact, contentFrameLayout);
    }

    //this code implement onBackPress from Home
    @Override
    public void onBackPressed() {
        super.onBackPressed2();
        onStop();
    }


}
