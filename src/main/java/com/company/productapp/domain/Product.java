
package com.company.productapp.domain;

import java.io.Serializable;
import java.util.UUID;


public class Product implements Serializable
{

	private String          uuid;
	private String          name, description, imageUrl; // Image loaded via URL TODO: Maybe saved localy?
	private ProductCategory category;
	private double          unitPrice, unitWeight;
	private int             unitsInStock;

	public Product(
		final String name,
		final String desc,
		final ProductCategory category,
		final double price,
		final double weight,
		final int stock)
	{
		this.setUuid();
		this.setName(name);
		this.setDescription(desc);
		this.setCategory(category);
		this.setUnitPrice(price);
		this.setUnitWeight(weight);
		this.setUnitsInStock(stock);
	}

	public void setUuid()
	{
		this.uuid = UUID.randomUUID().toString();
	}

	public String getUuid()
	{
		return this.uuid;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(final String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return this.description;
	}

	public void setDescription(final String description)
	{
		this.description = description;
	}

	public String getImageUrl()
	{
		return this.imageUrl;
	}

	public void setImageUrl(final String imageUrl)
	{
		this.imageUrl = imageUrl;
	}

	public ProductCategory getCategory()
	{
		return this.category;
	}

	public void setCategory(final ProductCategory category)
	{
		this.category = category;
	}

	public Double getUnitPrice()
	{
		return this.unitPrice;
	}

	public void setUnitPrice(final Double unitPrice)
	{
		this.unitPrice = unitPrice;
	}

	public Double getUnitWeight()
	{
		return this.unitWeight;
	}

	public void setUnitWeight(final Double unitWeight)
	{
		this.unitWeight = unitWeight;
	}

	public int getUnitsInStock()
	{
		return this.unitsInStock;
	}

	public void setUnitsInStock(final int unitsInStock)
	{
		this.unitsInStock = unitsInStock;
	}

}
