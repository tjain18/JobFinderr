package com.example.jobfinderr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class SignIn extends AppCompatActivity {
    private ImageButton create;
    private EditText username,phone,email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        create=findViewById(R.id.createBtn);
        username=findViewById(R.id.newUsername);
        phone=findViewById(R.id.newPhone);
        email=findViewById(R.id.newEmail);
        password=findViewById(R.id.newPassword);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user= username.getText().toString();
                String pass=password.getText().toString();
                String pno=phone.getText().toString();
                String emailid=email.getText().toString();
                if(user.length()>0 && pass.length()>0 && pno.length()>0 && emailid.length()>0)
                    finish();
                else
                    Toast.makeText(SignIn.this,"Fill all the details",Toast.LENGTH_SHORT).show();
            }
        });
    }
}