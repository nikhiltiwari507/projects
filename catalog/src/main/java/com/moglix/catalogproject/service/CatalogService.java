package com.moglix.catalogproject.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.moglix.catalogproject.dto.Catalog;
import com.moglix.catalogproject.message.ResponseMessage;

public interface CatalogService {
	public Catalog  addcatalog(Catalog catalog) ;
	public Catalog updateCatalog(String id, Catalog catalog);
	
	public Catalog getCatalogById(String id);
	public String deleteCatalogById(String id);
	public List<Catalog> getallCatalog();
	public String deleteAllCatalog();
   // public ResponseEntity<ResponseMessage> uploadFile( MultipartFile file);

	
	
	

	}
	

