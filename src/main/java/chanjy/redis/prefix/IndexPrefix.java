package chanjy.redis.prefix;

public class IndexPrefix extends BasePrefix {

    public static final int INDEX_EXPIRE=3600*24;

    public static IndexPrefix getIndex = new IndexPrefix(INDEX_EXPIRE,"index");


    public IndexPrefix(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }
}
