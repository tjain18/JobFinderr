package com.example.jobfinderr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AppCompatActivity implements JobsListener{
    String api="https://serpapi.com/search.json?engine=google_jobs&q=jobs&hl=en&api_key=8631d8f0a5783b064a73d89d397bb20474696e046c203f4e99058809d6a2a056";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        TextView showjobs,showInterestedJobs;
        RecyclerView jobsRecyclerView=findViewById(R.id.jobRecyclerView);
        RecyclerView jobbRecyclerView=findViewById(R.id.jobbRecyclerView);
        showjobs=findViewById(R.id.showJobs);
        showInterestedJobs=findViewById(R.id.showInterested);
        List<Job> jobs=new ArrayList<>();
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        // Request a string response from the provided URL.

        StringRequest stringRequest = new StringRequest(Request.Method.GET, api,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
//                        textView.setText("Response is: " + response.substring(0,500));
                        try {
                            JSONObject jsonObject=new JSONObject(response);
                            JSONArray jsonarray=new JSONArray(jsonObject.get("jobs_results").toString());

                            for(int i=0; i<jsonarray.length(); i++) {
                                JSONObject jobj = new JSONObject(jsonarray.get(i).toString());
                                Job j=new Job();
                                j.image = R.drawable.google_logo;
                                j.company = jobj.get("company_name").toString();
                                j.location = jobj.get("location").toString();
                                j.role = jobj.get("title").toString();
                                j.description = jobj.get("description").toString();
                                jobs.add(j);
                                Log.e("api", "tamanna:" + j.company + j.location + j.role + j.description);
                            }
                            final JobsAdapter jobsAdapter=new JobsAdapter(jobs,HomePage.this);
                            jobsRecyclerView.setAdapter(jobsAdapter);
                            jobbRecyclerView.setAdapter(jobsAdapter);
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                        //Log.e("api","onErrorResponse: "+response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                textView.setText("That didn't work!");
                Log.e("api","onErrorResponse: "+error.getLocalizedMessage());
            }
        });
        //Add the request to the RequestQueue.
        requestQueue.add(stringRequest);

//        final JobsAdapter jobsAdapter=new JobsAdapter(jobs,this);
//        jobsRecyclerView.setAdapter(jobsAdapter);
//        jobbRecyclerView.setAdapter(jobsAdapter);
        showjobs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),JobsList.class);
                startActivity(i);
            }
        });
        showInterestedJobs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),InterestedJobs.class);
                startActivity(i);
            }
        });
        Log.e("apppppi","tamannnnnnaaaaaaajain"+jobs.size());
    }

    @Override
    public void onJobAction(Boolean isSelected, Job job) {
        if(isSelected){
            Intent i = new Intent(getApplicationContext(),JobDescription.class);
            i.putExtra("myjob", job);
            startActivity(i);
        }
    }
}