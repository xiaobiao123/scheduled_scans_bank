/**
 * Copyright 2014-2015 goujia.com
 * All rights reserved.
 * 
 * @project
 * @author Flouny.Caesar
 * @version 1.0
 * @date 2014-06-13
 */
package goujia.bank.service;

import goujia.bank.model.Order;

import java.util.List;


/**
 * 订单 Service
 * @author caoqi
 *
 */
public interface OrderService {
	
	public boolean updateStatus(int orderId, String status);
	
	public List<Order> listOrder();
	
	
}
