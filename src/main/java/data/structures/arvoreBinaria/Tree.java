package data.structures.arvoreBinaria;

import java.util.LinkedList;

public class Tree {

    private int data;
    private Tree right;
    private Tree left;

    public Tree(int data) {
        this.data = data;
    }

    public void insert(int data) {
        insert(this, data);
    }

    private void insert(Tree tree, int data) {
        if (data > tree.data) {
            if (tree.right == null) {
                tree.right = new Tree(data);
            } else {
                insert(tree.right, data);
            }
        } else {
            if (tree.left == null) {
                tree.left = new Tree(data);
            } else {
                insert(tree.left, data);
            }
        }
    }

    public boolean exists(int dada) {
        return false;
    }

    public Tree retrieve(int data) {
        return null;
    }

    public void preOrder() {
        preOrder(this);
    }

    private void preOrder(Tree tree) {
        if (tree != null) {
            System.out.println(tree.data);
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    public void inOrder() {
        inOrder(this);
    }

    private void inOrder(Tree tree) {
        if (tree != null) {
            inOrder(tree.left);
            System.out.println(tree.data);
            inOrder(tree.right);
        }
    }

    public void postOrder() {
        postOrder(this);
    }

    private void postOrder(Tree tree) {
        if (tree != null) {
            postOrder(tree.left);
            postOrder(tree.right);
            System.out.println(tree.data);
        }
    }

    public void bfs() {
        LinkedList<Tree> queue = new LinkedList<>();

        queue.addFirst(this);

        while(!queue.isEmpty()) {
            var node = queue.getFirst();

            if (node.left != null) queue.addLast(node.left);
            if (node.right != null) queue.addLast(node.right);

            System.out.println(node.data);

            queue.removeFirst();
        }
    }

    public static void main(String[] args) {
        var tree = new Tree(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);
        tree.insert(15);
        tree.insert(25);
        tree.insert(35);
        tree.insert(45);
        tree.insert(36);
        System.out.println("Pre Order");
        tree.preOrder();
        System.out.println("In Order");
        tree.inOrder();
        System.out.println("Post Order");
        tree.postOrder();
        System.out.println("Breadth-First Search");
        tree.bfs();
    }

}
