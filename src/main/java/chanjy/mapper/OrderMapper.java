package chanjy.mapper;


import chanjy.pojo.Order;
import chanjy.vo.OrderVo;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {

    int addOrder(Order order);

    List<Order> selectOrderByCustomerId(int customerId);

    List<OrderVo> selectOrderToOrderVo(int customerId);
}
