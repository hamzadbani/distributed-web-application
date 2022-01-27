package com.dataAnalysisClustering.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dataAnalysisClustering.project.entities.Admin;
import com.dataAnalysisClustering.project.repository.AdminRepository;

@Service
public class AdminService implements IAdminService {

	@Autowired
	private AdminRepository adminrepository ;
	
	@Override
	public void addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		adminrepository.save(admin);
	}

	
	@Override
	public List<Admin> findAll() {
		// TODO Auto-generated method stub
		return (List<Admin>) adminrepository.findAll();
	}


}
