package blog.api.service.impl;

import blog.api.mapper.ArticlePOMapper;
import blog.api.po.ArticlePO;
import blog.api.po.ArticlePOExample;
import blog.api.service.ArticleService;
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
}
