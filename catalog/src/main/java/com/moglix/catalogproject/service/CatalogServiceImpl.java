package com.moglix.catalogproject.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.moglix.catalogproject.dto.Catalog;
import com.moglix.catalogproject.message.ResponseMessage;
import com.moglix.catalogproject.repository.CatalogRepository;


@Service
//@Component
public class CatalogServiceImpl implements CatalogService {
	@Autowired
	CatalogRepository catalogRepository;

	@Override
	public Catalog addcatalog(Catalog catalog) {
		// TODO Auto-generated method stub
//		  String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//		  catalog.setProductImage(file.getContentType().getBytes());
//		
		Catalog catalog2= catalogRepository.save(catalog);
		
		if(catalog2!=null) {
			return catalog2;
		}
		else {
			return null;
		}
	}

	@Override
	public Catalog updateCatalog(String id, Catalog catalog) {
		// TODO Auto-generated method stub
//		if(getCatalogById(id)!=null)
//			return addcatalog(catalog);
//			else;
//			return null;
			
			return this.catalogRepository.save(catalog);
	}

	@Override
	public Catalog getCatalogById(String id) {
		// TODO Auto-generated method stub
		Optional<Catalog> optional=  catalogRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		
		return null;
	}

	@Override
	public String deleteCatalogById(String id) {
		// TODO Auto-generated method stub
		try {
			catalogRepository.deleteById(id);
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public List<Catalog> getallCatalog() {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public String deleteAllCatalog() {
		// TODO Auto-generated method stub
		catalogRepository.deleteAll();
		return "null";
	}




	  
//	public Catalog store(MultipartFile file) {
//		try {
//		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//		Catalog catalog = new Catalog(fileName, file.getContentType(), file.getBytes());
//
//		return catalogRepository.save(catalog);
//		} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//		return null;
//		}
//		} 
	  

	  public Catalog getFile(String id) {
	    return catalogRepository.findById(id).get();
	  }
	  
	  public Stream<Catalog> getAllFiles() {
	    return catalogRepository.findAll().stream();
	  }



	

	

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



}
