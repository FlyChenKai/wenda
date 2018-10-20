package com.ck.wenda.controller;

import com.ck.wenda.model.User;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller

public class IndexController {
    @RequestMapping("/help")
    @ResponseBody
    public String index(){
        return "<h1>Hello Spring<h1>";
    }


    @RequestMapping("/profile/{userId}")
    @ResponseBody
    public String profile(@PathVariable("userId") String userId, @RequestParam(value = "key",defaultValue = "0",required = false)int key){
        return "Id:"+userId+" Key:"+key;
    }

    @RequestMapping("/free")
    public String template(Model model){

        model.addAttribute("value1","first");//向前端传变量

        List<String> list= Arrays.asList(new String[]{"RED","BLUE","WHITE"});
        model.addAttribute("list",list);

        Map<String,String> map=new HashMap<>();
        for(int i=0;i<7;i++){
            map.put(String.valueOf(i),String.valueOf(i*i));
        }

        model.addAttribute("map",map);

        model.addAttribute("user",new User("chen"));

        return "home";
    }

    @RequestMapping("/request")
    @ResponseBody
    public String request(HttpServletRequest request){
        StringBuilder stringBuilder=new StringBuilder();
        Enumeration<String> headerNames=request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            stringBuilder.append(request.getHeaders());
        }
    }

}
