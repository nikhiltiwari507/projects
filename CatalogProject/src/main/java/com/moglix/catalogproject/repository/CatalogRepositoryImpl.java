package com.moglix.catalogproject.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.moglix.catalogproject.dto.Catalog;
import com.moglix.catalogproject.utils.DBUtils;
@Repository
//@Component

public class CatalogRepositoryImpl implements CatalogRepository {
	
	@Autowired
	DBUtils dbUtils;

	
	public String addcatalog(Catalog catalog) {
		// TODO Auto-generated method stub
		Connection connection = dbUtils.getConnection();
		String insertStatement = "INSERT INTO catalog( productId, productName, catId,  productDescription, productImage)" 
				+ "VALUES (?,?,?,?,?)"; 
		
		PreparedStatement preparedStatement =null; 
		try {
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, catalog.getProductId());
			preparedStatement.setString(2, catalog.getProductName());
			preparedStatement.setString(3, catalog.getCatId());
			preparedStatement.setString(4, catalog.getProductDescription());
			preparedStatement.setString(5, catalog.getProductImage());
			
			int res =preparedStatement.executeUpdate();
			
			if(res>0) {
				return "success";
				
			}else {
				return "fail";
			}
			
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	
	public String updateCatalog(String id, Catalog catalog) {
		// TODO Auto-generated method stub
		Connection connection = dbUtils.getConnection();
		String updateStatement="update catalog set productName=?, catId=?,  productDescription=?, productImage=?, where productId=?"; 
	
		
		PreparedStatement preparedStatement =null; 
		try {
			preparedStatement = connection.prepareStatement(updateStatement);
			preparedStatement.setString(5,id);
			preparedStatement.setString(1, catalog.getProductName());
			preparedStatement.setString(2, catalog.getCatId());
			preparedStatement.setString(3, catalog.getProductDescription());
			preparedStatement.setString(4, catalog.getProductImage());
			
			
			int res =preparedStatement.executeUpdate();
			
			if(res>0) {
				return "update success";
				
			}else {
				return "update failed";
			}
			
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	

	
	public Catalog getEmployeeById(String id) {
		// TODO Auto-generated method stub
		Connection connection =dbUtils.getConnection();
		String getEmployeeByIdStatement="select * from  catalog where productId =?"; 
		
		PreparedStatement preparedStatement =null; 
		try {
			preparedStatement = connection.prepareStatement(getEmployeeByIdStatement);
			preparedStatement.setString(1,id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
			String productId = resultSet.getString("productId");
			String productName = resultSet.getString("productName");
			String catId = resultSet.getString("catId");
			String productDescription = resultSet.getString("productDescription");
			String productImage = resultSet.getString("productImage");
			
			Catalog catalog = new Catalog(productId,productName,catId,productDescription,productImage);
			return catalog;
			}
			} catch (SQLException e) {
			e.printStackTrace();
			} finally {
			this.dbUtils.closeConnection(connection);
			}
			return null; 

	}

	
	public List<Catalog> getEmployee() {
		Connection connection=dbUtils.getConnection();
		PreparedStatement preparedStatement =null; 
		ResultSet resultset=null;
		String query ="select * from Employee";
		List<Catalog> catalogs=new ArrayList<Catalog>();
		
		try {
			
			preparedStatement = connection.prepareStatement(query);
			
			resultset= preparedStatement.executeQuery();
			while (resultset.next()) {
				//cursor
				Catalog catalog = new Catalog(resultset.getString("productId"),resultset.getString("productName"),resultset.getString("catId"),
													resultset.getString("productDescription"),resultset.getString("productImage"));
				
	
				catalogs.add(catalog);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbUtils.closeConnection(connection);
		}
		
		
		
		return catalogs;
	}

	
	public String deleteCatalogById(String id) {
		// TODO Auto-generated method stub
		
		Connection connection=this.dbUtils.getConnection();
		String deleteStatement= "Delete from Catalog where ProductId =?";
		try {
		PreparedStatement preparedStatement=connection.prepareStatement(deleteStatement);
		preparedStatement.setString(1, id);
		
		int res = preparedStatement.executeUpdate();
		
		if(res!=0)
			
		return "Entity Deleted successfully ";
		} 
		catch (SQLException e) {
		e.printStackTrace();
		}
		finally {
			
		this.dbUtils.closeConnection(connection);
		
		}

		return "Problem Occured while Deleting the entity"; 

	
}

	
	public void deleteAllCatalogs() {
		// TODO Auto-generated method stub
		
		Connection connection=this.dbUtils.getConnection();
		String deleteStatement= "Delete from Catalog";
		try {
		PreparedStatement preparedStatement=connection.prepareStatement(deleteStatement);
		
		
		int res = preparedStatement.executeUpdate();
		
		if(res!=0) {
			System.out.println("table deleted");
			
		} 
		}
		catch (SQLException e) {
		e.printStackTrace();
		}
		finally {
			
		this.dbUtils.closeConnection(connection);
		
		}	
		
	}


	public Catalog getCatalogById(String id) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<Catalog> getallCatalog() {
		// TODO Auto-generated method stub
		return null;
	}


	public void deleteAllCatalog() {
		// TODO Auto-generated method stub
		
	}


}
////	private static CatalogRepository catalogRepository;
////
////	private CatalogRepositoryImpl() {
////	}
//
////	public static CatalogRepository getInstance() {
////		if (catalogRepository == null) {
////			catalogRepository = new CatalogRepositoryImpl();
////			return catalogRepository;
////		} else {
////			return catalogRepository;
////		}
////	}
//
//	private static int counter = 0;
////	private Catalog catalogs[] = new Catalog[16];
////
////	private int getIndex(String productId) {
////		for (int i = 0; i < catalogs.length; i++) {
////			if (catalogs[i] != null && catalogs[i].getProductId().equalsIgnoreCase(productId)) {
////				return i;
////			}
////		}
////		return -1;
//	
//	
////	}
//private List<Catalog>catalogs= new ArrayList<Catalog>();
//	public String addcatalog(Catalog catalog) {
////		if (counter < catalogs.length) {
////			catalogs[counter++] = catalog;
////			return "Added Sccessfully";
////		}
////		return "Not inserted";
//	boolean result = catalogs.add(catalog);
//		
//		if(result) {
//			return "success....";
//		}
//		else {
//			return "fail";
//		}
//		
//	
//	
//	}
//
//	public String updateCatalog(String id, Catalog catalog) {
////		int index = this.getIndex(id);
////		if (index != -1) {
////			catalogs[index] = catalog;
////			return "updated Successfully";
////		}
////		return "not updated";
////	}
//
//		
//		if (this.getCatalogById(catalog.getCatId()) != null) {
//			int index = this.catalogs.indexOf(this.getCatalogById(catalog.getCatId()));
//			this.catalogs.set(index, catalog);
//			
//			return "Updated SuccessFully";
//			}
//		return "not updated "; 
//	}
//	
//	
//	
//	public Catalog getCatalogById(String id) {
////		int index = this.getIndex(id);
////		if (index != -1) {
////			return catalogs[index];
////		}
////		return null;
//	
//		for(Catalog catalog : catalogs) {
//			if(id.equals(catalog.getCatId())) {
//				return catalog;
//		}
//		
//		}
//		
//		return null;
//		
//	
//	
//	
//	
//	}
//
//	private int getIndex(String id) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//	
//	
//	
//
//	public String deleteCatalogById(String id) {
////		int index = this.getIndex(id);
////		if (index != -1) {
////			catalogs[index] = null;
////			System.out.println("Deleted successfully");
////		}
//		
//		Catalog catalog = this.getCatalogById(id);
//		if(catalog!=null){
//			if (catalogs.remove(catalog))
//	        return "success";
//			else 
//				return "Fail";
//		}
//		else {
//			return "not found...";
//		}
//		
//			
//	}
//
//	public List<Catalog> getallCatalog() {
//		return catalogs;
//	}
//
//	public void deleteAllCatalog() {
////		catalogs = null;
//		catalogs.clear();
//
//	}
//
//}
