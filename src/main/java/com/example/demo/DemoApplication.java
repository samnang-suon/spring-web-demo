package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		// Before
		// SpringApplication.run(DemoApplication.class, args);
		// After
		// source: https://www.javaguides.net/2018/11/spring-component-annotation-example.html
		ConfigurableApplicationContext applicationContext = SpringApplication.run(DemoApplication.class, args);
		System.out.println("========== COMPONENT-DEMO ==========");
		ComponentDemo componentDemo = (ComponentDemo) applicationContext.getBean("component-demo");
		System.out.println(componentDemo.getValue());
	}

	@Component("component-demo")
	class ComponentDemo {
		public String getValue() {
			return "Hello World";
		}
	}
}
