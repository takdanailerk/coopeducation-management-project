package itsci.mju.coopeducation_management_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import itsci.mju.coopeducation_management_project.model.User;
import itsci.mju.coopeducation_management_project.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepostory;
	
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepostory.findAll();
	}
	
}
