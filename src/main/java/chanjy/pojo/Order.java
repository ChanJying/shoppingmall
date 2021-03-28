package chanjy.pojo;

import java.util.Date;

public class Order {
    private int id;
    private int goodsId;
    private int customerId;
    private int goodsNums;
    private Date orderDate;
    private int orderState;
    private String orderId;

    public Order() {
    }

    public Order(int id, int goodsId, int customerId, int goodsNums, Date orderDate, int orderState, String orderId) {
        this.id = id;
        this.goodsId = goodsId;
        this.customerId = customerId;
        this.goodsNums = goodsNums;
        this.orderDate = orderDate;
        this.orderState = orderState;
        this.orderId = orderId;
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
}
