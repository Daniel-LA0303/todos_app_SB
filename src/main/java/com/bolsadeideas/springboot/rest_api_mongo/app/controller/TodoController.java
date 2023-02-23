package com.bolsadeideas.springboot.rest_api_mongo.app.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bolsadeideas.springboot.rest_api_mongo.app.model.Todos;
import com.bolsadeideas.springboot.rest_api_mongo.app.repository.TodosRepository;
import com.bolsadeideas.springboot.rest_api_mongo.app.service.TodoService;

//@RestController
//@RequestMapping("/api")
@Controller
public class TodoController {
	@Autowired
	private TodoService service;
	
	//List todo
	@GetMapping({"/todos", "/"})
	public String getAllTodosList(Model model) {
		model.addAttribute("todosList", service.getAllTodos());
		return "todos"; //retorna el archivo estudiantes.html
	}
	
	//view new todo
	@GetMapping("/todos/new")
	public String showForm(Model model) {
		Todos todo = new Todos();
		model.addAttribute("todo", todo);
		return "new_todo";
	}
	
	@PostMapping("/todos")
	public String saveTodoContent(@ModelAttribute("todo") Todos todo) {
		service.saveTodo(todo);
		
		return "redirect:/todos";
	}
	
	//view edit todo
	@GetMapping("/todos/edit/{id}")
	public String showFormEdit(@PathVariable String id, Model model) {
		
		model.addAttribute("todo", service.getOneTodo(id));
		
		return "edit_todo";
	}
	@PostMapping("/todos/{id}")
	public String updateTodo(@PathVariable String id, @ModelAttribute("todo") Todos todo, Model model) {
		Todos todoTrue = service.getOneTodo(id);
		todoTrue.setId(id);
		todoTrue.setTodo(todo.getTodo());
		todoTrue.setDescription(todo.getDescription());
		service.updateOneTodo(todoTrue);
		return "redirect:/todos";
	}
	
	//mostrando la vista
	@GetMapping("/todos/{id}")
	public String deleteOneTodo(@PathVariable String id) {
		service.deleteOneTodo(id);
		return "redirect:/todos";
	}
	
}
