package com.yotal.doublelinkedlist;
import java.util.LinkedList;

public class DoubleLinkedList<T> {

    private LinkedList<Node> linkedList;

    public DoubleLinkedList() {
        this.linkedList = new LinkedList<>();
    }





    public void addFirst(T t){
        Node<T> node  =new Node<>(t);
        linkedList.addFirst(node);
    }
    public void addLast(T t){
        Node<T> node  =new Node<>(t);
        linkedList.addLast(node);
    }

    public T getFirst(){
        return (T)linkedList.getFirst().getData();
    }

    public T getLast(){
        return (T)linkedList.getLast().getData();
    }


    public T removeFirst(){
        return (T)linkedList.removeFirst();
    }

    public T removeLast(){
        return (T)linkedList.removeLast();
    }

    public T remove(int index){
        return (T)linkedList.remove(index);
    }

    public void printLinkedList(){
        for(int i=0;i<linkedList.size();i++){
            System.out.println(linkedList.get(i) + " ");
        }
        System.out.println("----------------------------------------------------");
    }



    public void printLinkedListByPointers(){
        Node current = linkedList.getFirst();
        while(current!=null){
            System.out.println(current + " ");
            current=current.getNext();
        }
        System.out.println("----------------------------------------------------");
    }







    public int size(){
        return linkedList.size();
    }


    public static void main(String[] args) {
        LinkedList<Integer> linkedList=new LinkedList<>();
        linkedList.add(100);
        linkedList.add(200);
        linkedList.add(300);
        Integer x = linkedList.remove(0);
        System.out.println("x="+x);
        System.out.println("");
    }




}
