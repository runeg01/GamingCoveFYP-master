package com.danny.gamingcovefyp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by danny on 22/02/2017.
 */

public class informationFPSActivity extends AppCompatActivity {
    private TextView informationFPS;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informationfpsactivity);
        informationFPS = (TextView) findViewById(R.id.informationFPSText);
    }

}


