package com.example.loginfirebase;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends Fragment {
    private FirebaseAuth mAuth;
    EditText editTextFirstName,editTextEmail,editTextID,editTextAddress,editTextGender,editTextPassword;
    Button register;
    TextView logInTxt;
    ViewPager mViewPager;

//    private FirebaseAuth mAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =
                inflater.inflate(R.layout.fragment_register, container, false);
        editTextFirstName = (EditText) view.findViewById(R.id.editTextFistName);
        editTextEmail = (EditText) view.findViewById(R.id.editTextEmail);
        editTextID = (EditText) view.findViewById(R.id.editTextID);
        editTextAddress = (EditText) view.findViewById(R.id.editTextAddress);
        editTextGender = (EditText) view.findViewById(R.id.editTextGender);
        editTextPassword = (EditText) view.findViewById(R.id.editTextPassword);
         mViewPager = (ViewPager) view.findViewById(R.id.viewPager);


         logInTxt = (TextView) view.findViewById(R.id.logIn);
         register = (Button) view.findViewById(R.id.registerBtn);
        logInTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),LogIn.class);
                startActivity(intent);

            }
        });



        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth = FirebaseAuth.getInstance();
                registerFunction();
            }
        });
    }

    public void registerFunction() {
        String name = editTextFirstName.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String id = editTextID.getText().toString().trim();
        String address = editTextAddress.getText().toString().trim();
        String gender = editTextGender.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if(name.isEmpty()){
            editTextFirstName.setError("Full name is required");
            editTextFirstName.requestFocus();
            return;
        }
        if(email.isEmpty()){
            editTextEmail.setError("Email is required");
            editTextEmail.requestFocus();
            return;
        }
        if(id.isEmpty()){
            editTextID.setError("ID is required");
            editTextID.requestFocus();
            return;
        }
        if(address.isEmpty()){
            editTextAddress.setError("Address is required");
            editTextAddress.requestFocus();
            return;
        }
        if(gender.isEmpty()){
            editTextGender.setError("Gender is required");
            editTextGender.requestFocus();
            return;
        }
        if(password.isEmpty()){
            editTextPassword.setError("Password is required");
            editTextPassword.requestFocus();
            return;
        }
        if(password.length() < 6){
            editTextPassword.setError("Password Should be more than 6 characters");

            editTextPassword.requestFocus();
            return;
        }
        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Users user = new Users(name,id,address,gender);
                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){

                                        Toast.makeText(getActivity(), "User Registered successfully", Toast.LENGTH_SHORT).show();

                                    }else{
                                        Toast.makeText(getActivity(), "Failed to input user to database", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        }else{
                            Toast.makeText(getActivity(), "Failed to register user", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }


}