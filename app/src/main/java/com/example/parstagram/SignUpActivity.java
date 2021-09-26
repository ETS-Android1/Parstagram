package com.example.parstagram;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import java.util.concurrent.ConcurrentLinkedQueue;

public class SignUpActivity extends AppCompatActivity {
    public static final String TAG = "SignUpActivity";
    private EditText etUsername_;
    private EditText etPass;
    private EditText etEmail;
    private Button btnSignUp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etUsername_ = findViewById(R.id.etUsername_);
        etPass = findViewById(R.id.etPass);
        etEmail = findViewById(R.id.etEmail);
        btnSignUp = findViewById(R.id.btnSign);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG,"onClick signup button");
                String username = etUsername_.getText().toString();
                String password = etPass.getText().toString();
                String email = etEmail.getText().toString();
                ParseUser user = new ParseUser();

                user.setEmail(email);
                user.setUsername(username);
                user.setPassword(password);
                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e != null) {
                            Log.e(TAG, "Issue with registering user", e);
                            Toast.makeText(SignUpActivity.this, "Issue with the Login", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        goMainActivity();
                        Toast.makeText(SignUpActivity.this, "Success!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
    private void goMainActivity() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}
