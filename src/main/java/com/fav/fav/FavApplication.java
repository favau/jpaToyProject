package com.fav.fav;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;

@SpringBootApplication
@ComponentScan(basePackages = { "com.fav.fav" })
@MapperScan("com.fav.fav.project1.**.mapper")
public class FavApplication {
	@Autowired
	private Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(FavApplication.class, args);
	}

	 @EventListener(ApplicationReadyEvent.class)
	public void checkJdbcUrl() {
		// Environment에서 값 조회
		String jdbcUrl = environment.getProperty("spring.datasource.jdbc-url");
		System.out.println("Configured JDBC URL: " + jdbcUrl);
	}
}