package vn.menogo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class CoreMenugoApplication {

	//public static void main(String[] args) {		SpringApplication.run(CoreMenugoApplication.class, args);}

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = SpringApplication.run(CoreMenugoApplication.class, args);

		System.out.println("Let's inspect the beans provided by Spring Boot:");

		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}
	}

}
