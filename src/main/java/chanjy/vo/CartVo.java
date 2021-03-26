package chanjy.vo;


public class CartVo {
    private int cartId;
    private int customerId;
    private int goodsId;
    private int goodsNums;
    private String goodsImg;
    private String goodsContent;
    private String goodsPrice;

    @Override
    public String toString() {
        return "CartVo{" +
                "cartId=" + cartId +
                ", customerId=" + customerId +
                ", goodsId=" + goodsId +
                ", goodsNums=" + goodsNums +
                ", goodsImg='" + goodsImg + '\'' +
                ", goodsContent='" + goodsContent + '\'' +
                ", goodsPrice='" + goodsPrice + '\'' +
                '}';
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

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public String getGoodsContent() {
        return goodsContent;
    }

    public void setGoodsContent(String goodsContent) {
        this.goodsContent = goodsContent;
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public CartVo() {
    }

    public CartVo(int cartId, int customerId, int goodsId, int goodsNums, String goodsImg, String goodsContent, String goodsPrice) {
        this.cartId = cartId;
        this.customerId = customerId;
        this.goodsId = goodsId;
        this.goodsNums = goodsNums;
        this.goodsImg = goodsImg;
        this.goodsContent = goodsContent;
        this.goodsPrice = goodsPrice;
    }
}
