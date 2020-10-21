package ru.job4j.collection.pro.list;

import org.junit.Test;

import static org.junit.Assert.*;

public class CheckerTest {

    @Test
    public void cycleFourtoFirst() {
        Node<Integer> first = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> four = new Node<>(4);
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;
        assertTrue(new Checker().hasCycle(first));
    }

    @Test
    public void cycleTwoToTwo() {
        Node<Integer> first = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        first.next = two;
        two.next = two;
        assertTrue(new Checker().hasCycle(first));
    }

    @Test
    public void cycleThreetoTwo() {
        Node<Integer> first = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> four = new Node<>(4);
        Node<Integer> five = new Node<>(5);
        first.next = two;
        two.next = third;
        third.next = two;
        four.next = five;
        assertTrue(new Checker().hasCycle(first));
    }

    @Test
    public void cycleOneToone() {
        Node<Integer> first = new Node<>(1);
        first.next = first;
        assertTrue(new Checker().hasCycle(first));
    }
}