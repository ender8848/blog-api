package blog.api.mapper;

import blog.api.po.SortPO;
import blog.api.po.SortPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SortPOMapper {
    int countByExample(SortPOExample example);

    int deleteByExample(SortPOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SortPO record);

    int insertSelective(SortPO record);

    List<SortPO> selectByExample(SortPOExample example);

    SortPO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SortPO record, @Param("example") SortPOExample example);

    int updateByExample(@Param("record") SortPO record, @Param("example") SortPOExample example);

    int updateByPrimaryKeySelective(SortPO record);

    int updateByPrimaryKey(SortPO record);
}