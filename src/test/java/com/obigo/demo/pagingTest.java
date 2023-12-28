package com.obigo.demo;

import com.obigo.demo.mapper.UserMapper;
import com.obigo.demo.vo.PageVO;
import com.obigo.demo.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class pagingTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testPaging() throws Exception {

        PageVO page = new PageVO();

        page.setPage(3);
        page.setPerPageNum(10);

        List<UserVO> pages = userMapper.userPaging(page);

        for (UserVO userVO : pages){

            log.info(userVO.getUserId() + ":" + userVO.getName());

        }
    }
}

