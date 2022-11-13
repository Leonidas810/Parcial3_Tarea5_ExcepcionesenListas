package uaslp.objetos.list.linked.list.linkedlist;

import uaslp.objetos.list.linked.list.List;
import uaslp.objetos.list.linked.list.exceptions.NullNotAllowedException;
import uaslp.objetos.list.linked.list.exceptions.WrongIndexException;

public class LinkedList implements List {
    private Node head;
    private Node tail;
    private int size;

    public void addAtTail(String data) throws NullNotAllowedException {
        if(data==null)throw new NullNotAllowedException();
        Node node=new Node(data);

        if (head == null){
            head = node;
        }else{
            node.setPrevious(tail);
            tail.setNext(node);
        }
        tail = node;
        size++;
    }

    public void addAtFront(String data)throws NullNotAllowedException{
        if(data==null)throw new NullNotAllowedException();
        Node node=new Node(data);

        if (head == null) {
            tail=node;
        }else{
            node.setNext(head);
            head.setPrevious(node);
        }
        head=node;
        size++;
    }

    public void removeIndex(int indexToRemove)throws  WrongIndexException{
        if (indexToRemove <0 || indexToRemove >= size){
            throw  new WrongIndexException();
        }
        if(size == 1){
            head=null;
            tail=null;
        }else if(indexToRemove == 0){
            head = head.getNext();
            head.setPrevious(null);
        }else if (indexToRemove == size-1){
            tail= tail.getPrevious();
            tail.setNext(null);
        }else{
            Node iteratorNode = findNodeByIndex(indexToRemove);
            iteratorNode.getPrevious().setNext(iteratorNode.getNext());
            iteratorNode.getNext().setPrevious(iteratorNode.getPrevious());
        }
        size--;
    }

    public void removeAll(){
        while (head != tail){
            head = head.getNext();
            head.setPrevious(null);
        }
        head=null;
        size=0;
    }

    public void setAt(int indexToSearch,String data) throws WrongIndexException,NullNotAllowedException{
        if(data==null)throw new NullNotAllowedException();
        if (indexToSearch <0 || indexToSearch >= size){
            throw new WrongIndexException();
        }

        Node iteratorNode = findNodeByIndex(indexToSearch);
        iteratorNode.setData(data);
    }

    public String getAt(int indexToSearch) throws WrongIndexException{
        if (indexToSearch <0 || indexToSearch >= size){
            throw new WrongIndexException();
        }
        Node iteratorNode = findNodeByIndex(indexToSearch);
        return iteratorNode.getData();
    }

    public void removeAllWithValue(String data){
        Node iteratorNode= head;
        while (iteratorNode != null){
            if(iteratorNode.getData().equals(data)){
                if(size==1){
                    head=tail=null;
                }
                else if(iteratorNode==head){
                    head = head.getNext();
                    head.setPrevious(null);
                }else if (iteratorNode==tail){
                    tail= tail.getPrevious();
                    tail.setNext(null);
                }else{
                    iteratorNode.getPrevious().setNext(iteratorNode.getNext());
                    iteratorNode.getNext().setPrevious(iteratorNode.getPrevious());
                }
                size--;
            }
            iteratorNode=iteratorNode.getNext();
        }
    }

    public int getSize() {
        return size;
    }

    public LinkedListIterator getIterator() {
        return new LinkedListIterator(head);
    }

    private Node findNodeByIndex(int indexToRemove) {
        Node iteratorNode = head;
        int indexIteratorNode = 0;

        while (indexIteratorNode < indexToRemove){
            iteratorNode = iteratorNode.getNext();
            indexIteratorNode++;
        }
        return iteratorNode;
    }
}
