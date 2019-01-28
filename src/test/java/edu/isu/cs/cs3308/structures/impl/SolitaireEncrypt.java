package edu.isu.cs.cs3308.structures.impl;
import java.util.*;
import edu.isu.cs.cs3308.structures.impl.CircularlyLinkedList;
import edu.isu.cs.cs3308.structures.impl.Node;

public class SolitaireEncrypt<E> extends CircularlyLinkedList<E>{

    CircularlyLinkedList<E> cir = new CircularlyLinkedList<E>();
    Node<E> deckTail;

    public void makeDeck(){
        int[] card = new int[28];
        for(int i = 1; i < card.length + 1; i++){
            card[i] = i;
        }

        //shuffle
        Random random = new Random();
        for(int i = 0; i < card.length; i++){
            int shuffledNum = random.nextInt(28);
            int temp = card[shuffledNum];
            card[shuffledNum] = card[i];
            card[i] = temp;
            System.out.println(card[0] + card[1]);
        }

        //CLL cards
        Node deckHead = new Node();
        deckHead.setElement(card[0]);
        deckHead.setNext(deckHead);
        deckTail = deckHead;
        for(int i = 1; i < card.length; i++){
            deckHead.setElement(card[i]);
            E num = (E) deckHead.getElement();
            cir.insert(num,i);
        }

    }
    //Joker num 27 and move down joker position
    void jokerA(){
        if(deckTail == null){
            return;
        }else{
            Node<E> card = deckTail;
            while ((int)card.getElement() != 27){
                card = card.getNext();
            }
            E findJoker = card.getElement();
            card.setElement(card.getNext().getElement());
            card.getNext().setElement(findJoker);
        }
        return;
    }

    //Joker num 28 and move down joker position 2 times
    void JokerB(){
        if(deckTail == null){
            return;
        }else{
            Node<E> card = deckTail;
            while ((int)card.getElement() != 28){
                card = card.getNext();
            }
            for(int i = 0; i < 2; i++){
                E findJoker = card.getElement();
                card.setElement(card.getNext().getElement());
                card.getNext().setElement(findJoker);
                card = card.getNext();
            }
        }
    }
    void tripleCut(){
        Node<E> head = deckTail.getNext();
        Node<E> tail = deckTail;
        if((int)head.getElement() == 27);
    }

}
