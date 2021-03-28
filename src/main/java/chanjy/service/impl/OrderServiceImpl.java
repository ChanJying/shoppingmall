package chanjy.service.impl;

import chanjy.exception.GlobalException;
import chanjy.mapper.OrderMapper;
import chanjy.pojo.Order;
import chanjy.result.CodeMsg;
import chanjy.service.GoodsService;
import chanjy.service.OrderService;
import chanjy.vo.GoodsVo;
import chanjy.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private GoodsService goodsService;

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
}
