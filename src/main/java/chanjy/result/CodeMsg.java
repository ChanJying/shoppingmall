package chanjy.result;

public enum CodeMsg {
    //通用异常
    SUCCESS(0,"success"),
    SERVER_ERROR(500100,"服务端异常"),

    //登录模块
    ACCOUNT_EXIST(500210,"用户已存在"),
    VERIFYCODE_ERROR(500211,"验证码不正确"),
    ACCOUNT_NOT_EXIST(500212,"用户不存在"),
    PASSWORD_MISTAKE(500213,"密码错误");




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

    @Override
    public String toString() {
        return "CodeMsg{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
