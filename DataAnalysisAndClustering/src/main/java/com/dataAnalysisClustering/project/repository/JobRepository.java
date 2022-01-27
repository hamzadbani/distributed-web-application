package com.dataAnalysisClustering.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.dataAnalysisClustering.project.entities.Job;

public interface JobRepository extends MongoRepository<Job, String>{
	

	
}
