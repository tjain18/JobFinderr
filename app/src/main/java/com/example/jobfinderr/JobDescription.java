package com.example.jobfinderr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class JobDescription extends AppCompatActivity {
    ImageButton back;
    TextView cname,compname,loc,desc;
    ImageView logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_job_description);
        Job j=(Job)getIntent().getSerializableExtra("myjob");
        back=findViewById(R.id.backBtn);
        cname=findViewById(R.id.companyName);
        logo=findViewById(R.id.companyLogo);
        compname=findViewById(R.id.companyname);
        loc=findViewById(R.id.location);
        desc=findViewById(R.id.description);
        cname.setText(j.company);
        compname.setText(j.company);
        logo.setImageResource(j.image);
        loc.setText(j.location);
        desc.setText(j.description);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}