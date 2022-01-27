package com.dataAnalysisClustering.project.services;

import java.util.List;


import com.dataAnalysisClustering.project.entities.Job;

public interface IJobService {
	  List<Job> findAll();
	  public void save(Job job);
	  public void delete(String id);
	  public Job update(String id,Job job);
}
