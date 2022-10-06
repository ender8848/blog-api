package blog.api.service.impl;

import blog.api.BlogAppMain;
import blog.api.mapper.ArticlePOMapper;
import blog.api.po.ArticlePO;
import blog.api.service.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BlogAppMain.class)
public class ArticleServiceImplTest {

    @Autowired
    ArticleService articleService;

    @Autowired
    ArticlePOMapper articlePOMapper;

    @Test
    public void addArticleView() {
        long oldViewCount = articlePOMapper.selectByPrimaryKey(1L).getView_count();
        articleService.addArticleView(1L, 1L);
        long newViewCount = articlePOMapper.selectByPrimaryKey(1L).getView_count();
        assertEquals(newViewCount, oldViewCount + 1);
    }


    @Test
    public void getHotArticle() {
        List<ArticlePO> hotArticleList = articleService.getHotArticle(1L);
        assertEquals(hotArticleList.size(), 5);
        for (ArticlePO articlePO : hotArticleList) {
            assertTrue(articlePO.getView_count() > 1000);
        }
    }
}