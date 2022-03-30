package com.qa.ims.controller;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

public class ItemController implements CrudController<Item> {

	public static final Logger LOGGER = LogManager.getLogger();
	private ItemDAO ItemDAO;
	private Utils utils;

	public ItemController(ItemDAO ItemDAO, Utils utils) {
		super();
		this.ItemDAO = ItemDAO;
		this.utils = utils;
	}

	@Override
	public List<Item> readAll() {
		List<Item> Items = ItemDAO.readAll();
		for (Item Item : Items) {
			LOGGER.info(Item);
		}
		return Items;
	}

	@Override
	public Item create() {
		LOGGER.info("Please enter an item name");
		String ItemTitle = utils.getString();
		LOGGER.info("Please enter a Price");
		Float Price = utils.getFloat();
		Item Item = ItemDAO.create(new Item(ItemTitle, Price));
		LOGGER.info("Item created");
		return Item;
	}

	@Override
	public Item update() {
		LOGGER.info("Please enter the Product id of the Item you would like to update");
		Long ProductID = utils.getLong();
		LOGGER.info("Please enter a product name");
		String ItemTitle = utils.getString();
		LOGGER.info("Please enter a Price");
		Float Price = utils.getFloat();
		Item Item = ItemDAO.update(new Item(ProductID, ItemTitle, Price));
		LOGGER.info("Item Updated");
		return Item;
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the Item you would like to delete");
		Long ProductID = utils.getLong();
		return ItemDAO.delete(ProductID);
	}

}