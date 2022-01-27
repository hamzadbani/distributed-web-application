package com.dataAnalysisClustering.project.controller;

import java.lang.reflect.Type;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dataAnalysisClustering.project.entities.Admin;
import com.dataAnalysisClustering.project.entities.Job;
import com.dataAnalysisClustering.project.services.IJobService;
import com.dataAnalysisClustering.project.services.JobService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/job")
public class JobController {
	
	   @Autowired
       private IJobService IjobService;
	   
	   @GetMapping("/findall")
	   @CrossOrigin(origins = "http://localhost:4200")
		public List<Job> fetchAll(){
			
			return this.IjobService.findAll();
		}
		
	   @DeleteMapping("delete/{id}")
	   @CrossOrigin(origins = "http://localhost:4200")
		public void deleteJob(@PathVariable("id") String id){
			IjobService.delete(id);
		}
	   
	   @PutMapping("update/{id}")
	   @CrossOrigin(origins = "http://localhost:4200")
		public void UpdateTodo(@PathVariable("id")String id,@RequestBody Job job) {
			IjobService.update(id,job);
		}
	   
	   @PostMapping("/save")
	   @CrossOrigin(origins = "http://localhost:4200")
		public void addJob(@RequestBody Job job) {
		   job.setId(UUID.randomUUID().toString());
			IjobService.save(job);
		//this.ItodoService.save(todo);
		}
	   

	    @GetMapping("/LevelDemanding")
		@CrossOrigin(origins = "http://localhost:8080")
		public List<Entry<String, Integer>> countLevel() throws Exception {
			List<Job> jobs=IjobService.findAll();
			HashMap<String,Integer> map = new HashMap<String,Integer>();
			HashMap<String,Integer> map2 = new HashMap<String,Integer>();
			 int entry = 0,student = 0,freelance = 0,experienced = 0,manager = 0;
			for (Job job : jobs) {
				if(job.getLevel().equals("Entry Level")) {
				   map.put("entry", entry++);
				}
				if(job.getLevel().equals("Student")) {
					 map.put("student",student++);
				}
				if(job.getLevel().equals("Freelance / Project")) {
					 map.put("freelance",freelance++);
				}
				if(job.getLevel().equals("Experienced")) {
					 map.put("experienced",experienced++);
				}
				if(job.getLevel().equals("Manager")) {
					 map.put("manager",manager++);
				}
			}
	        List<Entry<String, Integer>> entryLevelList = map.entrySet()
                    .stream()
                    .collect(Collectors.toList());
	        ArrayList<Map.Entry<String, Integer>> arr = new ArrayList<Map.Entry<String, Integer>>();
	        arr.add(new AbstractMap.SimpleEntry("level", entry));
	        arr.add(new AbstractMap.SimpleEntry("level", student));
	        arr.add(new AbstractMap.SimpleEntry("level", freelance));
	        arr.add(new AbstractMap.SimpleEntry("level", experienced));
	        arr.add(new AbstractMap.SimpleEntry("level", manager));

			return arr;
		}

	   
	   
}
