
package com.company.productapp.microstream;

import java.util.HashSet;
import java.util.Set;

import com.company.productapp.domain.Product;
import com.company.productapp.domain.ProductCategory;


/**
 * MicroStream data root. Create your data model from here.
 *
 * @see <a href="https://docs.microstream.one/manual/">Reference Manual</a>
 */
public class DataRoot
{
	private Set<Product>         products = new HashSet<>();
	private Set<ProductCategory> category = new HashSet<>();

	public Set<Product> getProducts()
	{
		return this.products;
	}

	public void setProducts(final Set<Product> products)
	{
		this.products = products;
	}

	public Set<ProductCategory> getCategory()
	{
		return this.category;
	}

	public void setCategory(final Set<ProductCategory> category)
	{
		this.category = category;
	}
}
