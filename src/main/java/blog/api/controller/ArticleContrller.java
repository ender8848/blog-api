package blog.api.controller;

import blog.api.common.Result;
import blog.api.enums.HttpStatus;
import blog.api.po.ArticlePO;
import blog.api.service.ArticleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

//        return  Result.success(1,"成功",articlePO);
        return  Result.success(HttpStatus.SUCCESS,articlePO);
    }


    @GetMapping("/getArticleByUserId")
    public Result<List<ArticlePO>> getArticleByUserId(long id){

        List<ArticlePO> articlePOList = articleService.selectAtricleByUserId(id);

        return Result.success(HttpStatus.SUCCESS,articlePOList);
    }

    @PostMapping("/addviews")
    public Result addViews(long userId, long articleId){

        boolean serviceResult = articleService.addArticleView(userId, articleId);
        return serviceResult ?
                Result.success(HttpStatus.SUCCESS) : Result.error(HttpStatus.FAIL);
    }

    @GetMapping("/gethotarticle")
    public Result getHotArticle(long userId){

        List<ArticlePO> hotArticleList = articleService.getHotArticle(userId);
        return hotArticleList.isEmpty() ?
                Result.error(HttpStatus.FAIL):
                Result.success(HttpStatus.SUCCESS, hotArticleList);
    }
}