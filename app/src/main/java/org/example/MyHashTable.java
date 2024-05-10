package org.example;

//NOTE: once table has passed its load factor- it has to rehash(create a new bigger table, and re-insert each element to the table)
public class MyHashTable<K, V> {

    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }

        // public K getKey(){
        // return this.key;
        // }
        // public V getValue(){
        // return this.value;
        // }
    }

    private HashNode<K, V>[] chainArray;
    private int M = 11;
    private int size;

    public MyHashTable() {
        chainArray = new HashNode[M];
        size = 0;
    }

    public MyHashTable(int M) {
        this.M = M;
        chainArray = new HashNode[];

        size = 0;
    }

    // TODO: Map key to integer i between 0 and m-1
    private int hash(K key) {
        if (key == null) {
            return 0;
        }
        int hash = key.hashCode() % M;

        return hash;
    }

    // TODO: Put at table index i if free, if not try i+1,i+2..
    public void put(K key, V value) {
        int index = hash(key);
        HashNode<K, V> newElem = new HashNode<K, V>(key, value);
        newElem.next = null;

        HashNode<K, V> head = chainArray[index];

        if (head == null) {
            chainArray[index] = newElem;
            return;
        }

        HashNode<K, V> chainElem = head;
        while (chainElem.next != null) {
            chainElem = chainElem.next;
        }

        chainElem.next = newElem;
    }

    public V get(K key) {
        int index = hash(key);
        HashNode<K, V> head = chainArray[index];

        while (head.next != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }

        return null;
    }

    public V remove(K key) {
        int index = hash(key);
        HashNode<K, V> head = chainArray[index];
        HashNode<K, V> prev = null;
        while (head != null) {
            if (head.key.equals(key)) {
                if (prev != null) {
                    prev.next = head.next;
                } else {
                    chainArray[index] = head.next;
                }
                size--;
                return head.value;
            }
            prev = head;
            head = head.next;
        }
        return null;
    }

    public boolean contains(V value) {
        return false;
    }

    public K getKey(V value) {
        return null;
    }

}
