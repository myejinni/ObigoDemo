package com.obigo.demo.service.impl;

import com.obigo.demo.mapper.UserMapper;
import com.obigo.demo.service.UserService;
import com.obigo.demo.vo.PageVO;
import com.obigo.demo.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;


    @Override
    public List<UserVO> selectUserList() {

        return userMapper.selectUserList();
    }

    @Override
    public UserVO insertUser(UserVO userVO) {
        userMapper.insertUser(userVO);
        return userVO;
    }

    @Override
    public UserVO selectUser(Integer userId) {
        return userMapper.selectUser(userId);
    }

    @Override
    public void updateUser(UserVO userVo) {
        userMapper.updateUser(userVo);
    }

    @Override
    public void deleteUser(Integer userId) {
       userMapper.deleteUser(userId);
    }

    @Override
    public List<UserVO> searchUser(UserVO userVO) {

        return (List<UserVO>) userMapper.searchUser(userVO);
    }

//    @Override
//    public void insertDummy(List<UserVO> users) {
//        for (UserVO user : users) {
//            userMapper.insertDummy(user);
//        }
//    }

    @Override
    public List<UserVO> userPaging(PageVO page) {

        return userMapper.userPaging(page);
    }

    @Override
    public int countUser(PageVO pageVO) {
        return userMapper.countUser(pageVO);
    }

}