package com.example.insta_clone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class loginActivity extends AppCompatActivity {
    public static final String TAG="LoginActivity";
    EditText editName;
    EditText editPass;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if(ParseUser.getCurrentUser()!=null)
        {
            goMainActivity();
        }

        editName=findViewById(R.id.editName);
        editPass= findViewById(R.id.editTextTextPassword);
        btnLogin= findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username= editName.getText().toString();
                String password= editPass.getText().toString();
                loginUser(username,password);
            }
        });
    }

    private void loginUser(String username, String password) {
        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (e!=null)
                {
                    return;
                }

                goMainActivity();
                Toast.makeText(loginActivity.this,"Login Succesful", Toast.LENGTH_SHORT).show();
            }
        });
        //Intent i=  new Intent(loginActivity.this, MainActivity.class);
        //startActivity(i);
    }

    private void goMainActivity() {
        Intent i=  new Intent(loginActivity.this, MainActivity.class);
        startActivity(i);
        finish();
    }
}