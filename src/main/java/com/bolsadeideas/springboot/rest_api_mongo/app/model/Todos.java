package com.bolsadeideas.springboot.rest_api_mongo.app.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "todos")
public class Todos {
	@Id
	private String id;
	private String todo;
	
	private String description;
	
	private Date createdAt;
	
	private Date updateAt;
	
	public Todos () {
		
	}

	public Todos(String id, String todo, String description, Date createdAt, Date updateAt) {
		super();
		this.id = id;
		this.todo = todo;
		this.description = description;
		this.createdAt = createdAt;
		this.updateAt = updateAt;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTodo() {
		return todo;
	}

	public void setTodo(String todo) {
		this.todo = todo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}
}
