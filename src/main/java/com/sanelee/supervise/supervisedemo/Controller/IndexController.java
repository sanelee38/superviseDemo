package com.sanelee.supervise.supervisedemo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
@RequestMapping("/front/*")
public class IndexController {

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/home")
    public String index(HttpServletRequest request){
        return "home";
    }
    @GetMapping("/redirect/{target}")
    public String redirect(@PathVariable("target") String target){
        return target;
    }

    @RequestMapping("/addlogin")
    public String addlogin(HttpServletRequest request,
                           HttpServletResponse response,
                           Map<String,Object> map,
                           Model model){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username=="admin"&&password=="123456"){
            return "redirect:home";
        }else {
            return "index";
        }
    }
}
