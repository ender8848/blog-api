package blog.api.controller;

import blog.api.common.Result;
import blog.api.dto.SortDTO;
import blog.api.enums.HttpStatus;
import blog.api.po.SortPO;
import blog.api.service.BackgroundService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/addsort")
    public Result<Object> addSort(@RequestBody SortDTO sortDTO) {
        SortPO serviceResult = backgroundService.addSort(sortDTO.getUser_id(), sortDTO.getName(), sortDTO.getAlias(),
                sortDTO.getDescription(), sortDTO.getParent_id());

        return serviceResult == null ? Result.error(HttpStatus.FAIL):
                Result.success(HttpStatus.SUCCESS, serviceResult);
    }

    @PostMapping("/editsort")
    public Result<Object> editSort(@RequestBody SortDTO sortDTO) {
        SortPO serviceResult = backgroundService.editSort(sortDTO.getSort_id(), sortDTO.getName(), sortDTO.getAlias(),
                sortDTO.getDescription(), sortDTO.getParent_id());

        return serviceResult == null ? Result.error(HttpStatus.FAIL):
                Result.success(HttpStatus.SUCCESS, serviceResult);
    }
}
