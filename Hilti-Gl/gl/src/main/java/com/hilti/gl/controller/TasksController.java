package com.hilti.gl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hilti.gl.domain.TasksEntity;
import com.hilti.gl.exception.RecordNotFoundException;
import com.hilti.gl.service.TasksService;

@RestController
@RequestMapping("/tasks")
public class TasksController {
	
	@Autowired
	TasksService service;
	
	@GetMapping
	public ResponseEntity<List<TasksEntity>> tasksDetails(
			  @RequestParam(defaultValue = "0") Integer pageNo,
              @RequestParam(defaultValue = "10") Integer pageSize,
              @RequestParam(defaultValue = "id") String sortBy)
	        {  
		List<TasksEntity> list= service.getAllTasksDetails(pageNo, pageSize, sortBy);
	 return new ResponseEntity<List<TasksEntity>>(list, new HttpHeaders(),HttpStatus.OK); 
            }  
	
	 @GetMapping("/{id}")
	    public ResponseEntity<TasksEntity> tasksById(@PathVariable("id") Long id)
	                                                    throws RecordNotFoundException {
		 TasksEntity entity = service.getTasksById(id);
	 
	        return new ResponseEntity<TasksEntity>(entity, new HttpHeaders(), HttpStatus.OK);
	    }
	 @PostMapping
	    public ResponseEntity<TasksEntity> createOrUpdateTasks(TasksEntity tasks)
	                                                    throws RecordNotFoundException {
		 TasksEntity updated = service.createOrUpdateTasks(tasks);
	        return new ResponseEntity<TasksEntity>(updated, new HttpHeaders(), HttpStatus.OK);
	    }
	
              
}
