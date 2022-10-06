package blog.api.service.impl;

import blog.api.enums.HttpStatus;
import blog.api.mapper.UserPOMapper;
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
}
