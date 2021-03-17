package chanjy.pojo;

import com.baomidou.mybatisplus.annotation.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

public class Customer {
    @TableId(value = "id",type = IdType.AUTO)
    private int id;
    @TableField("account")
    private String account;
    @TableField("password")
    private String password;
    @TableField("salt")
    private String salt;
    @TableField("registerDate")
    private Date registerDate;
    @TableField("img")
    private String img;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    @TableLogic
    private Integer deleted;

    public Customer() {
    }

    public Customer(int id, String account, String password, String salt, Date registerDate, String img, Date createTime, Date updateTime, Integer deleted) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.salt = salt;
        this.registerDate = registerDate;
        this.img = img;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.deleted = deleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
}
