package com.moglix.catalogproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.moglix.catalogproject.dto.Catalog;
import com.moglix.catalogproject.service.CatalogService;

@SpringBootApplication
public class CatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogApplication.class, args);
		
		//ApplicationContext applicationContext= SpringApplication.run(CatalogApplication.class, args);
		
//		CatalogService catalogService=applicationContext.getBean(CatalogService.class);
//		
//		String result =CatalogService.addcatalog(new Catalog("1233355","abc","bbb","ee","jj"));
//		System.out.println(result);
//		String result0 =catalogService.addcatalog(new Catalog("1237773355","abc","bbb","ee","jj"));
//		System.out.println(result0);
//		String result11 =catalogService.addcatalog(new Catalog("1237777773355","abc","bbhhb","eejj","jj"));
//		System.out.println(result11);
////		
//		String result1=	catalogService.updateCatalog("1233355",new Catalog("1233355","nikhil","tiri","abc","abc"));	
//		 System.out.println(result1);
////		 
//		Catalog result2=catalogService.getCatalogById("1233355");	
//		System.out.println(result2);
////		
////		 
//		String result3=	catalogService.deleteCatalogById("1233355");
//		System.out.println(result3);
////		
////		
//		String result4=	catalogService.deleteAllCatalog();
//		System.out.println(result4);
		
	}

}
