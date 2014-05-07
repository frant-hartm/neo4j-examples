package com.example.neo4j.inheritance.repositories;

import com.example.neo4j.inheritance.entities.Child1;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * @author Frantisek Hartman
 */
public interface Child1Repository extends GraphRepository<Child1> {
}
