package net.devstudy.resume.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractController {

    protected final Logger LOGGER = LoggerFactory.getLogger(getClass());

    //public static final String URL = "/";
    //public static final String JSP = "index";


    public String redirect(String url) {
        return "redirect:" + url;
    }
}
