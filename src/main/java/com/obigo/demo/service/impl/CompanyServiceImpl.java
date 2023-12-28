//package com.obigo.demo.service.impl;
//
//import java.util.List;
//
//import javax.annotation.Resource;
//
//import com.obigo.demo.dto.CompanyDto;
//import org.springframework.stereotype.Service;
//
//import com.obigo.demo.mapper.CompanyMapper;
//import com.obigo.demo.service.CompanyService;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//public class CompanyServiceImpl implements CompanyService {
//
//    @Resource
//    CompanyMapper companyMapper;
//
//    @Override
//    public List<CompanyDto> selectCompanyList() {
//
//        return companyMapper.selectCompanyList();
//    }
//
//    @Transactional //Rollback
//    @Override
//    public void insertCompany(CompanyDto companyDto) {
//
//        companyMapper.insertCompany(companyDto);
//    }
//    @Override
//    public void deleteCompany(Long companySeq) {
//        companyMapper.deleteCompany(companySeq);
//    }
//    @Override
//    public void updateCompany(CompanyDto companyDto){
//
//        companyMapper.updateCompany(companyDto);
//    }
////    @Override
////    public int idChk(CompanyDto companyDto) {
////        int result = companyMapper.idChk(companyDto);
////        return result;
////    }
//    @Override
//    public CompanyDto selectDto(CompanyDto companyDto) {
//
//        return companyMapper.selectDto(companyDto);
//
//    }
//
//    @Override
//    public CompanyDto searchCompany(CompanyDto companyDto) {
//
////        model.addAttribute("searchCompanyList", companyMapper.searchCompany(nameKey, addressKey, emailKey));
//
//        return (CompanyDto) companyMapper.searchCompany(companyDto);
//    }
//
//    @Override
//    public int deleteChk() {
//        int exist = companyMapper.deleteChk();
//        return exist;
//    }
//
//}