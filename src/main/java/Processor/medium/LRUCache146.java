package Processor.medium;

import java.util.HashMap;
import java.util.Map;

public class LRUCache146 {
    public static class LRUCache {
        static class ListNode {
            int value;
            int key;
            ListNode next;
            ListNode prev;

            ListNode() {
                this.value = -1;
                this.key = -1;
                this.next = null;
                this.prev = null;
            }

            ListNode(int key, int val) {
                this.key = key;
                this.value = val;
                this.next = null;
                this.prev = null;
            }
        }

        Map<Integer, ListNode> cache;
        ListNode head;
        ListNode tail;

        int capacity;
        int total;

        public LRUCache(int capacity) {
            this.cache = new HashMap<>();
            this.capacity = capacity;
            this.total = 0;
            this.head = new ListNode();
            this.tail = head;
        }

        public int get(int key) {
            ListNode node = cache.get(key);
            if (node == null)
                return -1;
            updateNode(node);
            return node.value;
        }

        public void put(int key, int value) {
            if (cache.containsKey(key)) {
                ListNode node = cache.get(key);
                node.value = value;
                updateNode(node);
            } else {
                insertNode(key, value);
            }
        }

        private void updateNode(ListNode node) {
            if (node.next != null) {
                //remove all linked
                node.prev.next = node.next;
                node.next.prev = node.prev;

                //link to tail
                node.prev = this.tail;
                node.next = null;

                //update tail
                this.tail.next = node;
                this.tail = node;
            }
        }

        private void insertNode(int key, int value) {
            ListNode newNode = new ListNode(key, value);
            newNode.prev = this.tail;
            this.tail.next = newNode;
            this.tail = this.tail.next;
            this.cache.put(key, newNode);
            total++;
            while (total > capacity ) {
                this.cache.remove(this.head.next.key);
                this.head.next = this.head.next.next;
                this.head.next.prev = this.head;
                total--;
            }
        }


    }

}
