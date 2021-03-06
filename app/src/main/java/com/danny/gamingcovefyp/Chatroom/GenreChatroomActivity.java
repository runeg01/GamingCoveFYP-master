package com.danny.gamingcovefyp.Chatroom;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.danny.gamingcovefyp.DashboardActivity;
import com.danny.gamingcovefyp.R;
import com.danny.gamingcovefyp.informationAdventureActivity;
import com.danny.gamingcovefyp.informationFPSActivity;
import com.danny.gamingcovefyp.informationMOBAActivity;
import com.danny.gamingcovefyp.informationRPGActivity;
import com.danny.gamingcovefyp.informationRTSActivity;
import com.danny.gamingcovefyp.informationSportsActivity;


//THIS CLASS IS TO ALLOW THE USER TO CHOOSE A GENRE OF THE CHAT ROOM
public class GenreChatroomActivity extends AppCompatActivity implements View.OnClickListener {
    private Button buttonFPS;
    private Button buttonRPG;
    private Button buttonAdventure;
    private Button buttonRTS;
    private Button buttonMOBA;
    private Button buttonSports;
    private Button buttonBack;

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
        buttonAdventure =(Button)findViewById(R.id.buttonAdventure);
        buttonRPG = (Button)findViewById(R.id.buttonRPG);
        buttonRTS = (Button)findViewById(R.id.buttonRTS);
        buttonMOBA = (Button)findViewById(R.id.buttonMOBA);
        buttonSports = (Button)findViewById(R.id.buttonSports);
        buttonBack = (Button) findViewById(R.id.buttonBack);

        infoAdventure.setOnClickListener(this);
        infoRPG.setOnClickListener(this);
        infoFPS.setOnClickListener(this);
        infoRTS.setOnClickListener(this);
        infoMOBA.setOnClickListener(this);
        infoSports.setOnClickListener(this);

        buttonFPS.setOnClickListener(this);
        buttonAdventure.setOnClickListener(this);
        buttonRPG.setOnClickListener(this);
        buttonRTS.setOnClickListener(this);
        buttonMOBA.setOnClickListener(this);
        buttonSports.setOnClickListener(this);
        buttonBack.setOnClickListener(this);
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
        if (view == buttonAdventure){
            startActivity(new Intent(this, AddAdventureRoomActivity.class));
        }
        if (view == buttonRPG){
            startActivity(new Intent(this,AddRPGRoomActivity.class));
        }
        if (view == buttonRTS){
            startActivity(new Intent(this, AddRTSRoomActivity.class));
        }
        if (view == buttonMOBA){
            startActivity(new Intent(this, AddMOBARoomActivity.class));
        }
        if (view == buttonSports){
            startActivity(new Intent(this, AddSportsRoomActivity.class));
        }
        if (view == buttonBack){
            startActivity(new Intent (this, DashboardActivity.class));
        }

    }
}
