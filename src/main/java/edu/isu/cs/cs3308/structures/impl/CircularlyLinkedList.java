package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.List;
import edu.isu.cs.cs3308.structures.impl.Node;

public class CircularlyLinkedList<E> extends SinglyLinkedList<E> implements List<E> {

    private Node<E> tail;
    private int size = 0;

    SinglyLinkedList<E> singlyLinkedList = new SinglyLinkedList<E>();

    @Override
    public E first() {
        if(isEmpty() == true){
            return null;
        }else if(tail != null){
            return tail.getNext().getElement();
        }
        return null;
    }

    @Override
    public E last() {
        return singlyLinkedList.last();
    }

    @Override
    public void addLast(E element) {
        addFirst(element);
        tail = tail.getNext();

    }

    @Override
    public void addFirst(E element) {
        if(element == null) {
            return;
        }else{
            if(isEmpty() == true){
                Node<E> newNode = new Node<E>(element, null);
                tail = newNode;
                tail.setNext(tail);
            }else{
                Node<E> newNode = new Node<E>(element, tail.getNext());
                tail.setNext(newNode);
            }
            size++;
        }
    }

    @Override
    public E removeFirst() {
        if(isEmpty() == true){
            return null;
        }else{
            Node<E> toRemove = tail.getNext();
            if(size == 1 && tail != null){
                return tail.getElement();
            }else{
                tail.setNext(toRemove.getNext());
                toRemove.setNext(null);
                size--;
            }
            return toRemove.getElement();
        }
    }

    @Override
    public E removeLast() {
        return singlyLinkedList.removeLast();
    }

    @Override
    public void insert(E element, int index) {
        if(index < 0 || element == null){
            return;
        }else if(index >= size()){
            addLast(element);
            return;
        }else if(index == 0){
            addFirst(element);
            return;
        }
        Node<E> head = tail.getNext();
        Node<E> temp = head.getNext();
        for(int i = 0; i < index-1; i++){
            temp = temp.getNext();
        }
        Node<E> newNode = new Node<E>(element);
        newNode.setNext(temp.getNext());
        temp.setNext(newNode);
        size++;
    }

    @Override
    public E remove(int index) {
        if(index < 0 || index >= size || isEmpty() == true){
            return null;
        }
        Node<E> head = tail.getNext();
        Node<E> toRemove = head.getNext();
        for(int i = 0; i < index ; i ++){
            toRemove = toRemove.getNext();
        }
        toRemove.setNext(null);
        size--;
        return toRemove.getElement();
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size()) {
            return null;
        }else{
            Node<E> newNode = tail.getNext();
            for(int i = 0; i < index; i++){
                newNode = newNode.getNext();
            }
            return newNode.getElement();
        }
    }

    @Override
    public int size() {
        return singlyLinkedList.size();
    }

    @Override
    public boolean isEmpty() {
        return singlyLinkedList.isEmpty();
    }

    @Override
    public void printList() {
        singlyLinkedList.printList();

    }

    @Override
    public int indexOf(E item) {
        return 0;
    }
}
