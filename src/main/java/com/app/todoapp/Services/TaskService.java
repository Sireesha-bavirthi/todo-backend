package com.app.todoapp.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.todoapp.Repository.TaskRepository;
import com.app.todoapp.models.Task;

@Service
public class TaskService {
	@Autowired
	private TaskRepository taskRepo;
	public List<Task> getAllTasks(){
		return taskRepo.findAll();
	}
	
	public Task createTask(String title) {
		Task task=new Task();
		task.setTitle(title);
		task.setCompleted(false);
		return taskRepo.save(task);
	}
	
	public void deleteTask(Long Id) {
		taskRepo.deleteById(Id);
	}
	
	public Task toggleTask(Long Id) {
		Task task=taskRepo.findById(Id).orElseThrow(() -> new IllegalArgumentException("Invalid task id"));
		task.setCompleted(!task.isCompleted());
		return taskRepo.save(task);
	}

}
