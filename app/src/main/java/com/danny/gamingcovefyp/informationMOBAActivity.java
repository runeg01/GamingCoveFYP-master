package com.danny.gamingcovefyp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by danny on 22/02/2017.
 */

public class informationMOBAActivity extends AppCompatActivity {

    private TextView informationMOBA;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informationmobaactivity);
        informationMOBA = (TextView) findViewById(R.id.informationMOBAText);
    }

}

