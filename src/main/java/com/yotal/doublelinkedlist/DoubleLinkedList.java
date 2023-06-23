package com.yotal.doublelinkedlist;


public class DoubleLinkedList<T> {

    private Node<T> head ;
    private Node<T> tail ;






    // XXXXXXXXXXXXXXXXXXXXXXXXXX
    // TODO:  update the tail please
    public Node<T> addHead(Node<T> node){
        Node<T> prevNode = node!=null ? node.getPrev() : null;
        Node<T> nextNode = node!=null ? node.getNext() : null;
        Node<T> nextNextNode = nextNode!=null ? nextNode.getNext() : null;
        Node<T> prevPrevNode = prevNode!=null ? prevNode.getPrev() : null;

        if(head!=null){
            head.setPrev(node);

        }
        node.setNext(head);
        head=node;
        return head;
    }

    public Node<T> addHead(T t){
        Node<T> node =new Node<>(t);
        return addHead(node);
    }


    public Node<T> addTail(Node<T> node){
        if(tail!=null){
            tail.setNext(node);
            node.setPrev(tail);
        }
        tail=node;
        return tail;
    }

    public Node<T> addTail(T t){
        Node<T> node =new Node<>(t);
        return addTail(node);
    }


    public Node<T> getHead(){
        return head;
    }

    public Node<T> getTail(){
        return tail;
    }

    public Node<T> removeHead(){
       if(head!=null){
           head.getNext().setPrev(null);
           head=head.getNext();
       }
       return head;
    }


    public Node<T> removeTail(){
        Node<T> prevTail = tail!=null ? tail.getPrev() : null;
        if(prevTail!=null){
            prevTail.setNext(null);
            tail=prevTail;
            return tail;
        }
        tail=null;
        return tail;
    }


    public void remove(Node<T> node){
        Node<T> prevNode = node!=null ? node.getPrev() : null;
        Node<T> nextNode = node!=null ? node.getNext() : null;
        if(prevNode!=null){
            prevNode.setNext(nextNode);
        }
        if(nextNode!=null){
            nextNode.setPrev(prevNode);
        }
        node=null;
    }

    public Boolean isContains(Node<T> node){
        Node<T> current=head;
        while(current!=null){
            if(current.equals(node)){
                return true;
            }
            current=current.getNext();
        }
        return false;
    }

    public Boolean isContains(T t){
        return isContains(new Node<>(t));
    }

    public Node<T> moveNodeBackward(Node<T> node){
        Node<T> prevNode = node!=null ? node.getPrev() : null;
        Node<T> nextNode = node!=null ? node.getNext() : null;
        Node<T> prevPrevNode = prevNode!=null ? prevNode.getPrev() : null;
        if(prevPrevNode!=null){
            prevPrevNode.setNext(node);
            node.setPrev(prevPrevNode);
            node.setNext(prevNode);
        }
        if(prevNode!=null){
            prevNode.setPrev(node);
        }
        refreshHeadTail();
        return node;
    }

    private void refreshHeadTail() {
        if(head!=null && head.getPrev()!=null){
            head=head.getPrev();
        }
        if(tail!=null && tail.getNext()!=null){
            tail=tail.getNext();
        }
    }

    public Node<T> moveNodeForward(Node<T> node){
        Node<T> prevNode = node!=null ? node.getPrev() : null;
        Node<T> nextNode = node!=null ? node.getNext() : null;
        Node<T> nextNextNode = nextNode!=null ? nextNode.getNext() : null;
        if(nextNextNode!=null){
            nextNextNode.setPrev(node);
            node.setNext(nextNextNode);
            node.setPrev(nextNode);
        }
        if(nextNode!=null){
            nextNode.setNext(node);
        }
        refreshHeadTail();
        return node;
    }


    public Integer getSize(){
        Integer size=0;
        Node<T> current=head;
        while(current!=null){
            size++;
            current=current.getNext();
        }
        return size;
    }


    public void printDoubleLinkedList(){
        Node<T> current=head;
        while(current!=null){
            System.out.print(current.getData());
            if(current.getNext()!=null){
                System.out.print(" -> ");
            }
            current=current.getNext();
        }
        System.out.println("\n---------------------------------------------------------");
    }











    public static void main(String[] args) {
        DoubleLinkedList<Integer>  doubleLinkedList=new DoubleLinkedList<>();
        doubleLinkedList.addHead(100);
        doubleLinkedList.addHead(200);
       doubleLinkedList.printDoubleLinkedList();

    }



}
