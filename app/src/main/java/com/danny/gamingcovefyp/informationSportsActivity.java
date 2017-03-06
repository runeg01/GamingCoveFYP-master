package com.danny.gamingcovefyp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by danny on 22/02/2017.
 */

public class informationSportsActivity extends AppCompatActivity {

    private TextView informationSports;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informationsportsactivity);
        informationSports = (TextView) findViewById(R.id.informationSportsText);
    }

}

