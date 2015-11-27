package pub.jayden.boot.main.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jaydenuk on 2015. 11. 15..
 */
@RestController("/")
public class MainController {

    @RequestMapping("")
    public String index() {
        return "Hello!! Spring Boot!!";
    }

}
