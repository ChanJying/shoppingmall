package chanjy.vo;

import java.util.Date;

public class OrderDetailVo {
    private int id;
    private int goodsId;
    private int customerId;
    private int goodsNums;
    private Date orderDate;
    private int orderState;
    private String orderId;
    private String goodsContent;
    private String goodsImg;
    private String goodsName;
    private String goodsPrice;

    public OrderDetailVo(int id, int goodsId, int customerId, int goodsNums, Date orderDate, int orderState, String orderId, String goodsContent, String goodsImg, String goodsName, String goodsPrice) {
        this.id = id;
        this.goodsId = goodsId;
        this.customerId = customerId;
        this.goodsNums = goodsNums;
        this.orderDate = orderDate;
        this.orderState = orderState;
        this.orderId = orderId;
        this.goodsContent = goodsContent;
        this.goodsImg = goodsImg;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }


    @Override
    public String toString() {
        return "OrderDetailVo{" +
                "id=" + id +
                ", goodsId=" + goodsId +
                ", customerId=" + customerId +
                ", goodsNums=" + goodsNums +
                ", orderDate=" + orderDate +
                ", orderState=" + orderState +
                ", orderId='" + orderId + '\'' +
                ", goodsContent='" + goodsContent + '\'' +
                ", goodsImg='" + goodsImg + '\'' +
                ", goodsName='" + goodsName + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getGoodsNums() {
        return goodsNums;
    }

    public void setGoodsNums(int goodsNums) {
        this.goodsNums = goodsNums;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getOrderState() {
        return orderState;
    }

    public void setOrderState(int orderState) {
        this.orderState = orderState;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getGoodsContent() {
        return goodsContent;
    }

    public void setGoodsContent(String goodsContent) {
        this.goodsContent = goodsContent;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public OrderDetailVo() {
    }

    public OrderDetailVo(int id, int goodsId, int customerId, int goodsNums, Date orderDate, int orderState, String orderId, String goodsContent, String goodsImg) {
        this.id = id;
        this.goodsId = goodsId;
        this.customerId = customerId;
        this.goodsNums = goodsNums;
        this.orderDate = orderDate;
        this.orderState = orderState;
        this.orderId = orderId;
        this.goodsContent = goodsContent;
        this.goodsImg = goodsImg;
    }
}
