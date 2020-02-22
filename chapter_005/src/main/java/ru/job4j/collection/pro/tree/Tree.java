package ru.job4j.collection.pro.tree;

import java.util.*;

class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    private final Node<E> root;
    private boolean isBinary = true;

    Tree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean rsl = false;
        Optional<Node<E>> optionalParent;
        if (findBy(child).isPresent() || (optionalParent = findBy(parent)).isEmpty()) {
            return rsl;
        }
        optionalParent.get().children.add(new Node<>(child));
        rsl = true;
        return rsl;
    }

    public boolean isBinary() {
        recursion(root);
        return isBinary;
    }

    private void recursion(Node<E> node) {
        if (node.children.size() > 2) {
            isBinary = false;
            return;
        }
        for (Node<E> element : node.children) {
            recursion(element);
        }
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.value.equals(value)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }
}