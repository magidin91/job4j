package ru.job4j.collection.pro.tree;

import java.util.*;

class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

    Tree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean rsl = false;
        Optional<Node<E>> optionalParent = findBy(parent);
        if (optionalParent.isPresent()) {
            List<Node<E>> children = optionalParent.get().children;
            for (Node<E> node : children) {
                if (child == null && node.value == null || child != null && child.equals(node.value)) {
                    return rsl;
                }
            }
            Node<E> nodeChild = new Node<>(child);
            children.add(nodeChild);
            rsl = true;
        }
        return rsl;
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