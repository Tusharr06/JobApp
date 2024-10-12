package com.tushar.JobApp;

import org.springframework.ui.Model;
import com.tushar.JobApp.model.JobPost;
import com.tushar.JobApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class JobControler
{
    @Autowired
    private JobService service;
    @RequestMapping({"/","home"})
    public String homee(){
        return "home";

    }
@RequestMapping("addjob")
    public String job(){ return "addjob";}
    @PostMapping("handleForm")
    public String handleform(JobPost jobPost){

        service.addJob(jobPost);
        return "handleform";}
    @GetMapping("viewalljobs")

    public String viewall(Model m)
    {
        List<JobPost> jobs = service.getall();
   m.addAttribute("jobPosts",jobs);
        return "viewalljobs";
    }
    @GetMapping("/jobPost/{postId}")
    public JobPost getJob(@PathVariable int postId) {
        return service.getJob(postId);
    }

    @PostMapping("jobPost")
    public JobPost addJob(@RequestBody JobPost jobPost) {
        service.addJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }
@ResponseBody
    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost) {
        service.updateJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }
    @ResponseBody
    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable int postId)
    {
        service.deleteJob(postId);
        return "Deleted";
    }

@ResponseBody
    @GetMapping("/j")
    public List<JobPost> getAllJobs() {
        return service.getall();

    }


}
