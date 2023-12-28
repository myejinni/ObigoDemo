package com.obigo.demo.mapper;

import java.util.List;

import com.obigo.demo.dto.CompanyDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.obigo.demo.dao.PostgresAbstractDAO;

@Mapper
@Repository
public class CompanyMapper extends PostgresAbstractDAO {
	public List<CompanyDto> selectCompanyList() {
		return (List<CompanyDto>) selectList("com.obigo.demo.mapper.CompanyMapper.selectCompanyList");
	}

	public void insertCompany(CompanyDto companyDto) {
		insert("com.obigo.demo.mapper.CompanyMapper.insertCompany", companyDto);
	}

	public void deleteCompany(Long companySeq) {
		delete("com.obigo.demo.mapper.CompanyMapper.deleteCompany" , companySeq);
	}

	public void updateCompany(CompanyDto companyDto){
		update("com.obigo.demo.mapper.CompanyMapper.updateCompany", companyDto);

	}
//	public int idChk(CompanyDto companyDto){
//		int result = selectOne("com.obigo.demo.mapper.CompanyMapper.idChk", companyDto);
//		return result;
//	}

	public CompanyDto selectDto(CompanyDto companyDto) {

		return (CompanyDto) selectOne("com.obigo.demo.mapper.CompanyMapper.selectDto", companyDto);

	}

//	public List<CompanyDto> searchCompany(@Param("nameKey") String nameKey, @Param("addressKey") String addressKey, @Param("emailKey") String emailKey){
//
//		return (List<CompanyDto>) selectList("com.obigo.demo.mapper.CompanyMapper.searchCompany", nameKey, addressKey, emailKey );
//
//	}

	public List<CompanyDto> searchCompany(CompanyDto companyDto){

//		return (List<CompanyDto>) selectList("com.obigo.demo.mapper.CompanyMapper.searchCompany", companyDto );
		return null;

	}

//	public int deleteChk() {
//		int exist = selectOne3("com.obigo.demo.mapper.CompanyMapper.deleteChk");
//		return exist;
//	}
}