package blog.api.controller;

import blog.api.enums.HttpStatus;
import blog.api.service.BackgroundService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/* 后台API */
@RestController
@RequestMapping(value = "")
public class BackgroundController {
    @Resource
    BackgroundService backgroundService;

    @PostMapping("/login")
    public JSONObject login(@RequestParam(required = true) String username,
                            @RequestParam(required = true) long password) {
        HttpStatus serviceResult = backgroundService.checkUser(username, password);
        JSONObject meta = new JSONObject();
        meta.put("status", serviceResult.status());
        meta.put("msg", serviceResult.msg());
        JSONObject result = new JSONObject();
        result.put("data", meta);
        return result;
    }
}
