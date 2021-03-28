package chanjy.service;

import chanjy.pojo.Cart;
import chanjy.vo.CartVo;

import java.util.List;

public interface CartService {
    List<CartVo> queryCartByCustomerId(int customerId);

    int addCart(Cart cart);

    int updateCart(Cart cart);

    Cart queryCartByCustomerIdGoodsId(Cart cart);

    int deleteCart(int cartId);

    int deleteCartByList(List<Integer> cartIds);
}
