package org.example.dataStructures;

public class BST<K extends Comparable<K>, V> {

    private Node root;

    private class Node {
        private K key;
        private V val;

        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }

    }

    public void put(K key, V val) {
        Node node = new Node(key, val);

        Node currentNode = this.root;
        if (root == null) {
            this.root = node;
        }
        while (true) {
            Node nodeToInsert = null;
            boolean isRight = false;

            if (currentNode.key.compareTo(node.key) < 0 || currentNode.key.equals(node.key)) {
                nodeToInsert = currentNode.right;
                isRight = true;
            } else {
                nodeToInsert = currentNode.left;
            }

            if (nodeToInsert == null) {
                if (isRight == true) {
                    currentNode.right = node;
                    return;
                }
                currentNode.left = node;
                return;
            } else {
                currentNode = nodeToInsert;
                continue;
            }

        }

    }

    public V get(K key) {
        Node currentNode = this.root;
        if (root == null) {
            return null;
        }
        while (true) {
            Node nodeToCheck = null;

            if (currentNode.key.equals(key)) {
                return currentNode.val;
            }

            if (currentNode.key.compareTo(key) < 0) {
                nodeToCheck = currentNode.right;
                // isRight = true;
            } else {
                nodeToCheck = currentNode.left;
            }

            currentNode = nodeToCheck;
            continue;

        }

        return null;
    }

    public void delete(K key) {
    }

    // private void find() {
    // }

    public void print() {
    }

    public Iterable<K> iterator() {
        return null;
    }

}
