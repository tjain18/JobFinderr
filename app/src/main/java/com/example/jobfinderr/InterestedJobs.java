package com.example.jobfinderr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class InterestedJobs extends AppCompatActivity implements JobsListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interested_jobs);

        RecyclerView jobsRecyclerView=findViewById(R.id.jobsRecyclerView);

        List<Job> jobs=new ArrayList<>();
        Job deloitte=new Job();
        deloitte.image=R.drawable.google_logo;
        deloitte.company="Google";
        deloitte.location="Bangalore";
        deloitte.role="Software Developer";
        deloitte.description="Job brief Job brief\n" +
                "    We are looking for an experienced Senior Accountant to oversee general accounting operations by controlling and verifying our financial transactions.\n" +
                "\n" +
                "    Senior Accountant responsibilities include reconciling account balances and bank statements, maintaining general ledger and preparing month-end close procedures. A successful Senior Accountant combines excellent analytical skills with a thorough knowledge of accounting principles to analyze financial reports and forecasts. The ideal candidate has also experience collaborating and/or managing a team of Accountants and Junior Accountants.\n" +
                "\n" +
                "    Senior Accountant duties also include ensuring accuracy and effectiveness in all of our accounting tasks.\n" +
                "\n" +
                "    Responsibilities\n" +
                "    Verify, allocate, post and reconcile accounts payable and receivable\n" +
                "    Produce error-free accounting reports and present their results\n" +
                "    Analyze financial information and summarize financial status\n" +
                "    Spot errors and suggest ways to improve efficiency and spending\n" +
                "    Provide technical support and advice on Management Accountant\n" +
                "    Review and recommend modifications to accounting systems and procedures\n" +
                "    Manage accounting assistants and bookkeepers\n" +
                "    Participate in financial standards setting and in forecast process\n" +
                "    Provide input into department’s goal setting process\n" +
                "    Prepare financial statements and produce budget according to schedule\n" +
                "    Assist with tax audits and tax returns\n" +
                "    Direct internal and external audits to ensure compliance\n" +
                "    Plan, assign and review staff’s work\n" +
                "    Support month-end and year-end close process\n" +
                "    Develop and document business processes and accounting policies to maintain and strengthen internal controls\n" +
                "    Ensure compliance with GAAP principles\n" +
                "    Liaise with our Financial Manager and Accounting Manager to improve financial procedures\n" +
                "    Requirements and skills\n" +
                "    Proven experience as a Financial Controller, Accounting Supervisor, chief or senior accountant\n" +
                "    Thorough knowledge of basic accounting procedures\n" +
                "    In-depth understanding of Generally Accepted Accounting Principles (GAAP)\n" +
                "    Awareness of business trends\n" +
                "    Familiarity with financial accounting statements\n" +
                "    Experience with general ledger functions and the month-end/year-end close process\n" +
                "    Hands-on experience with accounting software packages, like FreshBooks and QuickBooks\n" +
                "    Advanced MS Excel skills including Vlookups and pivot tables\n" +
                "    Accuracy and attention to detail\n" +
                "    Aptitude for numbers and quantitative skills\n" +
                "    BS degree in Accounting, Finance or relevant\n" +
                "    Relevant certification (e.g. CMA or CPA) will be preferred\n" +
                "    ";
        jobs.add(deloitte);

        Job gs=new Job();
        gs.image=R.drawable.goldmansachslogocopy;
        gs.company="Goldman Sachs";
        gs.location="Hyderabad";
        gs.role="Summer Analyst Intern";
        gs.description="CSE,IT,CCE";
        jobs.add(gs);
        jobs.add(deloitte);
        jobs.add(gs);
        jobs.add(deloitte);
        jobs.add(gs);
        jobs.add(deloitte);
        jobs.add(gs);
        jobs.add(deloitte);
        jobs.add(gs);
        jobs.add(deloitte);
        jobs.add(gs);
        jobs.add(deloitte);
        jobs.add(gs);
        jobs.add(deloitte);
        jobs.add(gs);
        jobs.add(deloitte);
        jobs.add(gs);
        jobs.add(deloitte);
        jobs.add(gs);
        jobs.add(deloitte);
        jobs.add(gs);
        jobs.add(deloitte);
        jobs.add(gs);




        final JobsAdapter jobsAdapter=new JobsAdapter(jobs,this);
        jobsRecyclerView.setAdapter(jobsAdapter);

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