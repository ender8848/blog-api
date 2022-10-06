package blog.api.service.impl;

import blog.api.mapper.ArticlePOMapper;
import blog.api.po.ArticlePO;
import blog.api.po.ArticlePOExample;
import blog.api.service.ArticleService;
import ch.qos.logback.core.encoder.EchoEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticlePOMapper articlePOMapper;
    @Override
    public ArticlePO selectAtricleById(long id) {

        ArticlePO articlePO = articlePOMapper.selectByPrimaryKey(id);

        return articlePO;
    }

    @Override
    public List<ArticlePO> selectAtricleByUserId(long id) {
        ArticlePOExample example = new ArticlePOExample();
        ArticlePOExample.Criteria criteria = example.createCriteria();
        criteria.andUser_idEqualTo(id);
        List<ArticlePO> articlePOList = articlePOMapper.selectByExampleWithBLOBs(example);

        return articlePOList;
    }

    @Override
    public boolean addArticleView(long userId, long articleId) {
        try {
            ArticlePO articlePO = articlePOMapper.selectByPrimaryKey(articleId);
            if (articlePO == null) return false;
            Long view_count = articlePO.getView_count();
            articlePO.setView_count(++view_count);
            articlePOMapper.updateByPrimaryKey(articlePO);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public List<ArticlePO> getHotArticle(long userId) {
        return articlePOMapper.getHotArticle(userId, 5);
    }
}
