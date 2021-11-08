package com.moglix.catalogproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moglix.catalogproject.dto.Catalog;

		
	@Repository
	public interface CatalogRepository extends JpaRepository<Catalog, String>{	
		
		
	}


