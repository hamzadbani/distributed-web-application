package com.dataAnalysisClustering.project.services;


import java.util.List;

import com.dataAnalysisClustering.project.entities.Admin;

public interface IAdminService {
      public void addAdmin(Admin admin);
	  List<Admin> findAll();
}
