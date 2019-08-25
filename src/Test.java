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
        System.out.println(lruCache.put(4, "d"));
        System.out.println(lruCache.keySet());
        System.out.println(lruCache.values());


        MyLRUCacheNotUse<Integer, String> myLRUCache = new MyLRUCacheNotUse<>(3);
        myLRUCache.put(1, "a");
        myLRUCache.put(2, "b");
        myLRUCache.put(3, "c");
        myLRUCache.get(1);
        System.out.println(myLRUCache.put(4, "d"));
        System.out.println(myLRUCache.keySet());
        System.out.println(myLRUCache.values());
        myLRUCache.printDeque();






    }

}
