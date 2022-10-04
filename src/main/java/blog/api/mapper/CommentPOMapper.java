package blog.api.mapper;

import blog.api.po.CommentPO;
import blog.api.po.CommentPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommentPOMapper {
    int countByExample(CommentPOExample example);

    int deleteByExample(CommentPOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommentPO record);

    int insertSelective(CommentPO record);

    List<CommentPO> selectByExampleWithBLOBs(CommentPOExample example);

    List<CommentPO> selectByExample(CommentPOExample example);

    CommentPO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommentPO record, @Param("example") CommentPOExample example);

    int updateByExampleWithBLOBs(@Param("record") CommentPO record, @Param("example") CommentPOExample example);

    int updateByExample(@Param("record") CommentPO record, @Param("example") CommentPOExample example);

    int updateByPrimaryKeySelective(CommentPO record);

    int updateByPrimaryKeyWithBLOBs(CommentPO record);

    int updateByPrimaryKey(CommentPO record);
}