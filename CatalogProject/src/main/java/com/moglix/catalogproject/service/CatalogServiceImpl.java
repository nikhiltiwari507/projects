package com.moglix.catalogproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.moglix.catalogproject.dto.Catalog;
import com.moglix.catalogproject.repository.CatalogRepository;
import com.moglix.catalogproject.repository.CatalogRepositoryImpl;
@Service
//@Component
public class CatalogServiceImpl implements CatalogService {
	@Autowired
	CatalogRepository catalogRepository;

//	CatalogRepository catalogRepository=CatalogRepositoryImpl.getInstance();
//	private static CatalogService catalogService;
//	private CatalogServiceImpl() {
//	}
//	public static CatalogService getInstance() {
//		if(catalogService==null) {
//			catalogService=new CatalogServiceImpl();
//			return catalogService;
//		}else {
//			return catalogService;
//		}
//	}

	
	public String addcatalog(Catalog catalog) {
		return catalogRepository.addcatalog(catalog);
	}

	
	public String updateCatalog(String id, Catalog catalog) {
		return catalogRepository.updateCatalog(id, catalog);
	}

	
	public Catalog getCatalogById(String id) {
		return catalogRepository.getCatalogById(id);
	}

	
	public String deleteCatalogById(String id) {
		return catalogRepository.deleteCatalogById(id);
		
	}

	
	public List<Catalog> getallCatalog(){
		return catalogRepository.getallCatalog();
	
}

	
	public void deleteAllCatalog() {
		catalogRepository.deleteAllCatalog();
		
	}

}
