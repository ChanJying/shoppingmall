package chanjy.pojo;

public class Cart {
    private int cartId;
    private int customerId;
    private int goodsId;
    private int goodsNums;

    public Cart() {
    }

    public Cart(int cartId, int customerId, int goodsId, int goodsNums) {
        this.cartId = cartId;
        this.customerId = customerId;
        this.goodsId = goodsId;
        this.goodsNums = goodsNums;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public int getGoodsNums() {
        return goodsNums;
    }

    public void setGoodsNums(int goodsNums) {
        this.goodsNums = goodsNums;
    }
}
