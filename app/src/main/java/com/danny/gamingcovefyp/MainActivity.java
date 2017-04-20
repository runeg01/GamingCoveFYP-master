package com.danny.gamingcovefyp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button registerButton;
    private EditText enterEmail;
    private EditText enterPassword;
    private TextView signIn;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(this);
        registerButton = (Button) findViewById(R.id.registerButton);
        enterEmail = (EditText) findViewById(R.id.enterEmail);
        enterPassword = (EditText) findViewById(R.id.enterPassword);
        signIn = (TextView) findViewById(R.id.signIn);

        registerButton.setOnClickListener(this);
        signIn.setOnClickListener(this);

        firebaseAuth = firebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser()!= null){
            finish();
            startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
        }

    }

    private void registerUser(){
        String email = enterEmail.getText().toString().trim();
        String password = enterPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)){
            //email is empty
            Toast.makeText(this, "please enter email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)){
            //password is empty
            Toast.makeText(this, "please enter password", Toast.LENGTH_SHORT).show();
            return;
        }
        //progress box showing user being registered
        progressDialog.setMessage("Registering user...");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email, password)
                //called when task is complete
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //register successfully
                        if (task.isSuccessful()){
                            finish();
                            startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
                            Toast.makeText(MainActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();

                        }else{
                            //register failure
                            Toast.makeText(MainActivity.this, "Could not register", Toast.LENGTH_SHORT).show();
                        }
                        progressDialog.hide();

                    }
                });
    }

    @Override
    public void onClick(View view) {
        if (view == registerButton){
            registerUser();
        }
        if(view == signIn){
            startActivity(new Intent(this, LoginActivity.class));
        }

    }
}
