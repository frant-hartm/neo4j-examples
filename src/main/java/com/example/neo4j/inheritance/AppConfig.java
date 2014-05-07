package com.example.neo4j.inheritance;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.test.TestGraphDatabaseFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;

/**
 * @author Frantisek Hartman
 */
@Configuration
@EnableNeo4jRepositories(basePackages = {"com.example.neo4j.inheritance.repositories."})
public class AppConfig extends Neo4jConfiguration {

	public AppConfig() throws ClassNotFoundException {
		setBasePackage("com.example.neo4j.inheritance.entities");
	}

	@Bean
	public GraphDatabaseService graphDatabaseService() {
		return new TestGraphDatabaseFactory().newImpermanentDatabase();
	}

}
