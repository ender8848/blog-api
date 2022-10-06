package blog.api.service.impl;

import blog.api.BlogAppMain;
import blog.api.mapper.ArticlePOMapper;
import blog.api.service.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
}