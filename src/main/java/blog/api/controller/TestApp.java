package blog.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestApp {
    @ResponseBody
    @RequestMapping("test")
    public String test() {
        return "Hello, blog api";
    }
}
