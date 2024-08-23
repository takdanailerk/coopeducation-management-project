package itsci.mju.coopeducation_management_project.service;

import java.util.List;

import itsci.mju.coopeducation_management_project.model.Company;

public interface CompanyService {

	List<Company> getAllCompanies();
	Company getCompanyById(Long companyId);
	Company addCompany(Company company);
	Company updateCompany(Company updateComapny);
	void deleteCompany(Long companyId);
	Company findById(Long companyId);
	List<Company> findByCompanyName(String companyName);
	Company getCompanyByName(String companyName);
	
}
