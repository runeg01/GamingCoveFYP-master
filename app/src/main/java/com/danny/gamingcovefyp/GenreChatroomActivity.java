package com.danny.gamingcovefyp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by danny on 21/02/2017.
 */

public class GenreChatroomActivity extends AppCompatActivity implements View.OnClickListener {
    private Button buttonFPS;
    private Button buttonRPG;
    private Button buttonAdventure;
    private Button buttonRTS;
    private Button buttonMOBA;
    private Button buttonSports;

    private TextView infoAdventure;
    private TextView infoRPG;
    private TextView infoFPS;
    private TextView infoRTS;
    private TextView infoMOBA;
    private TextView infoSports;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genrechatroomactivity);


        infoAdventure = (TextView)findViewById(R.id.infoAdventure);
        infoRPG = (TextView)findViewById(R.id.infoRPG);
        infoFPS = (TextView)findViewById(R.id.infoFPS);
        infoRTS = (TextView)findViewById(R.id.infoRTS);
        infoMOBA = (TextView)findViewById(R.id.infoMOBA);
        infoSports=(TextView)findViewById(R.id.infoSports);

        buttonFPS = (Button)findViewById(R.id.buttonFPS);

        infoAdventure.setOnClickListener(this);
        infoRPG.setOnClickListener(this);
        infoFPS.setOnClickListener(this);
        infoRTS.setOnClickListener(this);
        infoMOBA.setOnClickListener(this);
        infoSports.setOnClickListener(this);

        buttonFPS.setOnClickListener(this);
    }








    @Override
    public void onClick(View view) {
        if (view == infoAdventure){

            startActivity(new Intent(this, informationAdventureActivity.class));
        }
        if (view == infoRPG){

            startActivity(new Intent(this, informationRPGActivity.class));
        }
        if (view == infoFPS){

            startActivity(new Intent(this, informationFPSActivity.class));
        }
        if (view == infoRTS){
            startActivity(new Intent(this, informationRTSActivity.class));
        }
        if (view == infoMOBA){
            startActivity(new Intent(this, informationMOBAActivity.class));
        }
        if (view == infoSports){
            startActivity(new Intent(this, informationSportsActivity.class));
        }
        if (view == buttonFPS){
            startActivity(new Intent(this, AddRoomActivity.class));
        }

    }
}
