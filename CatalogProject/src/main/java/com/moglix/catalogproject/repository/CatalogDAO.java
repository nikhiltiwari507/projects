package com.moglix.catalogproject.repository;

import com.moglix.catalogproject.dto.Catalog;

public class CatalogDAO {

private static int counter = 0;
	
	Catalog  catalogs[]= new Catalog[10];
	public String addCatalog(Catalog catalog) {

		if(counter<catalogs.length) {
			
			catalogs[counter++]=catalog;
			return "success";
		}
			
	
	else {
		return "array is full";
		
	}
		

		
	}
	public Catalog getCatalogById(String id) {
		
		for (Catalog catalog : catalogs) {
			if(catalog!=null && id.equals(catalog.getCatId()) ){
				return catalog;
			}
			
		}
		return null;
		
	}
	public Catalog[] getCatalogs() {
		return catalogs;
	}
	private int getIndex(String id) {
		for(int i=0; i< catalogs.length;i++) {
			if(catalogs[i]!=null && catalogs[i].getCatId().equals(id)) {
				return i;
			}
		}
		return -1;
	}
	
public String updateCatalogs(String catId, Catalog catalog) {
	int index= this.getIndex(catId);
	
	if(index!=-1) {
		catalogs[index]=catalog;
		return "success";
	}
	else {
		return"not found";
	}
	
}	

	
	public String deleteCatalogById(String id) {
		
		Catalog catalog = this.getCatalogById(id);
		
		int index = this.getIndex(id);
		
		if(index!=-1) {
			catalogs[index]=null;
			return "success";
		}
		else
		
		return "not found";
	}
		
	
	
	public void deleteAllCatalogs() {
		catalogs=null;
		
	}
}
	
