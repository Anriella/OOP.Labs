import GameRoom.*;

import java.util.ArrayList;

public class lab7 {
    public static void main(String[] args) {
        GameRoom gr = new GameRoom("GameRoom");
        Set<Integer, String> set = new Set<Integer, String>(gr.n);

        for (int i=0;i<gr.n;i++){
            set.put(i, gr.toy_eq[i], String.valueOf(gr.price_eq[i]), String.valueOf(gr.tip_eq[i]));
        }

        System.out.println(gr.i);
        String toy="";
        String price="";
        for (int i=0;i<gr.n;i++){
            toy += set.getToy(i)+"; ";
            price += set.getPrice(i)+"; ";
        }

        System.out.println("Игрушки: " + toy);
        System.out.println("Цены: " + price);

        System.out.println("Категория возраста: \n" + " 1: от 2 до 4 лет\n" + " 2: от 5 до 6 лет\n" + " 3: от 7 до 9 лет\n");

        set.print();

    }
}

class Set<K, V> {

    private static class LinkedListNode<K, V> {
        public LinkedListNode<K, V> next;
        public LinkedListNode<K, V> prev;
        public K key;
        public V value, value1, value2;

        public LinkedListNode() {
            key = null;
            value = null;
            value1 = null;
            value2 = null;
        }

        public LinkedListNode(K k, V v, V v1, V v2) {
            key = k;
            value = v;
            value1 = v1;
            value2 = v2;
        }

        public LinkedListNode(K k, V v, V v1) {
            key = k;
            value = v;
            value1 = v1;
        }

        public LinkedListNode(K k, V v) {
            key = k;
            value = v;
        }

        public LinkedListNode(K k) {
            key = k;
        }

        public String printForward() {
            String data = "(" + value + " Цена: " + value1 + " Категория: " + value2 + ")";
            if (next != null) {
                return data + "->" + next.printForward();
            } else {
                return data;
            }
        }
    }

    private ArrayList<LinkedListNode<K, V>> arr;
    public Set(int capacity) {

        arr = new ArrayList<LinkedListNode<K, V>>();
        arr.ensureCapacity(capacity);
        for (int i = 0; i < capacity; i++) {
            arr.add(null);
        }
    }

    public V put(K key, V value, V value1, V value2) {
        LinkedListNode<K, V> node = getNodeForKey(key);
        if (node != null) {
            V oldValue = node.value;
            node.value = value;
            return oldValue;
        }
        node = new LinkedListNode<K, V>(key, value, value1, value2);
        int index = getIndexForKey(key);
        if (arr.get(index) != null) {
            node.next = arr.get(index);
            node.next.prev = node;
        }
        arr.set(index, node);
        return null;
    }

    public V put(K key, V value, V value1) {
        LinkedListNode<K, V> node = getNodeForKey(key);
        if (node != null) {
            V oldValue = node.value;
            node.value = value;
            return oldValue;
        }
        node = new LinkedListNode<K, V>(key, value, value1);
        int index = getIndexForKey(key);
        if (arr.get(index) != null) {
            node.next = arr.get(index);
            node.next.prev = node;
        }
        arr.set(index, node);
        return null;
    }

    public V put(K key, V value) {
        LinkedListNode<K, V> node = getNodeForKey(key);
        if (node != null) {
            V oldValue = node.value;
            node.value = value;
            return oldValue;
        }
        node = new LinkedListNode<K, V>(key, value);
        int index = getIndexForKey(key);
        if (arr.get(index) != null) {
            node.next = arr.get(index);
            node.next.prev = node;
        }
        arr.set(index, node);
        return null;
    }

    public V put(K key) {
        LinkedListNode<K, V> node = getNodeForKey(key);
        if (node != null) {
            V oldValue = node.value;
            node.value = null;
            return oldValue;
        }
        node = new LinkedListNode<K, V>(key);
        int index = getIndexForKey(key);
        if (arr.get(index) != null) {
            node.next = arr.get(index);
            node.next.prev = node;
        }
        arr.set(index, node);
        return null;
    }

    public V put() {
        return null;
    }

    public V remove(K key) {
        LinkedListNode<K, V> node = getNodeForKey(key);
        if (node == null) {
            return null;
        }

        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            int hashKey = getIndexForKey(key);
            arr.set(hashKey, node.next);
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        }
        return node.value;
    }

    public V getToy(K key) {
        if (key == null) return null;
        LinkedListNode<K, V> node = getNodeForKey(key);
        return node == null ? null : node.value;
    }

    public V getPrice(K key) {
        if (key == null) return null;
        LinkedListNode<K, V> node = getNodeForKey(key);
        return node == null ? null : node.value1;
    }

    public V getTip(K key) {
        if (key == null) return null;
        LinkedListNode<K, V> node = getNodeForKey(key);
        return node == null ? null : node.value2;
    }

    private LinkedListNode<K, V> getNodeForKey(K key) {
        int index = getIndexForKey(key);
        LinkedListNode<K, V> current = arr.get(index);
        while (current != null) {
            if (current.key == key) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public int getIndexForKey(K key) {
        return Math.abs(key.hashCode() % arr.size());
    }

    public void print() {
        for (int i = 0; i < arr.size(); i++) {
            String s = arr.get(i) == null ? "" : arr.get(i).printForward();
            System.out.println(i + ": " + s);
        }
    }
}