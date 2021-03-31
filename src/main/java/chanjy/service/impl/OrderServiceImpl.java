package chanjy.service.impl;

import chanjy.exception.GlobalException;
import chanjy.mapper.OrderMapper;
import chanjy.pojo.Order;
import chanjy.result.CodeMsg;
import chanjy.service.GoodsService;
import chanjy.service.OrderService;
import chanjy.vo.GoodsVo;
import chanjy.vo.OrderDetailVo;
import chanjy.vo.OrderVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private GoodsService goodsService;

    @Override
    public List<OrderDetailVo> selectOrderDetailByOrderId(String orderId) {
        return orderMapper.selectOrderDetailByOrderId(orderId);
    }

    @Override
    public int orderConfirmByOrderId(String orderId) {
        return orderMapper.orderConfirmByOrderId(orderId);
    }

    @Override
    public List<OrderDetailVo> selectAll() {
        return orderMapper.selectAll();
    }

    @Override
    public PageInfo<OrderDetailVo> selectAllByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<OrderDetailVo> orderDetailVos = orderMapper.selectAll();
        PageInfo<OrderDetailVo> pageInfo = new PageInfo<>(orderDetailVos);
        return pageInfo;
    }

    @Override
    public int orderDeliveryByOrderId(String orderId) {
        return orderMapper.orderDeliveryByOrderId(orderId);
    }

    @Override
    public PageInfo<OrderDetailVo> selectAllByState(int orderState, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<OrderDetailVo> orderDetailVos = orderMapper.selectAllByState(orderState);
        PageInfo<OrderDetailVo> pageInfo = new PageInfo<>(orderDetailVos);
        return pageInfo;
    }

    @Override
    public List<OrderVo> selectOrderToOrderVo(int customerId) {
        return orderMapper.selectOrderToOrderVo(customerId);
    }

    @Override
    public int addOrder(Order order) {
        GoodsVo goodsVo = goodsService.queryGoodsById(order.getGoodsId());
        if(goodsVo.getGoodsNums()<order.getGoodsNums()) throw new GlobalException(CodeMsg.GOODSNUMS_NOT_ENOUGH);
        return orderMapper.addOrder(order);
    }

    @Override
    public List<Order> selectOrderByCustomerId(int customerId) {
        return orderMapper.selectOrderByCustomerId(customerId);
    }

    @Override
    public OrderVo selectOrderToOrderVoByOrderId(String orderId) {
        return orderMapper.selectOrderToOrderVoByOrderId(orderId);
    }
}
