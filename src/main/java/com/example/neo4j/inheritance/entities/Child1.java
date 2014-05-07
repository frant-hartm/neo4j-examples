package com.example.neo4j.inheritance.entities;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;

/**
 * @author Frantisek Hartman
 */
@NodeEntity
@TypeAlias("Child1")
public class Child1 extends Base {

	@Indexed
	private String prop1;

	public Child1() {
	}

	public Child1(String name, String prop1) {
		super(name);
		this.prop1 = prop1;
	}

	public String getProp1() {
		return prop1;
	}

	public void setProp1(String prop1) {
		this.prop1 = prop1;
	}
}
