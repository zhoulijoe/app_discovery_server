package com.zhou.appdiscovery.v1.controller;

import com.zhou.appdiscovery.model.Task;
import com.zhou.appdiscovery.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController("TaskControllerV1")
@RequestMapping("/api/v1/")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @RequestMapping(value="tasks", method=RequestMethod.GET)
    public ResponseEntity<Page<Task>> getAllTasks(Pageable pageable) {
        Page<Task> tasks = taskRepository.findAll(pageable);

        for (Task task : tasks) {
            updateTaskWithLinks(task);
        }

        return new ResponseEntity<Page<Task>>(tasks, HttpStatus.OK);
    }

    @RequestMapping(value="tasks/{taskId}", method=RequestMethod.GET)
    public ResponseEntity<Task> getTask(@PathVariable Long taskId) {
        Task task = taskRepository.findOne(taskId);

        updateTaskWithLinks(task);

        return new ResponseEntity<Task>(task, HttpStatus.OK);
    }

    private void updateTaskWithLinks(Task task) {
        task.add(linkTo(methodOn(TaskController.class).getTask(task.getTaskId())).withSelfRel());
    }
}
