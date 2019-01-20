package com.xc.easyui.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
  *@className MainControler
  *@author xc
  *@date 2019/1/19 21:04
  *@description TODO
  *@version 1.0
  **/
@Controller
public class MainControler {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/mainTab")
    public String getIndexTab(){
        return "mainPanel";
    }

    @RequestMapping("/logout")
    public String logOut(){
        return "logout";
    }
}
