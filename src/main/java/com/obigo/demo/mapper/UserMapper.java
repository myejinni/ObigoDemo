package com.obigo.demo.mapper;

import com.obigo.demo.dao.PostgresAbstractDAO;
import com.obigo.demo.vo.PageVO;
import com.obigo.demo.vo.UserVO;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public class UserMapper extends PostgresAbstractDAO {
    public List<UserVO> selectUserList() {
        return (List<UserVO>) selectList("com.obigo.demo.mapper.UserMapper.selectUserList");

    }

    public UserVO selectUser(Integer userId){
        return (UserVO) selectOne("com.obigo.demo.mapper.UserMapper.selectUser", userId);
    }

    public void insertUser(UserVO userVO){
        insert("com.obigo.demo.mapper.UserMapper.insertUser", userVO);

    }

    public void updateUser(UserVO userVo) {
        update("com.obigo.demo.mapper.UserMapper.updateUser", userVo);

    }

    public void deleteUser(Integer userId) {
        delete("com.obigo.demo.mapper.UserMapper.deleteUser", userId);
    }

    public List<UserVO> searchUser(UserVO userVO) {
        return (List<UserVO>) selectList("com.obigo.demo.mapper.UserMapper.searchUser", userVO);

    }

    public void insertDummy(UserVO user) {
        insert("com.obigo.demo.mapper.UserMapper.insertDummy", user);
    }

    public List<UserVO> userPaging(PageVO page){
        return (List<UserVO>) selectList("com.obigo.demo.mapper.UserMapper.userPaging", page);
    }

    public int countUser(PageVO pageVO){
        return (int) selectOne("com.obigo.demo.mapper.UserMapper.countUser" , pageVO);
    }

}