package chanjy.result;

public enum CodeMsg {
    //登录模块
    ACCOUNT_EXIST(200210,"用户名已存在");

    private int code;
    private String msg;

    CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
