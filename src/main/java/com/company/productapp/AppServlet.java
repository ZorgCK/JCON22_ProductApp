
package com.company.productapp;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

import javax.servlet.annotation.WebServlet;

import com.company.productapp.dal.DAOCategory;
import com.company.productapp.domain.Category;
import com.company.productapp.domain.Product;
import com.company.productapp.microstream.MicroStream;
import com.rapidclipse.framework.server.RapServlet;


@WebServlet(urlPatterns = "/*", asyncSupported = true)
public class AppServlet extends RapServlet
{
	public AppServlet()
	{
		super();
		
		if(MicroStream.root.getCategory().isEmpty())
		{
			MicroStream.root.getCategory().addAll(AppServlet.createCategories());
			MicroStream.root.getCategory().stream().forEach(category -> category.setCategoryUuid());
			MicroStream.storageManager.store(MicroStream.root.getCategory());
		}
		
		if(MicroStream.root.getProducts().isEmpty())
		{
			MicroStream.root.getProducts().addAll(AppServlet.createProducts());
			MicroStream.root.getProducts().stream().forEach(product -> product.setProductUuid());
			MicroStream.storageManager.store(MicroStream.root.getProducts());
		}
	}
	
	private static Collection<Product> createProducts()
	{
		
		return Arrays.asList(
			new Product("Zido M1", "For beginners - the perfect mouse from Zido to boost up your gaming experience",
				DAOCategory.findByName("Mouse"), new BigDecimal("39.99"), 0.1,
				19),
			new Product("Zido M2",
				"The slightly bigger mouse by Zido is delivered with weights and you can adjust the length",
				DAOCategory.findByName("Mouse"), new BigDecimal("70"),
				0.3, 21),
			new Product("Zido M9",
				"the wireless mouse by Zido has the newest sensor and in addition is wireless! Comes with extra weights and a loading cable",
				DAOCategory.findByName("Mouse"), new BigDecimal("114.49"), 0.1,
				11),
			new Product("Zorra Future",
				"The Future is the absolute premium to take to boost your gaming experience to a new level!",
				DAOCategory.findByName("Mouse"), new BigDecimal("139.79"),
				0.4, 9),
			new Product("Zorra Trekk",
				"Zorra offers with the Trekk adjustable length and width as well as the newest generation of sensors!",
				DAOCategory.findByName("Mouse"), new BigDecimal("90"), 0.1,
				4),
			new Product("Bevor A3",
				"Bevor released the A3 in a plain design but didnt hold back in quality of sensors and software that comes with it!",
				DAOCategory.findByName("Mouse"), new BigDecimal("60"),
				0.2, 2),
			new Product("Zido K1", "For beginners - the perfect keyboard from Zido to boost up your gaming experience",
				DAOCategory.findByName("Keyboard"), new BigDecimal("62.49"), 0.8,
				4),
			new Product("Zido Mechanical K2", "The advanced version of the K1 -> K2 offers mechanic switches",
				DAOCategory.findByName("Keyboard"), new BigDecimal("90.49"),
				0.7, 11),
			new Product("Zido Mechanical K5",
				"The K5 is even better! Comes with an extra set of switches! Available in cherry, brown and blue!",
				DAOCategory.findByName("Keyboard"), new BigDecimal("119.99"), 1.0,
				8),
			new Product("NoLogic Mechanical Zed Custom",
				"In tradtition with the quality of NoLogic the Zed comes in all possible switches and is customizeable! What a great time to own NoLogic hardware!",
				DAOCategory.findByName("Keyboard"), new BigDecimal("160"),
				1.01, 1),
			new Product("Bevor Mechanical H9",
				"The H9 offers cherry, brown and blue switches - and the price speaks for itself!",
				DAOCategory.findByName("Keyboard"), new BigDecimal("50"), 0.9,
				6),
			new Product("Niceee Office",
				"The Office keyboard is plain and simple - works as it should and is very cheap!",
				DAOCategory.findByName("Keyboard"), new BigDecimal("19"),
				0.4, 17),
			new Product("Zido Barrow",
				"For beginners - the perfect computer from Zido to start experiencing the great games out there!",
				DAOCategory.findByName("Computer"), new BigDecimal("679"), 9.8,
				2),
			new Product("Zorra Herd", "The Herd offers a minicase and hardware from a decade ago. Nice office computer",
				DAOCategory.findByName("Computer"), new BigDecimal("999"),
				10.0, 1),
			new Product("Niceee Sunset",
				"You dont want to think much in buying a new computer? Get the sunset! Not the best, but surely top of the midfield!",
				DAOCategory.findByName("Computer"), new BigDecimal("2100"), 9.7,
				3),
			new Product("Bevor Plaster", "The Plaster will be heating the household all byhimself! Power to the max!",
				DAOCategory.findByName("Computer"), new BigDecimal("5890.99"),
				13.1, 1),
			new Product("NoLogic Alien", "The only thing you can say about this computer? Out of this world!",
				DAOCategory.findByName("Computer"), new BigDecimal("2749.99"), 6.21,
				2),
			new Product("Blobb Zigger 2019", "The Zigger series has the best quality for its price deal!",
				DAOCategory.findByName("Computer"), new BigDecimal("3198.99"),
				11.0, 3),
			new Product("Blobb Zigger 2022", "The Zigger series has the best quality for its price deal!",
				DAOCategory.findByName("Computer"), new BigDecimal("3771.49"),
				10.04, 5));
	}
	
	private static Collection<Category> createCategories()
	{
		return Arrays.asList(
			new Category("Mouse"),
			new Category("Keyboard"),
			new Category("Computer"));
	}
}
