package chanjy.vo;

public class GoodsListVo {
    private Integer id;
    private String goodsName;
    private Double goodsPrice;
    private String goodsContent;
    private String goodsImg;
    private Integer goodsNums;
    private Integer sale;
    private String typeName;

    public GoodsListVo(Integer id, String goodsName, Double goodsPrice, String goodsContent, String goodsImg, Integer goodsNums, Integer sale, String typeName) {
        this.id = id;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.goodsContent = goodsContent;
        this.goodsImg = goodsImg;
        this.goodsNums = goodsNums;
        this.sale = sale;
        this.typeName = typeName;
    }

    public GoodsListVo() {
    }

    @Override
    public String toString() {
        return "GoodsListVo{" +
                "id=" + id +
                ", goodsName='" + goodsName + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", goodsContent='" + goodsContent + '\'' +
                ", goodsImg='" + goodsImg + '\'' +
                ", goodsNums=" + goodsNums +
                ", sale=" + sale +
                ", typeName='" + typeName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getGoodsNums() {
        return goodsNums;
    }

    public void setGoodsNums(Integer goodsNums) {
        this.goodsNums = goodsNums;
    }

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
