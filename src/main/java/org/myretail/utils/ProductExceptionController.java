package org.myretail.utils;

import java.sql.SQLException;

import org.myretail.model.MyExceptionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ProductExceptionController {

	@ExceptionHandler(SQLException.class)
	@ResponseBody
	public ResponseEntity<MyExceptionModel> processSqlException(SQLException se) {
		MyExceptionModel model = new MyExceptionModel();
		model.setExceptionMessage("Business Error Happened. Please Contact Support");
		ResponseEntity<MyExceptionModel> entity = new ResponseEntity<MyExceptionModel>(model, HttpStatus.BAD_REQUEST);
		return entity;
	}

	@ExceptionHandler(ProductExceptionHandler.class)
	@ResponseBody
	public ResponseEntity<MyExceptionModel> processProductException(ProductExceptionHandler pe) {
		MyExceptionModel model = new MyExceptionModel();
		model.setExceptionMessage(pe.getExceptionMessage());
		ResponseEntity<MyExceptionModel> entity = new ResponseEntity<MyExceptionModel>(model, HttpStatus.BAD_REQUEST);
		return entity;
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ResponseEntity<MyExceptionModel> processException(Exception e) {
		MyExceptionModel model = new MyExceptionModel();
		model.setExceptionMessage("Internal Server Error. Please Contact Support");
		ResponseEntity<MyExceptionModel> entity = new ResponseEntity<MyExceptionModel>(model, HttpStatus.INTERNAL_SERVER_ERROR);
		return entity;
	}
}