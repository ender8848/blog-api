package blog.api.service;

import blog.api.po.ArticlePO;

import java.util.List;

public interface ArticleService {
//根据文章id获取对应文章
    ArticlePO selectAtricleById(long id);
//    根据用户id获取文章，一对多
    List<ArticlePO> selectAtricleByUserId(long id);

    /* 文章增添浏览量 */
    boolean addArticleView(long userId, long articleId);

    List<ArticlePO> getHotArticle(long userId);

    ArticlePO submit(long userId, String title, String content, long sortId, List<Long> labelIds);

    ArticlePO deleteArticle(long userId, long articleId);
}
