package com.tushar.JobApp.service;

import com.tushar.JobApp.model.JobPost;
import com.tushar.JobApp.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JobService {
    @Autowired
    private JobRepo repo;

    public void addJob(JobPost jobPost)
    {
repo.putjob(jobPost);
    }
    public List<JobPost> getall() {
        return  repo.addjob();

    }
}
