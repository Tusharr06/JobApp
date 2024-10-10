package com.tushar.JobApp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JobControler
{
    @RequestMapping({"/","home"})
    public String homee(){ return "home";}
}
