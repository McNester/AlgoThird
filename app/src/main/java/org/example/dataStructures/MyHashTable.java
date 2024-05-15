package org.example.dataStructures;

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
    }

    private HashNode<K, V>[] chainArray;
    private int M = 11;
    private int size;

    public int getM() {
        return M;
    }

    public int getSize() {
        return size;
    }

    public MyHashTable() {
        chainArray = new HashNode[M];
        size = 0;
    }

    public MyHashTable(int M) {
        this.M = M;
        chainArray = new HashNode[M];

        size = 0;
    }

    private int hash(K key) {
        if (key == null) {
            return 0;
        }
        int hash = Math.abs(key.hashCode() % M);

        return hash;
    }

    private double getLoadFactor() {
        return (double) size / (double) M;
    }

    private void rehash() {
        M *= M;
        HashNode<K, V>[] biggerChainArray = new HashNode[M];

        for (int i = 0; i < chainArray.length; i++) {
            if (chainArray[i] != null) {
                biggerChainArray[i] = chainArray[i];
            }
        }

        chainArray = biggerChainArray;
    }

    public int getBucketSize(int index) {
        HashNode<K, V> head = chainArray[index];
        if (head == null) {
            return 0;
        }

        int bucketSize = 1;

        if (head.next == null) {
            return bucketSize;
        }

        while (head.next != null) {
            bucketSize++;
            head = head.next;
        }

        return bucketSize;

    }

    // TODO: Put at table index i if free, if not try i+1,i+2..
    public void put(K key, V value) {
        double loadFactor = getLoadFactor();
        if (loadFactor > 0.75) {
            rehash();
        }
        int index = hash(key);
        HashNode<K, V> newElem = new HashNode<K, V>(key, value);
        newElem.next = null;

        HashNode<K, V> head = chainArray[index];

        if (head == null) {
            chainArray[index] = newElem;
            size++;
            return;
        }

        HashNode<K, V> chainElem = head;
        while (chainElem.next != null) {
            chainElem = chainElem.next;
        }

        chainElem.next = newElem;
        size++;
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
        HashNode<K, V> head = chainArray[0];
        for (int i = 1; i < chainArray.length; i++) {
            if (value.equals(head.value)) {
                return true;
            }

            while (head.next != null) {
                if (value.equals(head.value)) {
                    return true;
                }
                head = head.next;
            }

            head = chainArray[i];
        }
        return false;
    }

    public K getKey(V value) {
        HashNode<K, V> head = chainArray[0];
        for (int i = 1; i < chainArray.length; i++) {
            if (value.equals(head.value)) {
                return head.key;
            }

            while (head.next != null) {
                if (value.equals(head.value)) {
                    return head.key;
                }
                head = head.next;
            }

            head = chainArray[i];
        }
        return null;
    }

}
