package com.lio.sc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lio.sc.beans.Product;
import com.lio.sc.util.DerbyDataLoader;

public class ProductDAOImpl extends AbstractDAO implements ProductDAO{

	{
		if(!checkIfDBExists("PRODUCTS")){
			try {
				new DerbyDataLoader().loadProductsFromFile(ProductDAOImpl.class.getResource("/com/lio/data/Products.txt").getFile());
			} catch (Exception e) {
				System.out.println("Table does not exists. But Exception happend while creating the table.");
				e.printStackTrace();
			}
		}
	}
	@Override
	public List<Product> getAllProducts() {
		
		Connection connection  = getConnection();
		List<Product> products = new ArrayList<Product>();
		
		try {
			PreparedStatement pStmt = connection.prepareStatement("select PRODUCTID AS pId," +
																		"PRODUCTNAME AS pName," +
																		"SUPPLIERID AS supId," +
																		"CATEGORYID AS catId," +
																		"UNIT AS unit, " +
																		"PRICE AS price from Products");
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()){
				Product product = new Product(); 
				product.setProductId(rs.getLong("pId"));
				product.setProductName(rs.getString("pName"));
				product.setSupplierId(rs.getLong("supId"));
				product.setUnit(rs.getString("unit"));
				product.setPrice(rs.getDouble("price"));
				products.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return products;
	}

	@Override
	public Product getProductById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProductsByName(String productName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addNewProduct(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProduct(Long id) {
		// TODO Auto-generated method stub
		
	}
	
//	public static void main(String[] args){
//		ProductDAOImpl impl = new ProductDAOImpl(); 
//		System.out.println(impl.getAllProducts());
//	}

}
