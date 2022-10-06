package blog.api.service;

import blog.api.po.ArticlePO;

import java.util.List;

public interface ArticleService {
//根据文章id获取对应文章
    ArticlePO selectAtricleById(long id);
//    根据用户id获取文章，一对多
    List<ArticlePO> selectAtricleByUserId(long id);
}
