
package com.company.productapp.domain;

import java.io.Serializable;
import java.util.UUID;


public class ProductCategory implements Serializable
{

	private String uuid;
	private String name;

	public ProductCategory(final String name)
	{
		this.setName(name);
	}

	public String getUuid()
	{
		return this.uuid;
	}

	public void setUuid()
	{
		this.uuid = UUID.randomUUID().toString();
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(final String name)
	{
		this.name = name;
	}

}
