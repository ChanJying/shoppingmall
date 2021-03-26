package chanjy.mapper;


import chanjy.pojo.Cart;
import chanjy.vo.CartVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartMapper {

    List<CartVo> queryCartByCustomerId(int customerId);

    int addCart(Cart cart);

    int updateCart(Cart cart);

    Cart queryCartByCustomerIdGoodsId(Cart cart);

    int deleteCart(int cartId);
}
