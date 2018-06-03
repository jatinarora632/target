package org.myretail.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.myretail.model.ProductModel;
import org.myretail.model.ProductPriceModel;
import org.myretail.utils.ProductExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private DataSource dataSource;

	private static final Logger logger = Logger.getLogger(ProductDaoImpl.class);

	public ProductModel getProductById(int id) throws SQLException {
		logger.info("Inside ProductDaoImpl : getProductById");
		String sqlQuery = "Select p.id, p.name, cp.value, cp.currency_code from product p inner join current_price cp on p.id = cp.pid where p.id=?";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ProductModel model = null;

		connection = dataSource.getConnection();
		logger.info("Database Connection Successful");
		preparedStatement = connection.prepareStatement(sqlQuery);
		preparedStatement.setInt(1, id);
		resultSet = preparedStatement.executeQuery();
		if (null != resultSet && resultSet.next()) {
			model = new ProductModel();
			ProductPriceModel priceModel = new ProductPriceModel();
			model.setId(resultSet.getInt(1));
			model.setName(resultSet.getString(2));
			priceModel.setValue(resultSet.getFloat(3));
			priceModel.setCurrencyCode(resultSet.getString(4));
			model.setCurrentPrice(priceModel);
		}
		connection.close();
		logger.info("Result Received from Database : " + model);
		return null != model ? model : null;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void updateProductPrice(int id, float newPrice) throws SQLException {
		logger.info("Inside ProductDaoImpl : updateProductPrice");
		String checkQuery = "select * from current_price where pid = ?";
		Connection connection = dataSource.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(checkQuery);
		preparedStatement.setInt(1, id);
		ResultSet rs = preparedStatement.executeQuery();
		if(null!= rs && rs.next()){
			String updateQuery = "update current_price set value = ? where pid = ?";
			preparedStatement.close();
			preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setFloat(1, newPrice);
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
			logger.info("Inside ProductDaoImpl : Update Successful");
			connection.close();
		}else{
			connection.close();
			logger.error("Product id{" + id + "} does not exist in Database");
			throw new ProductExceptionHandler("Invalid Product Id");
		}
	}
}