package com.obigo.demo.controller;

import com.obigo.demo.service.UserService;
import com.obigo.demo.vo.PageMakeVO;
import com.obigo.demo.vo.PageVO;
import com.obigo.demo.vo.UserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(Model m) throws Exception {

        ModelAndView mv = new ModelAndView();
        mv.addObject("appTitle", "OBIGO DEMO");

        mv.setViewName("/user");

        return mv;
    }

    @PostMapping("/user")
    public ResponseEntity<List<UserVO>> user(HttpServletRequest req, HttpServletResponse res) {

        List<UserVO> list = userService.selectUserList();
        log.info("list: {}", list);

        return ResponseEntity.ok(list);
    }

    // 폼 입력 유저 INSERT
    @PostMapping("/user/insert")
    public ResponseEntity<UserVO> userInsert(HttpServletRequest req, HttpServletResponse res, @RequestBody UserVO userVO){

        UserVO result = userService.insertUser(userVO);

        return ResponseEntity.ok(result);

    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<UserVO> userSelect(HttpServletRequest req, HttpServletResponse res, @PathVariable("userId") Integer userId){

        UserVO user = userService.selectUser(userId);
        log.info("userG: {}", user);

        return ResponseEntity.ok(user);
    }

    @PostMapping("user/update")
    public ResponseEntity<UserVO> userUpdate(HttpServletRequest req, HttpServletResponse res, @RequestBody UserVO userVo){
        userService.updateUser(userVo);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("user/{userId}")
    public ResponseEntity<UserVO> userDelete(HttpServletRequest req, HttpServletResponse res, @PathVariable("userId") Integer userId){
        userService.deleteUser(userId);
        return ResponseEntity.ok(null);

    }

    @PostMapping ("user/search")
    public ResponseEntity<List<UserVO>> userSearch(HttpServletRequest req, HttpServletResponse res, @RequestBody UserVO userVO){

        List<UserVO> user =  userService.searchUser(userVO);

        log.info("user: {}", user);
        return ResponseEntity.ok(user);

    }

    @GetMapping("/user/userPage")
    public ModelAndView userPaging(PageVO pageVO) {
        log.info("userPaging.....");

        PageMakeVO pageMake = new PageMakeVO();

        pageMake.setPageVO(pageVO);
        pageMake.setTotalCount(userService.countUser(pageVO));
//        pageMake.setTotalCount(1000);

        ModelAndView mv = new ModelAndView();
        // 데이터를 "users" 이름으로 추가
        mv.addObject("users", userService.userPaging(pageVO));
        mv.addObject("pageMake", pageMake);

        mv.setViewName("/user");

        return mv;
    }

}

