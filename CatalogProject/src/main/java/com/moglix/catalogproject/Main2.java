package com.moglix.catalogproject;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.moglix.catalogproject.config.Config;
import com.moglix.catalogproject.dto.Catalog;
import com.moglix.catalogproject.service.CatalogService;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AnnotationConfigApplicationContext applicationContext= new AnnotationConfigApplicationContext(Config.class);
		
		DataSource dataSource =applicationContext.getBean("mysqlDataSource",DataSource.class);
		System.out.println(dataSource!=null);
		
		//get bean
//	    applicationContext.scan("com.moglix.ctalogproject.repository");
//	    applicationContext.scan("com.moglix.ctalogproject.service");
//	    applicationContext.refresh();
		CatalogService catalogService= applicationContext.getBean(CatalogService.class);
		String result=	catalogService.addcatalog(new Catalog("125677777","nikhil","tiwari","abc","xyz"));	
		 System.out.println(result);
		 
		 String result1=	catalogService.updateCatalog("1256777",new Catalog("12567777","nikhil","tiri","abc","abc"));	
		 System.out.println(result1);
		 
			String result3=	catalogService.deleteCatalogById("126");
			System.out.println(result3);

		 List<Catalog> catalogs= new ArrayList<Catalog>();
		 catalogs=catalogService.getallCatalog();
		 System.out.println(catalogs);
		 
		 CatalogService catalogService2=applicationContext.getBean(CatalogService.class);
		 System.out.println(catalogService==catalogService2);
		 System.out.println(catalogService.hashCode());
		 System.out.println(catalogService2.hashCode());
		 System.out.println(catalogService.equals(catalogService2));
		
		 

	}

}
