package blog.api.service.impl;

import blog.api.mapper.ArticleLabelMapper;
import blog.api.mapper.ArticlePOMapper;
import blog.api.po.ArticleLabelPO;
import blog.api.po.ArticlePO;
import blog.api.po.ArticlePOExample;
import blog.api.service.ArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticlePOMapper articlePOMapper;

    @Resource
    private ArticleLabelMapper articleLabelMapper;

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

    @Override
    public ArticlePO publish(long userId, String title, String content, long sortId, List<Long> labelIds) {
        try {
            ArticlePO articlePO = new ArticlePO();
            articlePO.setId(1L);
            articlePO.setUser_id(userId);
            articlePO.setTitle(title);
            articlePO.setContent(content);
            articlePO.setSort_id(sortId);
            articlePO.setView_count(0L);
            articlePO.setThumb_count(0L);
            articlePO.setComment_count(0L);
            articlePO.setCreate_time(new Date());
            articlePO.setStatus(1);
            articlePOMapper.insertSelective(articlePO);

            for (Long labelId : labelIds) {
                ArticleLabelPO articleLabelPO = new ArticleLabelPO();
                articleLabelPO.setArticle_id(articlePO.getId());
                articleLabelPO.setLabel_id(labelId);
                articleLabelMapper.insert(articleLabelPO);
            }

            ArticlePO queried = articlePOMapper.selectByPrimaryKey(articlePO.getId());
            return queried;
        } catch (Exception e) {
            return null;
        }

    }
}
