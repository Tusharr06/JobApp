package com.tushar.JobApp;

import com.tushar.JobApp.model.JobPost;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JobControler
{
    @RequestMapping({"/","home"})
    public String homee(){ return "home";}
@RequestMapping("addjob")
    public String job(){ return "addjob";}
    @PostMapping("handleForm")
    public String handleform(JobPost jobPost){return "handleform";}
}
