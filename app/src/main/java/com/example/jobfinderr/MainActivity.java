package com.example.jobfinderr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageButton login;
    private Button create;
    private EditText username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login=findViewById(R.id.loginBtn);
        create=findViewById(R.id.createBtn);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=username.getText().toString();
                String pass=password.getText().toString();
                if(user.length()>0 && pass.length()>0) {
                    Intent i = new Intent(getApplicationContext(), HomePage.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Fill all the details",Toast.LENGTH_SHORT).show();
                }
            }
        });
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),SignIn.class);
                startActivity(i);
            }
        });
    }


}