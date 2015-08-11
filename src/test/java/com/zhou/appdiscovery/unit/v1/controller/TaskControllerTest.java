package com.zhou.appdiscovery.unit.v1.controller;

import com.zhou.appdiscovery.AppDiscoveryApplication;
import com.zhou.appdiscovery.model.Task;
import com.zhou.appdiscovery.repository.TaskRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AppDiscoveryApplication.class)
@ContextConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class TaskControllerTest {

    @InjectMocks
    private TaskController taskController;

    @Mock
    private TaskRepository taskRepository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetTaskById() {
        Long taskId = 1L;
        String taskSummary = "Task test";
        Task mockTask = new Task();
        mockTask.setTaskId(taskId);
        mockTask.setSummary(taskSummary);
        when(taskRepository.findOne(taskId)).thenReturn(mockTask);

        ResponseEntity<Task> responseEntity = taskController.getTask(taskId);
        verify(taskRepository, times(1)).findOne(taskId);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);

        Task task = responseEntity.getBody();
        assertEquals(taskId, task.getTaskId());
        assertEquals(taskSummary, task.getSummary());
        assertEquals("http://localhost/v1/tasks/1", task.getLink("self").getHref());
    }
}
