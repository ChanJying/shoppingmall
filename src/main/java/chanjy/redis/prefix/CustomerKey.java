package chanjy.redis.prefix;

public class CustomerKey extends BasePrefix{

    public static final int TOKEN_EXPIRE=3600*24*3;

    public CustomerKey(int expireSeconds, String prefix) {
        super(expireSeconds,prefix);
    }

    public static CustomerKey getById = new CustomerKey(0,"id");
    public static CustomerKey getByAccount = new CustomerKey(0,"account");
    public static CustomerKey token = new CustomerKey(TOKEN_EXPIRE,"tk");

}
