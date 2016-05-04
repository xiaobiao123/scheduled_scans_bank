/**
 * Project Name:bank.timer
 * File Name:OrderServiceImpl.java
 * Package Name:goujia.bank.service.impl
 * Date:2015年8月11日下午12:33:25
 * Copyright (c) 2015, chenzhou1025@126.com All Rights Reserved.
 *
*/

package goujia.bank.service.impl;

import goujia.bank.dao.OrderDao;
import goujia.bank.model.Order;
import goujia.bank.service.OrderService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @see 	 
 */
@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderDao orderDao;
	@Override
    public boolean updateStatus(int orderId, String status) {
	    Order order=new Order();
	    order.setId(orderId);
	    order.setStatus(status);
	    return orderDao.updateStatus(order);
    }

	@Override
    public List<Order> listOrder() {
	    
	    return orderDao.listOrder();
    }

}

