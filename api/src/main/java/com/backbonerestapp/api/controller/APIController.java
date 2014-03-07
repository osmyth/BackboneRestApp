package com.backbonerestapp.api.controller;

import com.backbonerestapp.api.dao.GenericDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
*/
@Controller
@RequestMapping("/")
public class APIController {

    @Autowired
    private GenericDao genericDao;

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    @ResponseBody
    public String getCustomer() {
        return genericDao.getCustomer(0);
    }
}
