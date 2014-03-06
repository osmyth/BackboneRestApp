package com.backbonerestapp.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
*/
@Controller
@RequestMapping("/")
public class APIController {

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @ResponseBody
    public String getAttributeSettings() {
        return "hello";
    }
}
