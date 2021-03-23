package chanjy.vo;

public class GoodsVo {
    private Integer id;
    private String goodsName;
    private Double goodsPrice;
    private String goodsContent;
    private String goodsImg;
    private Integer goodsNums;

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

    public GoodsVo() {
    }

    public GoodsVo(Integer id, String goodsName, Double goodsPrice, String goodsContent, String goodsImg, Integer goodsNums) {
        this.id = id;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.goodsContent = goodsContent;
        this.goodsImg = goodsImg;
        this.goodsNums = goodsNums;
    }
}
