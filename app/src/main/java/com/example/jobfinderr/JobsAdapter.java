package com.example.jobfinderr;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.List;

public class JobsAdapter extends RecyclerView.Adapter<JobsAdapter.JobViewHolder>{

    private List<Job> jobs;
    private JobsListener jobsListener;

    public JobsAdapter(List<Job> jobs, JobsListener jobsListener) {
        this.jobs = jobs;
        this.jobsListener = jobsListener;
    }

    @NonNull
    @Override
    public JobViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new JobViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_container_jobs,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull JobViewHolder holder, int position) {
        holder.bindJob(jobs.get(position));
    }

    @Override
    public int getItemCount() {
        return jobs.size();
    }

    public List<Job> getSelectedJobs(){
        List<Job> selectedJobs=new ArrayList<>();
        for(Job job:jobs)
        {
            if(job.isSelected)
                selectedJobs.add(job);
        }
        return selectedJobs;
    }

    class JobViewHolder extends RecyclerView.ViewHolder{
        ConstraintLayout layoutJob;
        View viewBackground;
        RoundedImageView imageJob;
        TextView textName,textRole,textDescription,textLocation;
        ImageView imageSelected;


        JobViewHolder(@NonNull View itemView) {
            super(itemView);
            layoutJob=itemView.findViewById(R.id.layoutJobs);
            //viewBackground=itemView.findViewById(R.id.viewBackground);
            imageJob=itemView.findViewById(R.id.imageJobs);
            textName=itemView.findViewById(R.id.textName);
            textRole=itemView.findViewById(R.id.textRole);
            textDescription=itemView.findViewById(R.id.textDescription);
            textLocation=itemView.findViewById(R.id.textLocation);
            //imageSelected=itemView.findViewById(R.id.imageSelected);
        }

        void bindJob(final Job job)
        {
            imageJob.setImageResource(job.image);
            textName.setText(job.company);
            textRole.setText(job.role);
            textDescription.setText(job.description);
            textLocation.setText(job.location);
            if(job.isSelected){
                //viewBackground.setBackgroundResource(R.drawable.job_selected_background);
                //imageSelected.setVisibility(View.VISIBLE);
            }
            else{
                //viewBackground.setBackgroundResource(R.drawable.jobs_background);
                //imageSelected.setVisibility(View.GONE);
            }
            layoutJob.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    jobsListener.onJobAction(true, job);
                }
            });
        }
    }
}