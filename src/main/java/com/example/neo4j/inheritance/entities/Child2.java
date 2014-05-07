package com.example.neo4j.inheritance.entities;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;

/**
 * @author Frantisek Hartman
 */
@NodeEntity
@TypeAlias("Child2")
public class Child2 extends Base {

	@Indexed
	private String prop2;

	public String getProp2() {
		return prop2;
	}

	public void setProp2(String prop2) {
		this.prop2 = prop2;
	}
}
