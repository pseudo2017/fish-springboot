package me.ruslanys.controllers;

import me.ruslanys.models.Task;
import me.ruslanys.models.Type;
import me.ruslanys.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Arrays;
import java.util.List;


@Controller
public class MainController {

    private final TaskService taskService;

    @Autowired
    public MainController(TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping({ "/", "/index.html" })
    public String index() {
        return "index";
    }

    @RequestMapping("/task")
    @ResponseBody
    public List<Task> task(@RequestParam String typeName, @RequestParam String runner, String description) throws JmsException, JsonProcessingException {
        Type type = Type.valueOf(typeName);

        List<Task> tasks = Arrays.asList(
                new Task(type, runner, description),
                new Task(type, runner, description),
                new Task(type, runner, description)
        );
        int j =tasks.size();
        for (int i=0;i<j;i++){
        	taskService.start(tasks.get(i));
        }
      

        return tasks;
    }

}
