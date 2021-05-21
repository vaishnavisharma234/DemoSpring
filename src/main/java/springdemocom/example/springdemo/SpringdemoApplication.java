package springdemocom.example.springdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.demo.sre.Repository.DemoRepository;
import com.demo.sre.Service.DemoService;
import com.demo.sre.utility.ExceptionHandlerController;
@SpringBootApplication
@ComponentScan({"com.demo.sre.controller"})
public class SpringdemoApplication {

	private static final Logger Logger=LoggerFactory.getLogger(SpringdemoApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SpringdemoApplication.class, args);
	}
	@Bean
	public DemoService demoService() {
		return new DemoService();
	}
	@Bean
	public DemoRepository demoRepository() {
		return new DemoRepository();
	}

	@Bean 
	public ExceptionHandlerController exceptionHandlerController() {
		return new ExceptionHandlerController();
	}
}
