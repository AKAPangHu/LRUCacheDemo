import java.util.HashMap;

/**
 * 完美版
 * @author: 胖虎
 * @date: 2019/8/26 20:11
 **/
public class MyLRUCache {

    HashMap<String, DLinkedNode> cache =
            new HashMap<>();
    private int count;
    private int capacity;
    private DLinkedNode head, tail;

    MyLRUCache(int capacity){
        this.count = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        head.pre = null;
        tail = new DLinkedNode();
        tail.next = null;
        head.next = tail;
        tail.pre = head;
    }

    public int get(String key){
        DLinkedNode node = cache.get(key);
        if (node == null){
            return -1;
        }

        this.moveToTail(node);
        return node.val;
    }

    public void put(String key, int value){
        DLinkedNode node = cache.get(key);
        if (node != null){
            node.val = value;
            moveToTail(node);
        }
        else {
            node = new DLinkedNode();
            node.val = value;
            node.key = key;

            cache.put(key, node);
            addToTail(node);

            count++;
            //如果超出容量，移除队头数据
            if (count > capacity){
                DLinkedNode deleted = popHead();
                cache.remove(deleted.key);
                count--;
            }

        }

    }

    public void printList(){
        DLinkedNode position = head.next;
        while (position != tail){
            System.out.print("key : " + position.key +
                    " val :" + position.val + "\n");
            position = position.next;
        }
    }

    private DLinkedNode popHead() {
        DLinkedNode beDeleted = head.next;
        removeNode(beDeleted);
        return beDeleted;
    }


    private void moveToTail(DLinkedNode node) {
        this.removeNode(node);
        this.addToTail(node);
    }

    private void addToTail(DLinkedNode node) {
        DLinkedNode pre = tail.pre;
        node.pre = pre;
        pre.next = node;
        node.next = tail;
        tail.pre = node;
    }

    private void removeNode(DLinkedNode node) {
        DLinkedNode pre = node.pre;
        DLinkedNode next = node.next;

        pre.next = next;
        next.pre = pre;
    }



}
class DLinkedNode{

    String key;
    int val;
    DLinkedNode pre;
    DLinkedNode next;

}
