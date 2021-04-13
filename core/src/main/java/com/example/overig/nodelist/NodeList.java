package com.example.overig.nodelist;

public class NodeList<T> {
    private Node<T> root = null;

    public NodeList() {
    }

    public void add(T value) {
        if(root == null) {
            root = new Node<>(value);
        } else {
            boolean inserted = false;
            int maxDepth = root.getHeight();
            for (int i = 0; i < maxDepth; i++) {

            }
        }
    }

    private static class Node<T> {
        private T value;
        private Node<T> leftChild;
        private Node<T> rightChild;

        public Node(T value) {
            this.value = value;
        }

        public int getSize() {
            int size = 1;
            size += leftChild != null ? leftChild.getSize() : 0;
            size += rightChild != null ? rightChild.getSize() : 0;
            return size;
        }

        public int getHeight() {
            if(isLeaf()) return 1;
            return leftChild.getHeight();
        }

        public boolean isFull() {
            return leftChild != null && rightChild != null;
        }

        public boolean isLeaf() {
            return leftChild == null && rightChild == null;
        }
    }
}
