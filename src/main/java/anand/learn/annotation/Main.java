package anand.learn.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import anand.learn.annotation.config.AppConfig;
import anand.learn.annotation.drivers.DataBaseDriver;
import anand.learn.annotation.service.DemoService;
import anand.learn.annotation.service.UserService;

public class Main {
	public static void main(String[] args) {
		AbstractApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);

		DataBaseDriver oracle = appContext.getBean("oracleDriver", DataBaseDriver.class);
		DataBaseDriver postgre = appContext.getBean("postgreBean", DataBaseDriver.class);
		UserService userService = appContext.getBean(UserService.class);

        System.out.println("Oracle driver info:");
        System.out.println(oracle.getInfo());
        
        System.out.println("Postgre driver info:");
        System.out.println(postgre.getInfo());

        System.out.println("UserService Information");
		System.out.println(userService.getDriverInfo());
		
		DemoService demoService = appContext.getBean("demoBean",DemoService.class);
		System.out.println("DemoService Information");
		System.out.println(demoService.getDemoName());

		appContext.close();
		
	}
}
