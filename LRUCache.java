/*

LRU CACHE

Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

*/

public class LRUCache {
    Node head, tail;
    int capacity, count;
    HashMap<Integer, Node> map;
    
    public LRUCache(int capacity) {
        count = 0;
        this.capacity = capacity;
        head = tail = null;
        map = new HashMap<Integer, Node>();
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            removeNode(node);
            addNewNode(node);
            return node.value;
        }
        return -1;
    }
    
    public void addNewNode(Node node) {
        if (count == 0) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = tail.next;
        }
        map.put(node.key, node);
        count++;
    }
    
    public void removeNode(Node node) {
        if (count == 1) {
            head = tail = null;
        } else {
            if (node == head) {
                head = head.next;
                head.prev = null;
            } else if (node == tail) {
                tail = tail.prev;
                tail.next = null;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
        }
        map.remove(node.key);
        count--;
    }
    
    public void set(int key, int value) {
        if (capacity <= 0)
            return;
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            removeNode(node);
            addNewNode(node);
        } else {
            if (count >= capacity)
                removeNode(head);
            Node node = new Node(key, value);
            addNewNode(node);
        }
    }
}

class Node {
    int key, value;
    Node prev, next;
    
    public Node (int key, int value) {
        this.key = key;
        this.value = value;
        prev = next = null;
    }
}