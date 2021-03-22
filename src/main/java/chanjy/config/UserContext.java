package chanjy.config;

import chanjy.pojo.Customer;

public class UserContext {
    private static ThreadLocal<Customer> userHolder = new ThreadLocal<Customer>();

    public static void setUser(Customer user) {
        userHolder.set(user);
    }

    public static Customer getUser() {
        return userHolder.get();
    }

}
