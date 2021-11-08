package com.moglix.employeemanagementsystem.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;



@ComponentScan("com.moglix.employeemanagementsystem")
@Configuration  //config details are available in the class.
@PropertySource("classpath:application.properties")
public class Config {
	
	@Autowired
	Environment environment;
	
	@Bean("mysqlDataSource")  //singleton k liye kyuki ek object chahiye	
	public DataSource getMySQLDataSource () {
		BasicDataSource dataSource=new BasicDataSource();
	    dataSource.setDriverClassName(environment.getProperty("db.classname"));
	    dataSource.setUsername(environment.getProperty("db.username"));
	    dataSource.setPassword(environment.getProperty("db.password"));
	    dataSource.setUrl(environment.getProperty("db.url"));
	    return dataSource;
	
	
}
}
