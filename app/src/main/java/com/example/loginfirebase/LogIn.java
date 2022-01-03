package com.example.loginfirebase;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogIn extends AppCompatActivity {
    Button logIn1;
    EditText emailEd,passwordEd ;
    TextView registerTxt;

    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        logIn1 = findViewById(R.id.logInButton);
        registerTxt = findViewById(R.id.registerTxt);
         emailEd = findViewById(R.id.email);
         passwordEd = findViewById(R.id.logInPassword);


        registerTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LogIn.this,MainActivity.class);
                startActivity(intent);
            }
        });
        logIn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth = FirebaseAuth.getInstance();
                String email = emailEd.getText().toString().trim();
                String password = passwordEd.getText().toString().trim();
                if(email.isEmpty()){
                    emailEd.setError("Email is required");
                    emailEd.requestFocus();
                    return;
                }
                if(password.isEmpty()){
                    passwordEd.setError("password is required");
                    passwordEd.requestFocus();
                    return;
                }
                auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(LogIn.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(LogIn.this, "Successfully Logged in", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(LogIn.this,MainActivity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(LogIn.this, "Error try again", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }

}