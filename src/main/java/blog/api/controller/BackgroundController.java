package blog.api.controller;

import blog.api.common.Result;
import blog.api.enums.HttpStatus;
import blog.api.service.BackgroundService;
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
    public Result<Object> login(@RequestParam(required = true) String username,
                                @RequestParam(required = true) long password) {
        boolean isValidUser = backgroundService.isValidUser(username, password);

        return isValidUser ? Result.success(HttpStatus.SUCCESS) : Result.error(HttpStatus.FAIL);
    }
}
