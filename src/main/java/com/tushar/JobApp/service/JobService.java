package com.tushar.JobApp.service;

import com.tushar.JobApp.model.JobPost;
import com.tushar.JobApp.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class JobService {
    @Autowired
    private JobRepo repo;

    public void addJob(JobPost jobPost)
    {

    repo.save(jobPost);
    }
    public List<JobPost> getall() {
        return  repo.findAll();

    }

    public JobPost getJob(int postId) {

        return repo.findById(postId).orElse(new JobPost());
    }


    public void updateJob(JobPost jobPost) {
        repo.save(jobPost);

    }

    public void deleteJob(int postId) {
        repo.deleteById(postId);

    }

}
