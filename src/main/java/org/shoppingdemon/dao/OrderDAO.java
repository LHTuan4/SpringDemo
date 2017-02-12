package org.shoppingdemon.dao;

import java.util.List;

import org.shoppingdemon.model.CartInfo;
import org.shoppingdemon.model.OrderDetailInfo;
import org.shoppingdemon.model.OrderInfo;
import org.shoppingdemon.model.PaginationResult;

public interface OrderDAO {
	 
    public void saveOrder(CartInfo cartInfo);
 
    public PaginationResult<OrderInfo> listOrderInfo(int page,
            int maxResult, int maxNavigationPage);
    
    public OrderInfo getOrderInfo(String orderId);
    
    public List<OrderDetailInfo> listOrderDetailInfos(String orderId);
 
}