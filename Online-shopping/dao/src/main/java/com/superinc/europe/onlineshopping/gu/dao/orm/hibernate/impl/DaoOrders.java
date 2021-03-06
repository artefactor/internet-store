package com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.superinc.europe.onlineshopping.gu.dao.exceptions.DaoException;
import com.superinc.europe.onlineshopping.gu.dao.jndi.DAOMaker;
import com.superinc.europe.onlineshopping.gu.dao.jndi.IDAOFactory;
import com.superinc.europe.onlineshopping.gu.dao.jndi.idao.IDAOOrders;
import com.superinc.europe.onlineshopping.gu.dao.orm.hibernate.IDaoOrders;
import com.superinc.europe.onlineshopping.gu.entity.Orders;

/**
 * Created by Alexey Druzik on 29.08.2016.
 */
@Repository("daoOrders")
@Scope("session")
public class DaoOrders implements IDaoOrders<Object> {

	/**
	 * Method insert Orsers to DB
	 * @param orders
	 * @throws DaoException
	 */
	@Override
	public void insertOrder(Orders orders) throws DaoException {
		IDAOFactory factory = new DAOMaker();
		IDAOOrders<Orders> daoOrders = factory.getDAOOrders();
		daoOrders.insert(orders);
	}

	/**
	 * Method get last insert Id
	 * @throws DaoException
	 */
	@Override
	public int getLastInsertId() throws DaoException {
		IDAOFactory factory = new DAOMaker();
		IDAOOrders<Orders> daoOrders = factory.getDAOOrders();
		return daoOrders.getLastInsertId();
	}
}
