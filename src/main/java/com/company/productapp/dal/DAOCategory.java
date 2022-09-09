
package com.company.productapp.dal;

import java.util.Collection;

import com.company.productapp.domain.Category;
import com.company.productapp.microstream.MicroStream;


public class DAOCategory
{
	public static Collection<Category> findAll()
	{
		return MicroStream.root.getCategory();
	}

	public static Category findByName(final String name)
	{
		return MicroStream.root.getCategory()
			.stream()
			.filter(e -> e.getCategoryName().equals(name))
			.findFirst()
			.orElse(null);
	}
}
