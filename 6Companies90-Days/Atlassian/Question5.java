import java.util.HashMap;
import java.util.Map;

/*
 Question 5
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
Implement the LRUCache class: LRUCache(int capacity) Initialize the LRU cache with 
positive size capacity. int get(int key) Return the value of the key if the key exists,
otherwise return -1. void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.
 */
public class Question5 {
    class LRUCache {
        class Node {
            int key;
            int value;
            Node prev;
            Node next;

            public Node(int key, int value){
                this.key = key;
                this.value = value;
            }
        }
        
        private int capacity;
        private Map<Integer, Node> cache;
        private Node head;
        private Node tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.cache = new HashMap<>();
            this.head = new Node(0, 0);
            this.tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;

        }

        public int get(int key) {
            if (cache.containsKey(key)) {
                Node node = cache.get(key);
                moveToHead(node);
                return node.value;
            }
            return -1;
        }

        public void put(int key, int value) {

        }

        private void moveToHead(Node node){

        }

        private void addToHead(Node node){

        }

        private void removeNode(Node node){
            
        }
    }

}
