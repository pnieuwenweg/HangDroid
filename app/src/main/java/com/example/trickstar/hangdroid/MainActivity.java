package com.example.trickstar.hangdroid;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.content.Intent;



public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

     public void startSinglePlayerGame(View v) {

         Intent myIntent = new Intent(this,GameActivity.class);

         startActivity(myIntent);

    }


    public void startMultiGame(View v) {

        Intent myIntent = new Intent(this,MultiPlayerActivity.class);

        startActivity(myIntent);

    }

}
