package com.obigo.demo.service;

import com.obigo.demo.vo.PageVO;
import com.obigo.demo.vo.UserVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<UserVO> selectUserList();
    UserVO insertUser(UserVO userVO);
    UserVO selectUser(Integer userId);
    void updateUser(UserVO userVo);
    void deleteUser(Integer userId);

    List<UserVO> searchUser(UserVO userVO);

//    void insertDummy(List<UserVO> users);

    List<UserVO> userPaging(PageVO page);

    int countUser(PageVO pageVO);

}
