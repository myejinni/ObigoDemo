//package com.obigo.demo.controller;
//
//import java.util.List;
//
//import com.obigo.demo.dto.CompanyDto;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.obigo.demo.service.CompanyService;
//import com.obigo.superclass.BaseController;
//
//@RestController
//public class CompanyController extends BaseController {
//    @Autowired
//    CompanyService companyService;
//
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public ModelAndView index(Model m) throws Exception {
//        log.debug("log.isTraceEnabled() = {}", log.isTraceEnabled());
//
//        log.trace("TRACE print...");
//        log.debug("DEBUG print...");
//        log.info("INFO print...");
//        log.warn("WARN print...");
//        log.error("ERROR print...");
//
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("appTitle", "OBIGO DEMO");
//
//        mv.setViewName("/index3");
//
//        return mv;
//    }
//
////    @GetMapping(value = "/company")
////    public ResponseEntity<List<CompanyDto>> selectCompanyList() {
////        List<CompanyDto> companies = companyService.selectCompanyList();
////
////        log.debug("companies: {}", companies);
////        return ResponseEntity.ok()
////                .body(companies);
////    }
//
//    @GetMapping(value = "/company/{companySeq}")
//    public ResponseEntity<CompanyDto> selectCompany(@PathVariable("companySeq") long companySeq){
//
//        log.info("companySeq={}", companySeq);
//
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//
//
////    @GetMapping (value = "/company?companySeq")
////    public ResponseEntity<CompanyDto> getCompany(@RequestParam long companySeq){
////
////        log.info("companySeq={}", companySeq);
////
////        return new ResponseEntity<>(HttpStatus.OK);
////    }
//
//    @GetMapping("/company/getCompany")
//    public ResponseEntity<CompanyDto> getCompany(@RequestParam("companySeq") Long companySeq) {
//        if (companySeq != null) {
//            log.info("companySeq={}", companySeq);
//            return new ResponseEntity<>(HttpStatus.OK);
//
//        } else {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
//}
