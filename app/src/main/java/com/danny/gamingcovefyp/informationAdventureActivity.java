package com.danny.gamingcovefyp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by danny on 21/02/2017.
 */

public class informationAdventureActivity extends AppCompatActivity {
    private TextView informationActivityText;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informationadventureactivity);
        informationActivityText = (TextView)findViewById(R.id.informationAdventureText);
    }
}
