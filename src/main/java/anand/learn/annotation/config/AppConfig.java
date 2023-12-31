package anand.learn.annotation.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import anand.learn.annotation.drivers.DataBaseDriver;
import anand.learn.annotation.drivers.OracleDriver;
import anand.learn.annotation.drivers.PostgreSqlDriver;
import anand.learn.annotation.service.DemoService;

@Configuration
@ComponentScan("anand.learn.annotation")
@PropertySource("classpath:oracledatabase.properties")
public class AppConfig {

	@Autowired
    Environment environment;
	@Autowired 
	DemoService demoService;
	
	@Bean
	DataBaseDriver oracleDriver() {
		OracleDriver oracleDriver = new OracleDriver();
		oracleDriver.setDriver(environment.getProperty("db.driver"));
        oracleDriver.setUrl(environment.getProperty("db.url"));
        oracleDriver.setPort(Integer.parseInt(environment.getProperty("db.port")));
        oracleDriver.setUser(environment.getProperty("db.user"));
        oracleDriver.setPassword(environment.getProperty("db.password"));

        return oracleDriver;

	}

	@Bean(name="postgreBean")
	DataBaseDriver postgreSqlDriver() {
		return new PostgreSqlDriver();
	}
	
	
	@Bean(name="demoBean")
	DemoService getBeann() {
		return demoService;
	}
	
}
