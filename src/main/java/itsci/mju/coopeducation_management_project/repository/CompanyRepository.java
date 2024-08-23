package itsci.mju.coopeducation_management_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import itsci.mju.coopeducation_management_project.model.Company;



public interface CompanyRepository extends JpaRepository<Company,Long>{

	@Query(value = "SELECT c.companyId FROM companies c ORDER BY c.companyId DESC LIMIT 1", nativeQuery = true)
    Long getMaxCompanyId(); 
	
	@Query("SELECT c FROM Company c WHERE c.companyName = :companyName")
	Company findByName(@Param("companyName") String companyName);
	
	List<Company> findByCompanyName(String companyName);
	
	@Query("SELECT c FROM Company c WHERE c.companyName LIKE %:keyword%")
    List<Company> findByCompanyNameContaining(String keyword);

}
