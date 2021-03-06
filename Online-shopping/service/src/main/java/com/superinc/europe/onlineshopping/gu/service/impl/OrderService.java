package com.superinc.europe.onlineshopping.gu.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IDaoOrders;
import com.superinc.europe.onlineshopping.gu.entity.Orders;
import com.superinc.europe.onlineshopping.gu.service.IOrdersService;
import com.superinc.europe.onlineshopping.gu.service.exception.ExceptionMessages;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
@Service
@Transactional 
@Scope("session")
public class OrderService implements IOrdersService<Orders> {

	private static Logger logger = Logger.getLogger(OrderService.class);
	
	@Autowired
	private IDaoOrders<Object> daoOrders;
	
	/**
	 * Method to insert Order to DB
	 * @param orders
	 * @throws DaoException
	 */
	@Override
	public void insertOrder(Orders orders) throws DaoException {
		daoOrders.insertOrder(orders);
		
	}
	
	/**
	 * Method get last insert Id
	 * @throws DaoException
	 */
	@Override
	public int getLastInsertId() throws DaoException {
		try {
			return daoOrders.getLastInsertId();
		} catch (DaoException e) {
			logger.error(ExceptionMessages.ERROR_IN_ORDER_SERVICE + e);
			throw new DaoException(ExceptionMessages.ERROR_IN_ORDER_SERVICE, e);
		}
	}
}