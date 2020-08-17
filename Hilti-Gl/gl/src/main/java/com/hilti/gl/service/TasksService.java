package com.hilti.gl.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.Optional;

import com.hilti.gl.domain.TasksEntity;
import com.hilti.gl.exception.RecordNotFoundException;
import com.hilti.gl.repository.TasksRepository;

@Service
public class TasksService {
	
	@Autowired
	TasksRepository repository;
	
	public List<TasksEntity> getAllTasksDetails(Integer pageNo, Integer pageSize, String sortBy){
		        
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		Page<TasksEntity> pagedResult = repository.findAll(paging);
		      
		if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<TasksEntity>();
        }			
	}
        
	public TasksEntity getTasksById(Long id) throws RecordNotFoundException
    {
        Optional<TasksEntity> tasks = repository.findById(id);
         
        if(tasks.isPresent()) {
            return tasks.get();
        } else {
            throw new RecordNotFoundException("No tasks record exist for given id");
        }
    }
	 public TasksEntity createOrUpdateTasks(TasksEntity entity) throws RecordNotFoundException
	    {
	        Optional<TasksEntity> tasks = repository.findById(entity.getId());
	         
	        if(tasks.isPresent())
	        {
	        	TasksEntity newEntity = tasks.get();
	            newEntity.setName(entity.getName());
	            newEntity.setDescription(entity.getDescription());
	            newEntity.setStatus(entity.getStatus());
	            newEntity.setCreated_at(entity.getCreated_at());
	 
	            newEntity = repository.save(newEntity);
	             
	            return newEntity;
	        } else {
	            entity = repository.save(entity);
	             
	            return entity;
	        }
	    }
	
	
}
