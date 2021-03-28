package chanjy.service.impl;

import chanjy.mapper.CartMapper;
import chanjy.pojo.Cart;
import chanjy.service.CartService;
import chanjy.vo.CartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartMapper cartMapper;

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
}
