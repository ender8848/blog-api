package blog.api.mapper;

import blog.api.po.LabelPO;
import blog.api.po.LabelPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LabelPOMapper {
    int countByExample(LabelPOExample example);

    int deleteByExample(LabelPOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LabelPO record);

    int insertSelective(LabelPO record);

    List<LabelPO> selectByExample(LabelPOExample example);

    LabelPO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LabelPO record, @Param("example") LabelPOExample example);

    int updateByExample(@Param("record") LabelPO record, @Param("example") LabelPOExample example);

    int updateByPrimaryKeySelective(LabelPO record);

    int updateByPrimaryKey(LabelPO record);
}