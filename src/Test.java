/**
 * @author: 胖虎
 * @date: 2019/8/9 22:59
 **/
public class Test {

    public static void main(String[] args) {

        LRUCache<Integer, String> lruCache = new LRUCache<>();
        lruCache.put(1, "a");
        lruCache.put(2, "b");
        lruCache.put(3, "c");
        lruCache.get(1);
        lruCache.put(4, "d");
        System.out.println(lruCache.keySet());
        System.out.println(lruCache.values());
    }

}
