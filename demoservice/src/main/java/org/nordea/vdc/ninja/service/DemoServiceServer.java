package org.nordea.vdc.ninja.service;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

@Configuration
@EnableAutoConfiguration
@SpringBootApplication
@EnableDiscoveryClient
public class DemoServiceServer {

	private Logger logger = Logger.getLogger(DemoServiceServer.class.getName());

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "demoservice-server");
		SpringApplication.run(DemoServiceServer.class, args);
	}
	@Bean
	public DataSource dataSource() {
		logger.info("dataSource() invoked");
		
		DataSource dataSource = (new EmbeddedDatabaseBuilder())
				.addScript("classpath:db/schema.sql")
				.addScript("classpath:db/data.sql").build();

		logger.info("dataSource = " + dataSource);

		// Sanity check
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Map<String, Object>> service = jdbcTemplate
				.queryForList("SELECT * FROM T_SERVICE");
		logger.info("System has " + service.size() + " service");
		for(Map<String, Object> s :service) {
			logger.info(s.toString());
		}
		return dataSource;
	}
	
	

}
