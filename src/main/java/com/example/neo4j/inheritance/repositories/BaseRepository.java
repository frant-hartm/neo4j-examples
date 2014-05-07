package com.example.neo4j.inheritance.repositories;

import com.example.neo4j.inheritance.entities.Base;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * @author Frantisek Hartman
 */
public interface BaseRepository extends GraphRepository<Base> {
}
