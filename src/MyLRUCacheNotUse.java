import java.util.*;

/**
 * 该版本的时间复杂度为O（N），太高
 * 已舍弃。。
 * @author: 胖虎
 * @date: 2019/8/24 22:48
 **/
public class MyLRUCacheNotUse<T, U> {

    private HashMap<T, U> map;
    private Deque<T> deque;
    private final int capacity;

    MyLRUCacheNotUse(int capacity) {
        deque = new LinkedList<T>();
        map = new HashMap<T, U>(capacity);
        this.capacity = capacity;
    }

    public U get(T key) {

        //将队列中的该值移除，若未找到，不做更改
        boolean exist = deque.removeFirstOccurrence(key);
        //插入队尾
        if (exist) {
            deque.addLast(key);
        }
        return (U) map.get(key);
    }

    public U put(T key, U value) {
        boolean exist = map.containsValue(key);
        if (exist){
            map.put(key, value);
            deque.removeFirstOccurrence(key);
            deque.addLast(key);
        }
        else{
            //如果超出容量，从队列和map中都移除最近最久未使用的值
            if (map.size() >= capacity){
                T first = deque.removeFirst();
                map.remove(first);
            }
            map.put(key, value);
            deque.addLast(key);
        }
        return value;
    }

    public Set<T> keySet(){
        return map.keySet();
    }

    public Collection<U> values(){
        return map.values();
    }

    public void printDeque(){
        System.out.println(deque);
    }

}
