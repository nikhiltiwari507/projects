package com.moglix.catalogproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.moglix.catalogproject.dto.Catalog;
import com.moglix.catalogproject.message.ResponseMessage;
import com.moglix.catalogproject.service.CatalogService;




@RestController
@RequestMapping("/api")
@CrossOrigin
public class CatalogController {
	
	@Autowired
	CatalogService catalogService;
	@GetMapping(value="/hello")   //this mapping will work for get method
	
	public String sayHello() {
		return "hello from nikhil";
	}
	

	@PostMapping("/add")
	public Catalog addCatalog(@RequestBody Catalog catalog) {
		return catalogService.addcatalog(catalog);
	
	}
	
    @GetMapping("/catalog/{id}")
    public  Catalog getCatalogById(@PathVariable("id")String id) {
    	return this.catalogService.getCatalogById(id);
    	
    }
    @DeleteMapping("/catalog/{id}")
    public String deleteCatalogById(@PathVariable("id")String id) {
    	return this.catalogService.deleteCatalogById(id);
    	}
    
    @DeleteMapping("/catalog/deleteAll")
    public String deleteAll() {
    	return this.catalogService.deleteAllCatalog();
    }
    
    @PostMapping("/update/{id}")
    public Catalog updateCatalog(@RequestBody Catalog catalog,@PathVariable("id") String id ) {
    return catalogService.updateCatalog(id,catalog);

    } 
    
    
//    
//    @PostMapping(value="/upload", consumes = {MediaType.APPLICATION_JSON_VALUE,
//    		MediaType.MULTIPART_FORM_DATA_VALUE }  )
//    public ResponseEntity<ResponseMessage> uploadFile(@RequestPart MultipartFile file) {
//      String message = "";
//      try {
//    	  catalogService.store(file);
//
//        message = "Uploaded the file successfully: " + file.getOriginalFilename();
//        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
//      } catch (Exception e) {
//        message = "Could not upload the file: " + file.getOriginalFilename() + "!";
//        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
//      }
}



