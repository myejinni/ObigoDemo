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
//public class IndexController extends BaseController {
//	@Autowired
//	CompanyService companyService;
//
////	@RequestMapping(value = "/", method = RequestMethod.GET)
////	public ModelAndView index(Model m) throws Exception {
////		log.debug( "log.isTraceEnabled() = {}", log.isTraceEnabled() );
////
////		log.trace("TRACE print...");
////		log.debug("DEBUG print...");
////		log.info("INFO print...");
////		log.warn("WARN print...");
////		log.error("ERROR print...");
////
////        ModelAndView mv = new ModelAndView();
////        mv.addObject("appTitle", "OBIGO DEMO");
////
////        mv.setViewName("/index3");
////
////        return mv;
////    }
//
//    @GetMapping(value = "/company")
//    public ResponseEntity<List<CompanyDto>> selectCompanyList() {
//        List<CompanyDto> companies = companyService.selectCompanyList();
//
//        log.debug("companies: {}", companies);
//        return ResponseEntity.ok()
//                .body(companies);
//    }
//
//    @PutMapping(value = "/company")
//    public ResponseEntity insertCompany(@RequestBody CompanyDto companyDto){
//
//
//        int result = companyService.idChk(companyDto);
//
//        try {
//            if (result == 0){
//                companyService.insertCompany(companyDto);
//            }
//        } catch (Exception e) {
//            throw new RuntimeException();
//        }
//
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//
//    @DeleteMapping(value = "/company/{companySeq}")
//    public ResponseEntity deleteCompany(@PathVariable("companySeq") long companySeq){
//
//    //  deletechk
//        int exist = companyService.deleteChk();
//
//        try {
//            if (exist == 1){
//                companyService.deleteCompany(companySeq);
//            }
//        } catch (Exception e) {
//            throw new RuntimeException();
//        }
//       return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//
//    @PatchMapping (value = "/company")
//    public ResponseEntity updateCompany(@RequestBody CompanyDto companyDto){
//
//        companyService.updateCompany(companyDto);
//
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
////    @PatchMapping  (value = "/company")
////    public ResponseEntity updateCompany(@RequestBody CompanyDto companyDto){
////
////     CompanyDto result = companyService.selectDto(companyDto);
////
////        try {
////            if (companyDto.getEmail() != null){
////                result.setEmail(companyDto.getEmail());
////            }
////            if (companyDto.getAddress() != null ){
////                result.setAddress(companyDto.getAddress());
////            }
////            if (companyDto.getDescription() != null ){
////                result.setDescription(companyDto.getDescription());
////            }
////        } catch (Exception e){
////            throw new RuntimeException();
////        }
////            companyService.updateCompany(result);
////            return new ResponseEntity<>(HttpStatus.OK);
////    }
//
//    @GetMapping (value = "/searchCompany")
//    public ResponseEntity searchCompany(@RequestParam CompanyDto companyDto) {
//
//        CompanyDto result = companyService.selectDto(companyDto);
//
//        try {
//            if (companyDto.getNameKey() != null || companyDto.getEmailKey() != null || companyDto.getAddressKey() != null ) {
//
//                companyService.searchCompany(companyDto);
//
//            } else {
//
//                companyService.selectCompanyList();
//
//                }
//
//        } catch (Exception e) {
//            throw new RuntimeException();
//        }
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
////  validity chk(중복,존재)
//    @ResponseBody
//    @RequestMapping(value = "/idChk", method = RequestMethod.POST)
//    public int idChk(CompanyDto companyDto){
//        int result = companyService.idChk(companyDto);
//        return result;
//    }
//
//    @ResponseBody
//    @RequestMapping(value = "/deleteChk", method = RequestMethod.GET)
//    public int deleteChk(CompanyDto companyDto){
//        int exist = companyService.deleteChk();
//        return exist;
//    }
//
////  DTO 불러오기
//    @PostMapping (value = "/getDto")
//    public ResponseEntity<CompanyDto> selectDto(@RequestBody CompanyDto companyDto){
//
//        CompanyDto result = companyService.selectDto(companyDto);
//        System.out.println(result.address);
//
//        return ResponseEntity.ok().body(result);
//
//    }
//
//}
