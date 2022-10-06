package blog.api.service.impl;

import blog.api.enums.HttpStatus;
import blog.api.mapper.SortPOMapper;
import blog.api.mapper.UserPOMapper;
import blog.api.po.SortPO;
import blog.api.po.UserPO;
import blog.api.po.UserPOExample;
import blog.api.service.BackgroundService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class BackgroundServiceImpl implements BackgroundService {

    @Resource
    private UserPOMapper userPOMapper;

    @Resource
    private SortPOMapper sortPOMapper;

    @Override
    public boolean isValidUser(String username, long password) {
        UserPOExample example = new UserPOExample();
        UserPOExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        try {
            List<UserPO> userPOList = userPOMapper.selectByExample(example);

            if (userPOList.isEmpty()) {
                return false;
            }

            return userPOList.get(0).getPassword() == password;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public SortPO addSort(long userId, String name, String alias, String description, Long parentId) {
        try {
            SortPO sortPO = new SortPO();
            sortPO.setUser_id(userId);
            sortPO.setName(name);
            sortPO.setAlias(alias);
            sortPO.setDescription(description);
            sortPO.setParent_id(parentId);
            sortPOMapper.insertSelective(sortPO);
            return sortPO;
        } catch (Exception e) {
            return null;
        }
    }
}
