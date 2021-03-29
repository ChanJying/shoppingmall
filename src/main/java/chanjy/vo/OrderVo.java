package chanjy.vo;

import java.util.Date;

public class OrderVo {
    private int customerId;
    private Date orderDate;
    private int orderState;
    private String orderId;

    public OrderVo(int customerId, Date orderDate, int orderState, String orderId) {
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.orderState = orderState;
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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

    public OrderVo() {
    }
}
