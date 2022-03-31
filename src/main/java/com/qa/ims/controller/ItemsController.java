package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemsDAO;
import com.qa.ims.persistence.domain.Items;
import com.qa.ims.utils.Utils;

/**
 * Takes in items details for CRUD functionality
 *
 */
public class ItemsController implements CrudController<Items> {

	public static final Logger LOGGER = LogManager.getLogger();

	private ItemsDAO itemsDAO;
	private Utils utils;

	public ItemsController(ItemsDAO itemsDAO, Utils utils) {
		super();
		this.itemsDAO = itemsDAO;
		this.utils = utils;
	}

	/**
	 * Reads all items to the logger
	 */
	@Override
	public List<Items> readAll() {
		List<Items> itemss = itemsDAO.readAll();
		for (Items items : itemss) {
			LOGGER.info(items);
		}
		return itemss;
	}

	/**
	 * Creates items by taking in user input
	 */
	@Override
	public Items create() {
		LOGGER.info("Please enter a item name");
		String itemName = utils.getString();
		LOGGER.info("Please enter a description");
		String description = utils.getString();
		Items items = itemsDAO.create(new Items(itemName, description));
		LOGGER.info("Items created");
		return items;
	}

	/**
	 * Updates an existing items by taking in user input
	 */
	@Override
	public Items update() {
		LOGGER.info("Please enter the id of the items you would like to update");
		Long id = utils.getLong();
		LOGGER.info("Please enter a item name");
		String itemName = utils.getString();
		LOGGER.info("Please enter a description");
		String description = utils.getString();
		Items items = itemsDAO.update(new Items(id, itemName, description));
		LOGGER.info("Items Updated");
		return items;
	}

	/**
	 * Deletes an existing items by the id of the items
	 * 
	 * @return
	 */
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the items you would like to delete");
		Long id = utils.getLong();
		return itemsDAO.delete(id);
	}

}