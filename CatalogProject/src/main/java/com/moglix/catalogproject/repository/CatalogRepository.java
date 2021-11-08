package com.moglix.catalogproject.repository;

import java.util.List;

import com.moglix.catalogproject.dto.Catalog;

public interface CatalogRepository {
		
		public String  addcatalog(Catalog catalog) ;
		public String updateCatalog(String id, Catalog catalog);
		
		public Catalog getCatalogById(String id);
		public String deleteCatalogById(String id);
//		public Catalog[] getallCatalog();
		public List<Catalog> getallCatalog();
		public void deleteAllCatalog();
		

		}


