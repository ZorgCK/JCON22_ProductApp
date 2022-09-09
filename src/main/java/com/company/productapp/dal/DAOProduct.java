
package com.company.productapp.dal;

import java.util.Collection;

import com.company.productapp.domain.Product;
import com.company.productapp.microstream.MicroStream;


public class DAOProduct
{
	public static Collection<Product> findAll()
	{
		return MicroStream.root.getProducts();
	}
	
	public static void insert(final Product product)
	{
		product.setProductUuid();
		MicroStream.root.getProducts().add(product);
		MicroStream.storageManager.store(MicroStream.root.getProducts());
	}
	
	public static void update(final Product product)
	{
		MicroStream.storageManager.store(product);
	}
	
	public static void delete(final Product product)
	{
		final Collection<Product> products = MicroStream.root.getProducts();
		products.remove(product);
		MicroStream.storageManager.store(products);
	}
}
