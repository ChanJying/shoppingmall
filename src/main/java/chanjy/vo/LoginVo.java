package chanjy.vo;

public class LoginVo {
    private String account;
    private String password;
    private String username;
    private String verifyCode;

    public LoginVo(String account, String password, String username, String verifyCode) {
        this.account = account;
        this.password = password;
        this.username = username;
        this.verifyCode = verifyCode;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    @Override
    public String toString() {
        return "LoginVo{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", verifyCode='" + verifyCode + '\'' +
                '}';
    }
}
