package com.example.projectmad;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {
    EditText edUsername, edPassword;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
//    Objects of login Page
        edUsername= findViewById(R.id.editTextLoginUsername);
        edPassword= findViewById(R.id.editTextLoginPassword);
        btn= findViewById(R.id.buttonLogin);
        tv= findViewById(R.id.textViewNewUser);
//        Events of Login Button Sets here.
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,HomeActivity.class));
                /*String username= edUsername.getText().toString();
                String password= edPassword.getText().toString();
                Database db = new Database(getApplicationContext(),"healthcare",null,1);
                if(username.length()==0 || password.length()==0){
                    Toast.makeText(getApplicationContext(),"Please fill all details",Toast.LENGTH_SHORT).show();
                }else{
                    if (db.login(username,password)==1){
                        Toast.makeText(getApplicationContext(),"Login Success",Toast.LENGTH_SHORT).show();
                        //local memory shared perferences.
                        SharedPreferences sharedpreferences =getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor= sharedpreferences.edit();
                        editor.putString("username",username);
                        //To save our data with key and value
                        editor.apply();
                        startActivity(new Intent(LoginActivity.this,HomeActivity.class));
                    }else{
                        Toast.makeText(getApplicationContext(),"Invalid username and Password",Toast.LENGTH_SHORT).show();
                    }
                }*/
            }
        });
        // If we click on Register new user it redirects to new Activity
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Explicit Intent    If you call as a user defined Activity is Explicit Intent.
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });
    }
}