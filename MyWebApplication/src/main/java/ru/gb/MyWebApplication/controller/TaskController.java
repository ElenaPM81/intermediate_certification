package ru.gb.MyWebApplication.controller;

import org.springframework.web.bind.annotation.*;
import ru.gb.MyWebApplication.domen.Task;
import ru.gb.MyWebApplication.services.TaskService;
import ru.gb.MyWebApplication.services.FileGateWay;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    private final FileGateWay fileGateWay;

    @PostMapping
    public Task addTask(@RequestBody Task task) {

        fileGateWay.writeToFile(task.getName() + ".txt", task.getDescription());
        return taskService.addTask(task);


    }


    public TaskController(TaskService taskService, FileGateWay fileGateWay) {
        this.taskService = taskService;
        this.fileGateWay = fileGateWay;
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getById(@PathVariable UUID id) {
        return taskService.getTask(id);

    }

    @PostMapping("/{id}")
    public Task addById(@RequestBody Task task) {
        return taskService.addTask(task);
    }

    @PutMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        taskService.getTask(id);
    }
}
