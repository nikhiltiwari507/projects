package com.moglix.catalogproject;

import com.moglix.catalogproject.dto.Catalog;
import com.moglix.catalogproject.service.CatalogService;
import com.moglix.catalogproject.service.CatalogServiceImpl;

public class Main {

	public static void main(String[] args) {
		CatalogService catelogService = CatalogServiceImpl.getInstance();
		Catalog catalog = new Catalog();
		catalog.setProductId("12A");
		catalog.setProductName("Book");
		catalog.setProductDescription("hindi books");
		catalog.setCatId("12AB");
		// adding catalog
		System.out.println(catelogService.addcatalog(catalog));
		// getting catalog by productId
		System.out.println(catelogService.getCatalogById("12A"));
		// updating catalog by catalogId
		catalog.setProductId("13A");
		System.out.println(catelogService.updateCatalog("12A", catalog));
		// getiing update catalog by new productId
		System.out.println(catelogService.getCatalogById("13A"));

		// get allCatalog
		for (Catalog cat : catelogService.getallCatalog()) {
			System.out.println(cat);
		}
		// deleted catalog by productId
//		catelogService.deleteCatalogById("13A");

		// delete all catalog
		catelogService.deleteAllCatalog();

		// get allCatalog
		// getting error we deleting all catalog thats why we are getting
		for (Catalog cat : catelogService.getallCatalog()) {
			System.out.println(cat);
			
			
			String result1 = catelogService.addcatalog(catalog);
			System.out.println(result1);
			
			String result2 = catelogService.deleteCatalogById("12A");
			System.out.println(result2);
	         catalog.setCatId("EMP00000002");	
	         
			String result3= catelogService.updateCatalog("12166",catalog);
			System.out.println(result3);
			
			
			
		}

	}
}
