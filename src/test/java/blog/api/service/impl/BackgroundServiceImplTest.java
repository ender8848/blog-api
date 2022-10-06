package blog.api.service.impl;

import blog.api.BlogAppMain;
import blog.api.mapper.SortPOMapper;
import blog.api.po.SortPO;
import blog.api.service.BackgroundService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BlogAppMain.class)
public class BackgroundServiceImplTest {

    @Autowired
    SortPOMapper sortPOMapper;

    @Autowired
    BackgroundService backgroundService;

    @Test
    public void addSort() {
        SortPO sortPO = backgroundService.addSort(1L, "test", "test", "test", null);
        SortPO queried = sortPOMapper.selectByPrimaryKey(sortPO.getId());

        assertNotNull(queried);
        assertEquals(queried.getName(), "test");
    }
}