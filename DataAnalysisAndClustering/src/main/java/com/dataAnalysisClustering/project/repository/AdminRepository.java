package com.dataAnalysisClustering.project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dataAnalysisClustering.project.entities.Admin;

@Repository
public interface AdminRepository extends MongoRepository<Admin, String> {

	Admin findBy(String email, String password);


}
