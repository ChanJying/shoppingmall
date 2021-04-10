package chanjy.vo;

public class CollectVo {
    private int id;
    private int customerId;
    private int goodsId;
    private String goodsContent;
    private String goodsName;
    private Double goodsPrice;
    private String goodsImg;

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

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsContent() {
        return goodsContent;
    }

    public void setGoodsContent(String goodsContent) {
        this.goodsContent = goodsContent;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public CollectVo() {
    }

    public CollectVo(int id, int customerId, int goodsId, String goodsContent, String goodsName, Double goodsPrice, String goodsImg) {
        this.id = id;
        this.customerId = customerId;
        this.goodsId = goodsId;
        this.goodsContent = goodsContent;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.goodsImg = goodsImg;
    }

    @Override
    public String toString() {
        return "CollectVo{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", goodsId=" + goodsId +
                ", goodsContent='" + goodsContent + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", goodsImg='" + goodsImg + '\'' +
                '}';
    }
}
