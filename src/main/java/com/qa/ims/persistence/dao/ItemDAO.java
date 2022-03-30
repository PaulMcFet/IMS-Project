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
	import com.qa.ims.persistence.domain.Item;
	import com.qa.ims.utils.DBUtils;

	public class ItemDAO implements Dao<Item> {

		public static final Logger LOGGER = LogManager.getLogger();

		@Override
		public Item modelFromResultSet(ResultSet resultSet) throws SQLException {
			Long ProductID = resultSet.getLong("Productid");
			String ItemName = resultSet.getString("ItemName");
			Float Price = resultSet.getFloat("Price");
			return new Item(ProductID, ItemName, Price);
		}


		@Override
		public List<Item> readAll() {
			try (Connection connection = DBUtils.getInstance().getConnection();
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("SELECT * FROM Items");) {
				List<Item> Items = new ArrayList<>();
				while (resultSet.next()) {
					Items.add(modelFromResultSet(resultSet));
				}
				return Items;
			} catch (SQLException e) {
				LOGGER.debug(e);
				LOGGER.error(e.getMessage());
			}
			return new ArrayList<>();
		}

		public Item readLatest() {
			try (Connection connection = DBUtils.getInstance().getConnection();
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("SELECT * FROM Items ORDER BY ProductID DESC LIMIT 1");) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			} catch (Exception e) {
				LOGGER.debug(e);
				LOGGER.error(e.getMessage());
			}
			return null;
		}


		@Override
		public Item create(Item Item) {
			try (Connection connection = DBUtils.getInstance().getConnection();
					PreparedStatement statement = connection
							.prepareStatement("INSERT INTO Items(ItemName, Price) VALUES (?, ?)");) {
				statement.setString(1, Item.getItemName());
				statement.setFloat(2, Item.getPrice());
				statement.executeUpdate();
				return readLatest();
			} catch (Exception e) {
				LOGGER.debug(e);
				LOGGER.error(e.getMessage());
			}
			return null;
		}

		@Override
		public Item read(Long ProductID) {
			try (Connection connection = DBUtils.getInstance().getConnection();
					PreparedStatement statement = connection.prepareStatement("SELECT * FROM Items WHERE ProductID = ?");) {
				statement.setLong(1, ProductID);
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
		public Item update(Item Item) {
			try (Connection connection = DBUtils.getInstance().getConnection();
					PreparedStatement statement = connection
							.prepareStatement("UPDATE Items SET ItemName = ?, Price = ? WHERE ProductID = ?");) {
				statement.setString(1, Item.getItemName());
				statement.setFloat(2, Item.getPrice());
				statement.setLong(3, Item.getProductID());
				statement.executeUpdate();
				return read(Item.getProductID());
			} catch (Exception e) {
				LOGGER.debug(e);
				LOGGER.error(e.getMessage());
			}
			return null;
		}


		@Override
		public int delete(long ProductID) {
			try (Connection connection = DBUtils.getInstance().getConnection();
					PreparedStatement statement = connection.prepareStatement("DELETE FROM Items WHERE ProductID = ?");) {
				statement.setLong(1, ProductID);
				return statement.executeUpdate();
			} catch (Exception e) {
				LOGGER.debug(e);
				LOGGER.error(e.getMessage());
			}
			return 0;
		}

	}