package itsci.mju.coopeducation_management_project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//import itsci.mju.coopeducation_management_project.model.Major;
import itsci.mju.coopeducation_management_project.model.Staff;

public interface StaffRepository extends JpaRepository<Staff, Long>{
	
	@Query(value = "SELECT s.staffId FROM staffs s ORDER BY s.staffId DESC LIMIT 1", nativeQuery = true)
    Long getMaxStaffId(); 
	
	public Staff findByUsername(String username);
	
//	Optional<Staff> findByUsername(String username);
	
//	List<Staff> findByMajorId();
}
