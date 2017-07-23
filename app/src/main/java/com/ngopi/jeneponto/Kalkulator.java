package com.ngopi.jeneponto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Spinner;

public class Kalkulator extends Home {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.FContent); //Remember this is the FrameLayout area within your activity_main.xml
        getLayoutInflater().inflate(R.layout.layout_kalkulator, contentFrameLayout);

        Spinner
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed2();
    }
}
