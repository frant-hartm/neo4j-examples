package com.example.neo4j.inheritance.entities;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;

/**
 * @author Frantisek Hartman
 */
@NodeEntity
@TypeAlias("BASE")
public class Base {

	@GraphId
	private Long id;

	@Indexed
	private String name;

	public Base() {
	}

	public Base(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
