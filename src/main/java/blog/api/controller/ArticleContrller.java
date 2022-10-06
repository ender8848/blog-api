package blog.api.controller;

import blog.api.common.Result;
import blog.api.po.ArticlePO;
import blog.api.service.ArticleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ArticleContrller {

    @Resource
    private ArticleService articleService;

    @GetMapping("/getArticleById")
    public Result<ArticlePO> getArticleById(long id){

        ArticlePO  articlePO = articleService.selectAtricleById(id);

        return  Result.success(1,"成功",articlePO);
    }

    @GetMapping("/getArticleByUserId")
    public Result<List<ArticlePO>> getArticleByUserId(long id){

        List<ArticlePO> articlePOList = articleService.selectAtricleByUserId(id);

        return Result.success(1,"成功",articlePOList);

    }
}