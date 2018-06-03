package org.myretail.service;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.myretail.dao.ProductDao;
import org.myretail.model.ProductModel;
import org.myretail.utils.ProductExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	private static final Logger logger = Logger.getLogger(ProductServiceImpl.class);

	public ProductModel getProductById(int id) throws SQLException {
		logger.info("Inside ProductServiceImpl : getProductById");
		ProductModel productModel = productDao.getProductById(id);
		if (null == productModel) {
			logger.error("No Product Found Againest Id : " + id);
			throw new ProductExceptionHandler("Invalid Product Id");
		}
		return productModel;
	}

	public void updateProductPrice(int id, ProductModel productModel) throws SQLException, ProductExceptionHandler {
		logger.info("Inside ProductServiceImpl : updateProductPrice");
		if (isIdMatching(id, productModel.getId())) {
			productDao.updateProductPrice(id, productModel.getCurrentPrice().getValue());
		} else {
			logger.error("Product Id received from URL{" + id + "} doesn't match with product id{"
					+ productModel.getId() + "} in request body");
			throw new ProductExceptionHandler("Product Id received from URL{" + id + "} doesn't match with product id{"
					+ productModel.getId() + "} in request body");
		}
	}

	protected boolean isIdMatching(int id, int idNew) {
		return (id == idNew);
	}
}