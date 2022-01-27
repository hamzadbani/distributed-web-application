package com.dataAnalysisClustering.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dataAnalysisClustering.project.DataAnalysisAndClusteringApplication;
import com.dataAnalysisClustering.project.entities.Admin;
import com.dataAnalysisClustering.project.services.IAdminService;

@RestController
@RequestMapping("/jeeProject")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class AdminController implements CommandLineRunner {
	
        @Autowired
		private IAdminService iAdminService;

		public static void main(String[] args) {
			SpringApplication.run(DataAnalysisAndClusteringApplication.class, args);
		}

		@Override
		public void run(String... args) throws Exception {
			
		}
		
		
		@ResponseStatus(HttpStatus.CREATED)
		@PostMapping("/login")
		@CrossOrigin(origins = "http://localhost:4200")
		public Admin loginadmin(@RequestBody Admin admin) throws Exception {
			String tmpEmail = admin.getEmail();
			String tmpPassword = admin.getPassword();
			Admin adminObj = null;
			List<Admin> admins=iAdminService.findAll();
			for (Admin adminAcc : admins) {
				if(tmpPassword.equals(adminAcc.getPassword()) && tmpEmail.equals(adminAcc.getEmail()) ) {
				 adminObj = adminAcc;
				}
			}
			if(adminObj == null) {
				throw new Exception("Utilisateur inexiste");
			}
			return adminObj;
		}
		

	}


