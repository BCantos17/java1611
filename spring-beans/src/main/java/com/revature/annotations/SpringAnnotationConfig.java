package com.revature.annotations;

import javax.print.attribute.standard.MediaSize.Other;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.revature.data.DAO;
import com.revature.data.DAOImpl;
import com.revature.data.Facade;

/**
 *	Spring bean configuration file
 */

@Configuration
@ComponentScan( basePackages={"com.revature.web"} )
/*@Import(value={Other.class, Another.class})*/
public class SpringAnnotationConfig {

	@Bean(name="dao")
	public DAO dao(){
		return new DAOImpl();
	}
	
/*	@Bean(name="facade", initMethod="initialize",
			destroyMethod="cleanup", autowire=Autowire.BY_NAME)
	public Facade facade(){
		return new Facade();
	}*/
	
	@Bean(name="facade", initMethod="initialize",
			destroyMethod="cleanup")
	public Facade facade(){
		// setter injection
		// Facade f = new Facade(); f.setDao( dao() ); return f; 
		return new Facade( dao() );  // constructor injection
	}
}








