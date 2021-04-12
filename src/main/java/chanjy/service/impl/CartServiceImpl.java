package chanjy.service.impl;

import chanjy.mapper.CartMapper;
import chanjy.pojo.Cart;
import chanjy.pojo.Customer;
import chanjy.pojo.Order;
import chanjy.service.CartService;
import chanjy.service.GoodsService;
import chanjy.service.OrderService;
import chanjy.util.Salt;
import chanjy.vo.CartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private OrderService orderService;

    @Autowired
    private GoodsService goodsService;

    @Override
    public List<CartVo> queryCartByCustomerId(int customerId) {
        return cartMapper.queryCartByCustomerId(customerId);
    }

    @Override
    public int addCart(Cart cart) {
        return cartMapper.addCart(cart);
    }

    @Override
    public int updateCart(Cart cart) {
        return cartMapper.updateCart(cart);
    }

    @Override
    public Cart queryCartByCustomerIdGoodsId(Cart cart) {
        return cartMapper.queryCartByCustomerIdGoodsId(cart);
    }

    @Override
    public int deleteCart(int cartId) {
        return cartMapper.deleteCart(cartId);
    }

    @Override
    public int deleteCartByList(List<Integer> cartIds) {
        return cartMapper.deleteCartByList(cartIds);
    }

    @Override
    @Transactional
    public int doBuy(Map<Integer,Integer> orderMap, int customerId) {
        Order order = new Order();
        order.setCustomerId(customerId);
        order.setOrderId(Salt.getOrderId());
        order.setOrderDate(new Date());
        for (Map.Entry<Integer, Integer> entry : orderMap.entrySet()) {
            order.setGoodsId(entry.getKey());
            order.setGoodsNums(entry.getValue());
            order.setOrderState(0);
            orderService.addOrder(order);
            goodsService.updateGoodsNums(entry.getKey(),entry.getValue());
        }
        return 1;
    }
}
