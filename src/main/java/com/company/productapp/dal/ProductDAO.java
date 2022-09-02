
package com.company.productapp.dal;

import java.util.Collection;

import com.company.productapp.domain.Product;
import com.company.productapp.microstream.MicroStream;


public class ProductDAO
{
	public static Collection<Product> findAll()
	{
		return MicroStream.root.getProducts();
	}
	
	public static void insert(final Product product)
	{
		product.setUuid();
		ProductDAO.findAll().add(product);
		MicroStream.storageManager.store(ProductDAO.findAll());
	}
	
	public static void update(final Product product)
	{
		MicroStream.storageManager.store(product);
	}
	
	public static void delete(final Product product)
	{
		final Collection<Product> products = ProductDAO.findAll();
		products.remove(product);
		MicroStream.storageManager.store(products);
	}
}
