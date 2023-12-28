//package com.obigo.demo.controller;
//
//
//import com.obigo.demo.dto.User.UserVo;
//import com.obigo.demo.vo.UserVO;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
////Controller+ ResponseBody
//@RestController
//@Slf4j
//public class ObigoController {
//
//    //  @RequstParam
//    @GetMapping("/obigo")
//    public ResponseEntity<String> obigo(HttpServletRequest req, HttpServletResponse res, @RequestParam(name = "obigo") String obigo, @RequestParam(name = "obigo2") String obigo2){
//
//        log.info("req: {}", obigo);
//        log.info("req: {}", obigo2);
//
//        return ResponseEntity.ok(obigo);
//    }
//
//    //  @PathVariable test
//    @GetMapping("/obigo2/{obigo}")
//    public ResponseEntity<String> obigo2(HttpServletRequest req, HttpServletResponse res, @PathVariable(name = "obigo") String obigo){
//
//        String result = null;
//        result = obigo;
//
//        return ResponseEntity.ok(obigo);
//    }
//
//    // Request test
//    @PostMapping("/obigo3")
//    public ResponseEntity<String> obigo3(HttpServletRequest req, HttpServletResponse res){
//
//        String obigo = req.getParameter("obigo");
//        String obigo2 = req.getParameter("obigo2");
//
//        log.info("req: {}",  obigo);
//        log.info("req:{}", obigo2);
//
//        return ResponseEntity.ok(obigo+','+obigo2);
//    }
//
//    //RequestBody test
//    //input 2개 추가-class vo 받아와서 같이 출력
//    @PostMapping("/user")
//    public ResponseEntity<UserVO> obigo4(HttpServletRequest req, HttpServletResponse res, @RequestBody UserVO userVo){
//
//        return ResponseEntity.ok(userVo);
//    }
//
//}
