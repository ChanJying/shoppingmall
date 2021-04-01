package chanjy.mapper;


import chanjy.pojo.Order;
import chanjy.vo.OrderDetailVo;
import chanjy.vo.OrderVo;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {

    int addOrder(Order order);

    List<Order> selectOrderByCustomerId(int customerId);

    List<OrderVo> selectOrderToOrderVo(int customerId);

    List<OrderDetailVo> selectOrderDetailByOrderId(String orderId);

    OrderVo selectOrderToOrderVoByOrderId(String orderId);

    int orderConfirmByOrderId(String orderId);

    int orderDeliveryByOrderId(String orderId);

    List<OrderDetailVo> selectAll();

    List<OrderDetailVo> selectAllByState(int orderState);


}
