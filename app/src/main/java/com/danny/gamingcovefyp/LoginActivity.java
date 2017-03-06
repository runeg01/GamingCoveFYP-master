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

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private Button logInButton;
    private EditText enterEmail;
    private EditText enterPassword;
    private TextView signUp;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        logInButton = (Button) findViewById(R.id.signInButton);
        enterEmail = (EditText) findViewById(R.id.enterEmail_login);
        enterPassword = (EditText) findViewById(R.id.enterPassword_login);
        signUp = (TextView) findViewById(R.id.signUp);
        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser()!= null){
            finish();
            startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
        }

        logInButton.setOnClickListener(this);
        signUp.setOnClickListener(this);

    }

    private void userLogin(){
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
        progressDialog.setMessage("Logging in user...");
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if(task.isSuccessful()){
                            finish();
                            startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
                        }
                    }
                });
    }

    @Override
    public void onClick(View view) {
        if (view == logInButton){
            userLogin();
        }
        if (view == signUp){
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }

    }
}
