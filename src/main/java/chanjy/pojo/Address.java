package chanjy.pojo;

public class Address {
    private int id;
    private int customerId;
    private String consignee;
    private String address;
    private String phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address() {
    }

    public Address(int id, int customerId, String consignee, String address, String phone) {
        this.id = id;
        this.customerId = customerId;
        this.consignee = consignee;
        this.address = address;
        this.phone = phone;
    }
}
