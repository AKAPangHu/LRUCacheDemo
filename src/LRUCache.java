import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LinkedHashMap额外维护了一个双向链表，从而可以记住顺序
 * 我还绞尽脑汁地想链表如何哈希呢。。。
 * @author: 胖虎
 * @date: 2019/8/9 22:54
 **/
public class LRUCache<K, V> extends LinkedHashMap<K, V> {

    private static final int MAX_ENTRIES = 3;

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > MAX_ENTRIES;
    }

    LRUCache(){
        //accessOrder用于在每次get调用之后，将该节点移动到链表尾部
        super(MAX_ENTRIES, 0.75f, true);
    }
}
