package com.qa.ims.persistence.dao;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.List;
	import org.apache.logging.log4j.LogManager;
	import org.apache.logging.log4j.Logger;

	import com.qa.ims.persistence.domain.*;
	import com.qa.ims.utils.*;

	public class OrderDAO implements Dao<Order> {

		public static final Logger LOGGER = LogManager.getLogger();
		

		@Override
		public Order modelFromResultSet(ResultSet resultSet) throws SQLException {
			Long OrderID = resultSet.getLong("OrderID");
			Long ID = resultSet.getLong("ID");
			Long PurchaseID = resultSet.getLong("PurchaseID");
			return new Order(PurchaseID, ID, OrderID);
		}

		@Override
		public List<Order> readAll() {
			try (Connection connection = DBUtils.getInstance().getConnection();
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("INSERT INTO Orders_Items(OrderID) VALUE (ProductID); SELECT * FROM Orders_Items");) {
				List<Order> Orders = new ArrayList<>();
				while (resultSet.next()) {
					Orders.add(modelFromResultSet(resultSet));
				}
				return Orders;
			} catch (SQLException e) {
				LOGGER.debug(e);
				LOGGER.error(e.getMessage());
			}
			return new ArrayList<>();
		}

		public Order readLatest() {
			try (Connection connection = DBUtils.getInstance().getConnection();
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("SELECT * FROM Orders_Items ORDER BY PurchaseID DESC LIMIT 1");) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			} catch (Exception e) {
				LOGGER.debug(e);
				LOGGER.error(e.getMessage());
			}
			return null;
		}

		@Override
		public Order create(Order Order) {
			try (Connection connection = DBUtils.getInstance().getConnection();
					PreparedStatement statement = connection
							.prepareStatement("INSERT INTO Orders(OrderID, ID) VALUES (?, ?, ?)");) {
				statement.setLong(1, Order.getOrderID());
				statement.setLong(2, Order.getID());
				statement.executeUpdate();
				return readLatest();
			} catch (Exception e) {
				LOGGER.debug(e);
				LOGGER.error(e.getMessage());
			}
			return null;
		}

		@Override
		public Order read(Long PurchaseID) {
			try (Connection connection = DBUtils.getInstance().getConnection();
					PreparedStatement statement = connection.prepareStatement("SELECT * FROM Orders_Items WHERE PurchaseID = ?");) {
				statement.setLong(1, PurchaseID);
				try (ResultSet resultSet = statement.executeQuery();) {
					resultSet.next();
					return modelFromResultSet(resultSet);
				}
			} catch (Exception e) {
				LOGGER.debug(e);
				LOGGER.error(e.getMessage());
			}
			return null;
		}

		@Override
		public Order update(Order Order) {
			try (Connection connection = DBUtils.getInstance().getConnection();
					PreparedStatement statement = connection
							.prepareStatement("UPDATE Orders_Items SET OrderID = ?, ID = ? WHERE PurchaseID = ?");) {
				statement.setLong(1, Order.getPurchaseID());
				statement.setLong(2, Order.getID());
				statement.setLong(3, Order.getOrderID());
				statement.executeUpdate();
				return read(Order.getPurchaseID());
			} catch (Exception e) {
				LOGGER.debug(e);
				LOGGER.error(e.getMessage());
			}
			return null;
		}


		@Override
		public int delete(long PurchaseID) {
			try (Connection connection = DBUtils.getInstance().getConnection();
					PreparedStatement statement = connection.prepareStatement("DELETE FROM Orders_Items WHERE OrderID = ?");) {
				statement.setLong(1, PurchaseID);
				return statement.executeUpdate();
			} catch (Exception e) {
				LOGGER.debug(e);
				LOGGER.error(e.getMessage());
			}
			return 0;
		}

	}



