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
    String api="https://serpapi.com/search.json?engine=google_jobs&q=full&hl=en&api_key=8631d8f0a5783b064a73d89d397bb20474696e046c203f4e99058809d6a2a056";
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
        Job j=new Job();
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
                            JSONObject jobj=new JSONObject(jsonarray.get(0).toString());

                            j.image=R.drawable.google_logo;
                            j.company=jobj.get("company_name").toString();
                            j.location=jobj.get("location").toString();
                            j.role=jobj.get("title").toString();
                            j.description=jobj.get("description").toString();
                            Log.e("api","tamanna:"+j.company+j.location+j.role+j.description);
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

//        Job deloitte=new Job();
//        deloitte.image=R.drawable.google_logo;
//        deloitte.company="Google";
//        deloitte.location="Bangalore";
//        deloitte.role="Software Developer";
//        deloitte.description="Job brief Job brief\n" +
//                "    We are looking for an experienced Senior Accountant to oversee general accounting operations by controlling and verifying our financial transactions.\n" +
//                "\n" +
//                "    Senior Accountant responsibilities include reconciling account balances and bank statements, maintaining general ledger and preparing month-end close procedures. A successful Senior Accountant combines excellent analytical skills with a thorough knowledge of accounting principles to analyze financial reports and forecasts. The ideal candidate has also experience collaborating and/or managing a team of Accountants and Junior Accountants.\n" +
//                "\n" +
//                "    Senior Accountant duties also include ensuring accuracy and effectiveness in all of our accounting tasks.\n" +
//                "\n" +
//                "    Responsibilities\n" +
//                "    Verify, allocate, post and reconcile accounts payable and receivable\n" +
//                "    Produce error-free accounting reports and present their results\n" +
//                "    Analyze financial information and summarize financial status\n" +
//                "    Spot errors and suggest ways to improve efficiency and spending\n" +
//                "    Provide technical support and advice on Management Accountant\n" +
//                "    Review and recommend modifications to accounting systems and procedures\n" +
//                "    Manage accounting assistants and bookkeepers\n" +
//                "    Participate in financial standards setting and in forecast process\n" +
//                "    Provide input into department’s goal setting process\n" +
//                "    Prepare financial statements and produce budget according to schedule\n" +
//                "    Assist with tax audits and tax returns\n" +
//                "    Direct internal and external audits to ensure compliance\n" +
//                "    Plan, assign and review staff’s work\n" +
//                "    Support month-end and year-end close process\n" +
//                "    Develop and document business processes and accounting policies to maintain and strengthen internal controls\n" +
//                "    Ensure compliance with GAAP principles\n" +
//                "    Liaise with our Financial Manager and Accounting Manager to improve financial procedures\n" +
//                "    Requirements and skills\n" +
//                "    Proven experience as a Financial Controller, Accounting Supervisor, chief or senior accountant\n" +
//                "    Thorough knowledge of basic accounting procedures\n" +
//                "    In-depth understanding of Generally Accepted Accounting Principles (GAAP)\n" +
//                "    Awareness of business trends\n" +
//                "    Familiarity with financial accounting statements\n" +
//                "    Experience with general ledger functions and the month-end/year-end close process\n" +
//                "    Hands-on experience with accounting software packages, like FreshBooks and QuickBooks\n" +
//                "    Advanced MS Excel skills including Vlookups and pivot tables\n" +
//                "    Accuracy and attention to detail\n" +
//                "    Aptitude for numbers and quantitative skills\n" +
//                "    BS degree in Accounting, Finance or relevant\n" +
//                "    Relevant certification (e.g. CMA or CPA) will be preferred\n" +
//                "    ";
//        jobs.add(deloitte);
//
//        Job gs=new Job();
//        gs.image=R.drawable.goldmansachslogocopy;
//        gs.company="Goldman Sachs";
//        gs.location="Hyderabad";
//        gs.role="Summer Analyst Intern";
//        gs.description="CSE,IT,CCE";
//        jobs.add(gs);
//        jobs.add(deloitte);
//        jobs.add(gs);
//        jobs.add(deloitte);
        jobs.add(j);
        final JobsAdapter jobsAdapter=new JobsAdapter(jobs,this);
        jobsRecyclerView.setAdapter(jobsAdapter);
        jobbRecyclerView.setAdapter(jobsAdapter);
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