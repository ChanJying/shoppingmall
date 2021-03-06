package chanjy.result;

public enum CodeMsg {
    //通用异常
    SUCCESS(0,"success"),
    SERVER_ERROR(500100,"服务端异常"),
    BUY_ERROR(500101,"购买失败"),

    //登录模块
    ACCOUNT_EXIST(500210,"用户已存在"),
    VERIFYCODE_ERROR(500211,"验证码不正确"),
    ACCOUNT_NOT_EXIST(500212,"用户不存在"),
    PASSWORD_MISTAKE(500213,"密码错误"),
    ADMIN_NOT_EXIST(500220,"验证错误"),

    //商品模块
    GOODSNUMS_NOT_ENOUGH(500310,"库存不足"),
    TYPE_HAS_GOODS(500311,"该类别下有商品"),

    //用户模块
    ADDRESS_NOT_EXIST(500410,"请前往个人中心填写地址"),

    //收藏模块
    COLLECT_EXIST(500510,"该商品已收藏"),
    COLLECT_NOT_EXIST(500510,"该商品未收藏");


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
