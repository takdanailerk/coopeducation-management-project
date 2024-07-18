package itsci.mju.coopeducation_management_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import itsci.mju.coopeducation_management_project.model.User;

public interface UserRepository extends JpaRepository<User, String> {

}
