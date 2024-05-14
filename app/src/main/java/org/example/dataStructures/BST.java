package org.example.dataStructures;

import java.util.ArrayList;

public class BST<K extends Comparable<K>, V> {

    private Node root = null;
    private int size = 0;

    private class Node {
        private K key;
        private V val;

        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }

    }

    public class KeyValuePair<K, V> {
        private K key;
        private V value;

        public KeyValuePair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "\n{" + key + ": " + value + "}";
        }
    }

    public void put(K key, V val) {
        Node node = new Node(key, val);

        Node currentNode = this.root;
        if (root == null) {
            this.root = node;
            size++;
            return;
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
                    size++;
                    return;
                }
                currentNode.left = node;
                size++;
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
            } else {
                nodeToCheck = currentNode.left;
            }

            if (nodeToCheck == null) {
                return null;
            } else {
                currentNode = nodeToCheck;
                continue;
            }
        }
    }

    private Node findMaxOnLeft(Node parent) {
        Node current = parent.left;

        while (current.right != null) {
            current = current.right;
        }

        return current;
    }

    private Node findNext(Node deleteNode) {
        if (deleteNode == null || deleteNode.left == null && deleteNode.right == null) {
            return null;
        }

        if (deleteNode.left == null) {
            return deleteNode.right;
        }

        if (deleteNode.right == null) {
            return deleteNode.left;
        }

        return findMaxOnLeft(deleteNode);
    }

    private boolean hasTwoChildren(Node node) {
        if (node.left != null && node.right != null) {
            return true;
        }
        return false;
    }

    public void delete(K key) {
        if (root.key.equals(key)) {
            root = findNext(root);
        }
        Node currentNode = this.root;
        Node parentNode = this.root;

        boolean isRight = false;

        if (root == null) {
            return;
        }
        while (true) {
            Node nodeToCheck = null;

            if (currentNode.key.equals(key)) {
                if (hasTwoChildren(currentNode) == true) {
                    Node substituteNode = findNext(currentNode);
                    currentNode.val = substituteNode.val;
                    currentNode.key = substituteNode.key;
                }
                if (isRight == true) {
                    parentNode.right = findNext(currentNode);
                    size--;
                    return;
                }
                parentNode.left = findNext(currentNode);
                size--;
                return;
            }

            if (currentNode.key.compareTo(key) < 0) {
                nodeToCheck = currentNode.right;
                isRight = true;
            } else {
                nodeToCheck = currentNode.left;
                isRight = false;
            }

            if (nodeToCheck == null) {
                return;
            } else {
                parentNode = currentNode;
                currentNode = nodeToCheck;
                continue;
            }
        }
    }

    private void inOrderTraversal(Node node, ArrayList<KeyValuePair<K, V>> list) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left, list);
        list.add(new KeyValuePair<>(node.key, node.val));
        inOrderTraversal(node.right, list);
    }

    public Iterable<KeyValuePair<K, V>> iterator() {
        ArrayList<KeyValuePair<K, V>> list = new ArrayList<>();
        inOrderTraversal(root, list);

        return list;
    }

    public int size() {
        return size;
    }

}
