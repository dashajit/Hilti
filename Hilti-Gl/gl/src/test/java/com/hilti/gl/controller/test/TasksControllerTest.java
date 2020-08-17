package com.hilti.gl.controller.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.hilti.gl.GlApplication;
import com.hilti.gl.controller.TasksController;
import com.hilti.gl.domain.TasksEntity;
import com.hilti.gl.repository.TasksRepository;
import com.hilti.gl.service.TasksService;

@SpringBootTest(classes = GlApplication.class)
public class TasksControllerTest {
	
	@InjectMocks
	private TasksController tasksController;
	
	@Mock
	TasksService tasksService;
	
	@Mock
	TasksRepository tasksRepository;
	
	private ResponseEntity<List<TasksEntity>> response;
	
	
	
	@BeforeAll
	public void setUp() {
		
	}
	
	@Test
	public void testgetAllTasksDetails() {
		
		List<TasksEntity> list= new ArrayList<TasksEntity>();
		
		Mockito.when(tasksService.getAllTasksDetails(5, 3, "abc")).thenReturn(list);
		response=tasksController.tasksDetails(5, 3, "abc");
		
	}
	

}
