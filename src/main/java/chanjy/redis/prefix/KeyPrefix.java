package chanjy.redis.prefix;

public interface KeyPrefix {
    int expireSeconds();
    String getPrefix();
}
