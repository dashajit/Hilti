package com.hilti.gl.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.hilti.gl.domain.TasksEntity;

public interface TasksRepository extends PagingAndSortingRepository<TasksEntity, Long> {

}
