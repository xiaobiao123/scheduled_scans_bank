/**
 * Project Name:bank.timer
 * File Name:OrderDao.java
 * Package Name:goujia.bank.dao
 * Date:2015年8月11日下午12:35:53
 * Copyright (c) 2015, chenzhou1025@126.com All Rights Reserved.
 *
*/

package goujia.bank.dao;

import goujia.bank.model.Order;

import java.util.List;

/**

 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public interface OrderDao {

	public boolean updateStatus( Order order);
	
	public List<Order> listOrder();
}

