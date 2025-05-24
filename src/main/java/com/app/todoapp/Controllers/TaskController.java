package com.app.todoapp.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.todoapp.Services.TaskService;
import com.app.todoapp.models.Task;

@CrossOrigin(origins="http://localhost:5173")
@RestController
public class TaskController {
   @Autowired
   private TaskService taskService;
   
   @GetMapping("/tasks")
   public List<Task> getAllTasks(){
	   return taskService.getAllTasks();
   }
   
   @PostMapping("/tasks")
   public Task createTask(@RequestBody Task task) {
	   return taskService.createTask(task.getTitle());
   }
   
   @DeleteMapping("/tasks/{id}")
   public void DeleteTask(@PathVariable Long id) {
	   taskService.deleteTask(id);
   }
   
   @PutMapping("/tasks/{id}")
   public Task toggleTask(@PathVariable Long id) {
       return taskService.toggleTask(id);
   }
   
   
}
