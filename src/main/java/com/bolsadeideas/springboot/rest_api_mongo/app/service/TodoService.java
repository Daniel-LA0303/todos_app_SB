package com.bolsadeideas.springboot.rest_api_mongo.app.service;

import java.util.List;

import com.bolsadeideas.springboot.rest_api_mongo.app.model.Todos;

public interface TodoService {
	
	public List<Todos> getAllTodos();
	
	public Todos saveTodo(Todos todo);
	
	public Todos getOneTodo(String id);
	
	public Todos updateOneTodo(Todos todo);
	
	public void deleteOneTodo(String id);
}
