
package com.company.productapp.dal;

import java.util.Collection;

import com.company.productapp.domain.ProductCategory;
import com.company.productapp.microstream.MicroStream;


public class ProductCategoryDAO
{
	public static Collection<ProductCategory> findAll()
	{
		return MicroStream.root.getCategory();
	}
	
	public static ProductCategory findByName(final String name)
	{
		return MicroStream.root.getCategory()
			.stream()
			.filter(e -> e.getName().equals(name))
			.findFirst()
			.orElse(null);
	}

	public static void insert(final ProductCategory category)
	{
		category.setUuid();
		ProductCategoryDAO.findAll().add(category);
		MicroStream.storageManager.store(ProductDAO.findAll());
		
	}
	
	public static void update(final ProductCategory category)
	{
		MicroStream.storageManager.store(category);
	}
}
