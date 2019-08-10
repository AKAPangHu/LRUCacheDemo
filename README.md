# LRUCacheDemo
用LinkedHashMap实现的简单LRU（最近最久未使用）缓存，要点是LinkedHashMap自带的：

1.**removeEldestEntry**方法，重写该方法，定义在什么时候一处最久未使用的entry

2.**accessOrder**参数，在构造方法里，将这个参数置为true，从而实现每一次都将最新使用或插入的entry移到链表最后。
