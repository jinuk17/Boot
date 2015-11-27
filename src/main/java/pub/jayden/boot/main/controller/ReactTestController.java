package pub.jayden.boot.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jaydenuk on 2015. 11. 25..
 */
@Controller
@RequestMapping("/react")
public class ReactTestController {

    @RequestMapping("/hello")
    public String helloReact(){
        return "hello-react";
    }

    @RequestMapping("test")
    @ResponseBody
    public String test() {
        return "Hello!! React!!";
    }
}
