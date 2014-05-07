package com.example.neo4j.labels;

import java.util.List;

import com.example.neo4j.inheritance.AppConfig;
import com.example.neo4j.inheritance.entities.Child1;
import com.example.neo4j.inheritance.entities.Child2;
import com.example.neo4j.inheritance.repositories.BaseRepository;
import com.example.neo4j.inheritance.repositories.Child1Repository;
import com.example.neo4j.inheritance.repositories.Child2Repository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.neo4j.graphdb.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Frantisek Hartman
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = {
		AppConfig.class
})
@Transactional
public class RepositoryTest {

	private static final Logger logger = LoggerFactory.getLogger(RepositoryTest.class);

	@Autowired
	private BaseRepository baseRepository;

	@Autowired
	private Child1Repository child1Repository;

	@Autowired
	private Child2Repository child2Repository;

	@Autowired
	private Neo4jTemplate neo4jTemplate;

	@Test
	public void testNotWorking() throws Exception {
		Child1 child1 = child1Repository.save(new Child1("child1", "prop1"));

		Child2 child2 = neo4jTemplate.findOne(child1.getId(), Child2.class);

		child2.setProp2("prop2");
		child2Repository.save(child2);

		Node node = neo4jTemplate.getNode(child1.getId());

		logger.info("Labels: {}", node.getLabels());
		for (String key : node.getPropertyKeys()) {
			logger.info("Property: {}, value: {}", key, node.getProperty(key));
		}

		assertThat(baseRepository.findAll().as(List.class).size(), is(1));
		assertThat(child1Repository.findAll().as(List.class).size(), is(1));
		assertThat(child2Repository.findAll().as(List.class).size(), is(1));

	}
}
