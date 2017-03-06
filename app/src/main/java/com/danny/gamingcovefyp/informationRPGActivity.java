package com.danny.gamingcovefyp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by danny on 22/02/2017.
 */

public class informationRPGActivity extends AppCompatActivity {
    private TextView informationRPG;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informationrpgactivity);
        informationRPG = (TextView) findViewById(R.id.informationRPGText);
    }

}
