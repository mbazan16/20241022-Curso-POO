package com.proyectoClase.springHR;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigurationExcludeFilter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@SpringBootConfiguration
//@EnableAutoConfiguration
//@EnableJpaRepositories
//@ComponentScan(basePackages = {"com.proyectoClase.entities.entities",
//		"com.proyectoClase.springHR.admin",
//		"com.proyectoClase.springHR.controllers",
//		"com.proyectoClase.springHR.data",
//		"com.proyectoClase.springHR.repositories"}, excludeFilters = { @ComponentScan.Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class),
//		@ComponentScan.Filter(type = FilterType.CUSTOM, classes = AutoConfigurationExcludeFilter.class) })
public class SpringHrApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHrApplication.class, args);
	}

}
