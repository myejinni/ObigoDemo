//package com.obigo.demo;
//
//import com.obigo.demo.service.UserService;
//import com.obigo.demo.vo.UserVO;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//@Slf4j
//@SpringBootTest
//public class insertTest {
//
//    @Autowired
//    private UserService userService;
//
//    @Test
//    public void testCreate() {
//
//        List<UserVO> users = new ArrayList<>();
//
//        for (int i = 1; i <= 150; i++) {
//            UserVO user = new UserVO();
//            user.setName("작성자" + i);
//            user.setAddr(i + "번 작성자 주소");
//            user.setAge(i);
//
//            users.add(user);
//        }
//        userService.insertDummy(users);
//    }
//
//}
//
