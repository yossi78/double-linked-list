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
        disconnectNode(index);
        return (T)linkedList.remove(index);
    }



    public Node<T> moveNodeBackward(Node<T> target){
        int index = linkedList.indexOf(target);
        Node<T> resultNode = moveNodeBackward(index);
        return resultNode;
    }

    public Node<T> moveNodeBackward(int index){
        Node<T> prev = getNodeSafly(index-1);
        Node<T> target = getNodeSafly(index);
        Node<T> next = getNodeSafly(index+1);
        Node<T> prevPrev = getNodeSafly(index-2);
        if(linkedList.size()<2 || target==null || index==0){
            return null;
        }
        if(prevPrev!=null){
            prevPrev.setNext(target);
        }
        target.setPrev(prevPrev);
        target.setNext(prev);
        prev.setPrev(target);
        prev.setNext(next);
        if(next!=null){
            next.setPrev(prev);
        }
        target = getNodeSafly(index-1);
        prev = getNodeSafly(index);
        linkedList.set(index,target);
        linkedList.set(index-1,prev);
        return target;
    }



    public Node<T> moveNodeForward(Node<T> target){
        int index = linkedList.indexOf(target);
        return moveNodeForward(index);
    }

    public Node<T> moveNodeForward(int index){
        Node<T> prev = getNodeSafly(index-1);
        Node<T> target = getNodeSafly(index);
        Node<T> next = getNodeSafly(index+1);
        Node<T> nextNext = getNodeSafly(index+2);
        if(linkedList.size()<2 || target==null || index==linkedList.size()-1){
            return null;
        }
        if(prev!=null){
            prev.setNext(next);
        }
        if(next!=null){
            next.setPrev(prev);
            next.setNext(target);
        }
        target.setPrev(next);
        target.setNext(nextNext);
        if(nextNext!=null){
            nextNext.setPrev(target);
        }

        target = getNodeSafly(index+1);
        next = getNodeSafly(index);

        linkedList.set(index,target);
        linkedList.set(index+1,next);

        return target;
    }




    public void disconnectNode(int index){
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


    public Node<T> getNodeSafly(int index){
        try{
            Node<T> node =linkedList.get(index);
            return node;
        }catch (Exception e){
            return null;
        }
    }



    public Node<T> getFirstElement(){
        return getNodeSafly(0);
    }
    public Node<T> getLastElement(){
        return getNodeSafly(linkedList.size()-1);
    }





    public static void main(String[] args) {
        DoubleLinkedList<Integer>  doubleLinkedList=new DoubleLinkedList<>();
        doubleLinkedList.addFirst(300);
        doubleLinkedList.addLast(400);
        doubleLinkedList.addFirst(200);
        doubleLinkedList.addFirst(100);
        doubleLinkedList.addLast(500);
        doubleLinkedList.printLinkedList();
        doubleLinkedList.printLinkedListByPointers();

    }



}
