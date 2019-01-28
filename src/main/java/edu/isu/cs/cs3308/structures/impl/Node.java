package edu.isu.cs.cs3308.structures.impl;

import java.security.PublicKey;

public class Node<E> {
    private E element;
    private Node<E> next;

    public Node(E e, Node<E> n) {
        element = e;
        next = n;
    }

    public Node(E e) {
        element = e;
    }

    public Node(){};

    public E getElement() {
        return element;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> n) {
        next = n;
    }

    public void setElement(E e) {
        this.element = e;
    }


}
