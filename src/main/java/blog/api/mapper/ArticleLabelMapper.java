package blog.api.mapper;

import blog.api.po.ArticleLabelPO;
import blog.api.po.ArticlePO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ArticleLabelMapper {
    @Select("select * from article_label where article_id = #{articleId}")
    List<ArticleLabelPO> selectByArticleId(@Param("articleId") long articleId);

    int insert(ArticleLabelPO articleLabelPO);

    @Delete("delete from article_label where article_id = #{articleId}")
    void deleteByArticleId(@Param("articleId") long articleId);
}
