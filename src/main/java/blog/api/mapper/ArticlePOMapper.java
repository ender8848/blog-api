package blog.api.mapper;

import blog.api.po.ArticlePO;
import blog.api.po.ArticlePOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ArticlePOMapper {
    int countByExample(ArticlePOExample example);

    int deleteByExample(ArticlePOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ArticlePO record);

    int insertSelective(ArticlePO record);

    List<ArticlePO> selectByExampleWithBLOBs(ArticlePOExample example);

    List<ArticlePO> selectByExample(ArticlePOExample example);

    ArticlePO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ArticlePO record, @Param("example") ArticlePOExample example);

    int updateByExampleWithBLOBs(@Param("record") ArticlePO record, @Param("example") ArticlePOExample example);

    int updateByExample(@Param("record") ArticlePO record, @Param("example") ArticlePOExample example);

    int updateByPrimaryKeySelective(ArticlePO record);

    int updateByPrimaryKeyWithBLOBs(ArticlePO record);

    int updateByPrimaryKey(ArticlePO record);

    @Select("select * from article where user_id = #{userId} order by view_count desc, create_time desc limit #{num};")
    List<ArticlePO> getHotArticle(@Param("userId") long uerId, @Param("num") long num);
}