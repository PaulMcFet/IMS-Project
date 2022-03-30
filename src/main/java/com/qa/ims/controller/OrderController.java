package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

	public class OrderController implements CrudController<Order> {

		public static final Logger LOGGER = LogManager.getLogger();

		private OrderDAO OrderDAO;
		private Utils utils;

		public OrderController(OrderDAO OrderDAO, Utils utils) {
			super();
			this.OrderDAO = OrderDAO;
			this.utils = utils;
		}


		@Override
		public List<Order> readAll() {
			List<Order> Orders = OrderDAO.readAll();
			for (Order Order : Orders) {
				LOGGER.info(Order);
			}
			return Orders;
		}


		@Override
		public Order create() {
			LOGGER.info("Please enter a Customer ID");
			Long ID = utils.getLong();
			LOGGER.info("Please enter a Product ID");
			Long ProductID = utils.getLong();
			Order Order = OrderDAO.create(new Order(ID, ProductID));
			LOGGER.info("Order created");
			return Order;
		}


		@Override
		public Order update() {
			LOGGER.info("Please enter the id of the Order you would like to update");
			Long OrderID = utils.getLong();
			LOGGER.info("Please confirm Customer ID");
			Long ID = utils.getLong();
			LOGGER.info("Please enter the ID of the product to be ordered");
			Long ProductID = utils.getLong();
			Order Order = OrderDAO.update(new Order(OrderID, ID, ProductID));
			LOGGER.info("Order Updated");
			return Order;
		}


		@Override
		public int delete() {
			LOGGER.info("Please enter the id of the Order you would like to delete");
			Long ID = utils.getLong();
			return OrderDAO.delete(ID);
		}

	}

