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
        if(linkedList.size()<2){
            return;
        }
        Node<T> first = linkedList.get(0);
        Node<T> second = linkedList.get(1);
        first.setNext(second);
        second.setPrev(first);

    }
    public void addLast(T t){
        Node<T> node  =new Node<>(t);
        linkedList.addLast(node);
        if(linkedList.size()<2){
            return;
        }
        Node<T> prev = linkedList.get(size()-2);
        Node<T> newNode = linkedList.get(size()-1);
        prev.setNext(newNode);
        newNode.setPrev(prev);
    }

    public T getFirst(){
        return (T)linkedList.getFirst().getData();
    }

    public T getLast(){
        return (T)linkedList.getLast().getData();
    }

    public T removeFirst(){
        T result= (T)linkedList.removeFirst();
        if(!linkedList.isEmpty()){
            linkedList.get(0).setPrev(null);
        }
        return result;
    }

    public T removeLast(){
        T result=  (T)linkedList.removeLast();
        if(!linkedList.isEmpty()){
            linkedList.getLast().setNext(null);
        }
        return result;
    }

    public T remove(int index){
        skipNode(index);
        return (T)linkedList.remove(index);
    }

    public void skipNode(int index){
        if(linkedList.size()<2){
            return;
        }
        if(index==0){
            Node<T> next = linkedList.get(index+1);
            next.setPrev(null);
            return;
        }
        if(index==linkedList.size()-1){
            Node<T> prev = linkedList.get(index-1);
            prev.setNext(null);
            return;
        }
        Node<T> prev = linkedList.get(index-1);
        Node<T> next = linkedList.get(index+1);
        prev.setNext(next);
        next.setPrev(prev);
    }

    public void printLinkedList(){
        System.out.println("PRINT LINKED LIST");
        for(int i=0;i<linkedList.size();i++){
            System.out.println(linkedList.get(i).getData() + " ");
        }
        System.out.println("----------------------------------------------------");
    }

    public void printLinkedListByPointers(){
        System.out.println("PRINT LINKED LIST BY POINTER");
        if(linkedList.isEmpty()){
            return;
        }
        Node current = linkedList.getFirst();
        while(current!=null){
            System.out.println(current.getData() + " ");
            current=current.getNext();
        }
        System.out.println("----------------------------------------------------");
    }



    public int size(){
        return linkedList.size();
    }


//    public static void main(String[] args) {
//        LinkedList<Integer> linkedList=new LinkedList<>();
//        linkedList.add(100);
//        linkedList.add(200);
//        linkedList.add(300);
//        Integer x = linkedList.remove(0);
//        System.out.println("x="+x);
//        System.out.println("");
//    }


    public static void main(String[] args) {

        DoubleLinkedList<Integer>  doubleLinkedList=new DoubleLinkedList<>();
        doubleLinkedList.addFirst(400);
        doubleLinkedList.addFirst(300);
        doubleLinkedList.addLast(500);
        doubleLinkedList.addLast(600);
        doubleLinkedList.addFirst(200);
        doubleLinkedList.addFirst(100);
        doubleLinkedList.addLast(700);

        doubleLinkedList.remove(6);
        doubleLinkedList.remove(5);
        doubleLinkedList.remove(4);
        doubleLinkedList.remove(3);
        doubleLinkedList.remove(2);
        doubleLinkedList.remove(1);
       doubleLinkedList.remove(0);



        doubleLinkedList.printLinkedList();
        doubleLinkedList.printLinkedListByPointers();

    }



}
