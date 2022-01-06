package com.example.loginfirebase;


import android.app.ProgressDialog;
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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    Button logIn1;
    EditText emailEd, passwordEd;
    TextView registerTxt;

    private FirebaseAuth auth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logIn1 = findViewById(R.id.logInButton);
        registerTxt = findViewById(R.id.registerTxt);
        emailEd = findViewById(R.id.email);
        passwordEd = findViewById(R.id.logInPassword);
        auth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);


        registerTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        logIn1.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {

                                          String email = emailEd.getText().toString().trim();
                                          String password = passwordEd.getText().toString().trim();
                                          if (email.isEmpty()) {
                                              emailEd.setError("Email is required");
                                              emailEd.requestFocus();
                                              return;
                                          }else if (password.isEmpty()) {
                                              passwordEd.setError("password is required");
                                              passwordEd.requestFocus();
                                              return;
                                          }else if (password.length() < 6) {
                                              Toast.makeText(getBaseContext(), "Password needs to be more than 6 characters", Toast.LENGTH_LONG).show();
                                              passwordEd.setError("Use more than 6 characters");
                                          } else

                                                  progressDialog.setTitle("Please Wait...");
                                                  progressDialog.setMessage("Checking Credentials");
                                                  progressDialog.setCanceledOnTouchOutside(false);
                                                  progressDialog.show();

                                                  auth.signInWithEmailAndPassword(email, password)
                                                  .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                                                      @Override
                                                      public void onComplete(@NonNull Task<AuthResult> task) {
                                                          progressDialog.dismiss();

                                                          if (task.isSuccessful()) {
                                                              Toast.makeText(MainActivity.this, "Successfully Logged in", Toast.LENGTH_SHORT).show();
                                                              Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                                                              startActivity(intent);
                                                          }
                                                      }


                                              }).addOnFailureListener(new OnFailureListener() {
                                                  @Override
                                                  public void onFailure(@NonNull Exception e) {
                                                      Toast.makeText(getApplicationContext(),"User not Register! Try registering first "+e.toString(),Toast.LENGTH_SHORT).show();

                                                  }
                                          });
                                      }

                                  })
        ;}
}