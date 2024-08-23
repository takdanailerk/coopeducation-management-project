package itsci.mju.coopeducation_management_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import itsci.mju.coopeducation_management_project.model.Company;
import itsci.mju.coopeducation_management_project.repository.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	private CompanyRepository companyRepository;
	
	@Override
	public List<Company> getAllCompanies() {
		// TODO Auto-generated method stub
		return companyRepository.findAll();
	}

	@Override
	public Company getCompanyById(Long companyId) {
		// TODO Auto-generated method stub
		return companyRepository.getReferenceById(companyId);
	}

	@Override
	public Company addCompany(Company company) {
		// TODO Auto-generated method stub
		return companyRepository.save(company);
	}

	@Override
	public Company updateCompany(Company updateComapny) {
		// TODO Auto-generated method stub
		return companyRepository.save(updateComapny);
	}

	@Override
	public void deleteCompany(Long companyId) {
		// TODO Auto-generated method stub
		Company company = companyRepository.getReferenceById(companyId);
		companyRepository.delete(company);
	}
	
//	public List<Company> searchByName(String companyName) {
//        return companyRepository.findByCompanyNameContaining(companyName); // ใช้ method ที่เหมาะสมในการค้นหา
//    }
	
//	public List<Company> searchCompaniesByKeyword(String keyword) {
//        return companyRepository.findByCompanyNameContaining(keyword);
//    }

    public Company findById(Long companyId) {
        return companyRepository.findById(companyId).orElse(null);
    }

	@Override
	public List<Company> findByCompanyName(String companyName) {
		// TODO Auto-generated method stub
		return companyRepository.findByCompanyName(companyName);
	}

	@Override
	public Company getCompanyByName(String companyName) {
		// TODO Auto-generated method stub
		return companyRepository.findByName(companyName);
	}

//	@Override
//	public List<Company> searchCompaniesByKeyword(String keyword) {
//		// TODO Auto-generated method stub
//		return null;
//	}
    
    

//	@Override
//	public List<Company> searchByName(String companyName) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	public List<Company> findByCompanyNameStartingWith(String companyName) {
//        return companyRepository.findByCompanyNameStartingWith(companyName);
//    }
    
}
