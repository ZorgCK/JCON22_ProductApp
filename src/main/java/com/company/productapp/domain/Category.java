
package com.company.productapp.domain;

import java.io.Serializable;
import java.util.UUID;


public class Category implements Serializable
{
	
	private String uuid;
	private String categoryName;
	
	public Category()
	{

	}

	public Category(final String name)
	{
		this.setCategoryName(name);
	}
	
	public String getCategoryUuid()
	{
		return this.uuid;
	}
	
	public void setCategoryUuid()
	{
		this.uuid = UUID.randomUUID().toString();
	}
	
	public String getCategoryName()
	{
		return this.categoryName;
	}
	
	public void setCategoryName(final String name)
	{
		this.categoryName = name;
	}
	
}
