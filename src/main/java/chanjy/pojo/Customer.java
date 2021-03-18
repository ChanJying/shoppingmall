package chanjy.pojo;

import com.baomidou.mybatisplus.annotation.*;

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
    @TableField("username")
    private String username;


    public Customer() {
    }

    public Customer(int id, String account, String password, String salt, Date registerDate, String img, String username) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.salt = salt;
        this.registerDate = registerDate;
        this.img = img;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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


}
