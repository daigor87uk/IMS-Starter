package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrdersDAO;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.Utils;

/**
 * Takes in orders details for CRUD functionality
 *
 */
public class OrdersController implements CrudController<Orders> {

	public static final Logger LOGGER = LogManager.getLogger();

	private OrdersDAO ordersDAO;
	private Utils utils;

	public OrdersController(OrdersDAO ordersDAO, Utils utils) {
		super();
		this.ordersDAO = ordersDAO;
		this.utils = utils;
	}

	/**
	 * Reads all orders to the logger
	 */
	@Override
	public List<Orders> readAll() {
		List<Orders> orderss = ordersDAO.readAll();
		for (Orders orders : orderss) {
			LOGGER.info(orders);
		}
		return orderss;
	}

	/**
	 * Creates a orders by taking in user input
	 */
	@Override
	public Orders create() {
		LOGGER.info("Please enter a item name");
		String itemName = utils.getString();
		LOGGER.info("Please enter a description");
		String description = utils.getString();
		Orders orders = ordersDAO.create(new Orders(itemName, description));
		LOGGER.info("Orders created");
		return orders;
	}

	/**
	 * Updates an existing orders by taking in user input
	 */
	@Override
	public Orders update() {
		LOGGER.info("Please enter the orderNumber of the orders you would like to update");
		Long orderNumber = utils.getLong();
		LOGGER.info("Please enter a item name");
		String itemName = utils.getString();
		LOGGER.info("Please enter a description");
		String description = utils.getString();
		Orders orders = ordersDAO.update(new Orders(orderNumber, itemName, description));
		LOGGER.info("Orders Updated");
		return orders;
	}

	/**
	 * Deletes an existing orders by the id of the orders
	 * 
	 * @return
	 */
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the orders you would like to delete");
		Long id = utils.getLong();
		return ordersDAO.delete(id);
	}

}