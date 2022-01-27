package com.dataAnalysisClustering.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dataAnalysisClustering.project.entities.Job;
import com.dataAnalysisClustering.project.repository.JobRepository;

@Service
public class JobService implements IJobService {

	@Autowired
	JobRepository jobRepository;
	
	@Override
	public List<Job> findAll() {
		// TODO Auto-generated method stub
		return (List<Job>) jobRepository.findAll();
	}

	@Override
	public void save(Job job) {
		// TODO Auto-generated method stub
		jobRepository.save(job);
		
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		 jobRepository.deleteById(id);
		
	}

	@Override
	public Job update(String id, Job job) {
		// TODO Auto-generated method stub
		job.setId(id);
		return jobRepository.save(job);
	}




}
