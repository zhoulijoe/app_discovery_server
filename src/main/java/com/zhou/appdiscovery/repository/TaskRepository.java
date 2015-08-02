package com.zhou.appdiscovery.repository;

import com.zhou.appdiscovery.model.Task;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TaskRepository extends PagingAndSortingRepository<Task, Long> {

}
