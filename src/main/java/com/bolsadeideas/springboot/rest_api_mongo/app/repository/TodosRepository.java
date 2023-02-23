package com.bolsadeideas.springboot.rest_api_mongo.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bolsadeideas.springboot.rest_api_mongo.app.model.Todos;

public interface TodosRepository extends MongoRepository<Todos, String>{

}
