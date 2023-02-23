package com.bolsadeideas.springboot.rest_api_mongo.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.rest_api_mongo.app.model.Todos;
import com.bolsadeideas.springboot.rest_api_mongo.app.repository.TodosRepository;

@Service
public class TodoServiceImpl implements TodoService{
	
	@Autowired
	private TodosRepository repository;
	
	@Override
	public List<Todos> getAllTodos() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Todos saveTodo(Todos todo) {
		// TODO Auto-generated method stub
		return repository.save(todo);
	}

	@Override
	public Todos getOneTodo(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	@Override
	public Todos updateOneTodo(Todos todo) {
		// TODO Auto-generated method stub
		return repository.save(todo);
	}

	@Override
	public void deleteOneTodo(String id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}
}
