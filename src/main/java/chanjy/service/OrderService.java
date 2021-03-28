package chanjy.service;

import chanjy.pojo.Order;
import chanjy.vo.OrderVo;

import java.util.List;

public interface OrderService {

    int addOrder(Order order);

    List<Order> selectOrderByCustomerId(int customerId);

    List<OrderVo> selectOrderToOrderVo(int customerId);
}
