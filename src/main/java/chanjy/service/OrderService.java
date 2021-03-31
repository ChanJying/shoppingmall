package chanjy.service;

import chanjy.pojo.Order;
import chanjy.vo.OrderDetailVo;
import chanjy.vo.OrderVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface OrderService {

    int addOrder(Order order);

    List<Order> selectOrderByCustomerId(int customerId);

    List<OrderVo> selectOrderToOrderVo(int customerId);

    List<OrderDetailVo> selectOrderDetailByOrderId(String orderId);

    OrderVo selectOrderToOrderVoByOrderId(String orderId);

    int orderConfirmByOrderId(String orderId);

    int orderDeliveryByOrderId(String orderId);

    List<OrderDetailVo> selectAll();

    PageInfo<OrderDetailVo> selectAllByPage(int pageNum, int pageSize);

    PageInfo<OrderDetailVo> selectAllByState(int orderState,int pageNum, int pageSize);
}
