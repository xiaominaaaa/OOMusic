package cn.OOMusic.controller;

import cn.OOMusic.pojo.Massage;
import cn.OOMusic.pojo.User;
import cn.OOMusic.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    UserServiceImpl service;

    @RequestMapping(value = "/user/add",method = RequestMethod.POST)
    @ResponseBody
    public Massage addUser(@RequestBody User user){
        System.out.println(user);
        return service.addUser(user);
    }

    @RequestMapping(value = "/user/find",method = RequestMethod.POST)
    @ResponseBody
    public User findUser(@RequestBody User user){
        return  service.findUser(user.getUserId());
    }

    @RequestMapping(value = "/user/passname",method = RequestMethod.POST)
    @ResponseBody
    public Massage update01(@RequestBody User user){
        return service.updataPassName(user);
    }

    @RequestMapping(value = "/user/emailphone",method = RequestMethod.POST)
    @ResponseBody
    public Massage update02(@RequestBody User user){
        return service.updataEmailPhone(user);
    }


    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    @ResponseBody
    public User login(@RequestBody User user){
        return service.login(user);
    }


}
