package uaslp.objetos.list.linked.list.arraylist;

import uaslp.objetos.list.linked.list.List;
import uaslp.objetos.list.linked.list.exceptions.NullNotAllowedException;
import uaslp.objetos.list.linked.list.exceptions.WrongIndexException;

public class ArrayList implements List {

    private String[] data;
    private int size;

    public ArrayList(){
        data=new String[2];
    }

    public void addAtTail(String data) throws NullNotAllowedException {
        if(data==null)throw new NullNotAllowedException();
        if(size==this.data.length){
            this.data= increaseArraySize();
        }
        this.data[size]=data;
        size++;
    }

    public void addAtFront(String data) throws NullNotAllowedException{
        if(data==null)throw new NullNotAllowedException();
        if(size == this.data.length){
            this.data= increaseArraySize();
        }
        for (int i=size;i>0;i--){
            this.data[i]=this.data[i-1];
        }
        this.data[0]=data;
        this.size++;
    }

    public void removeIndex(int indexToRemove) throws WrongIndexException {
        if(indexToRemove < 0 || indexToRemove >= size) {
            throw  new WrongIndexException();
        }
        for(int i = indexToRemove; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        data[size] = null;
    }

    public void removeAll() {
        for(int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    public void setAt(int index, String data) throws WrongIndexException,NullNotAllowedException{
        if(data==null)throw new NullNotAllowedException();
        if(index < 0 || index >= size) {
            throw  new WrongIndexException();
        }

        this.data[index] = data;
    }

    public String getAt(int index) throws WrongIndexException{
        if(index < 0 || index >= size) {
            throw new WrongIndexException();
        }

        return this.data[index];
    }

    public void removeAllWithValue(String value) {
        String []newArray = new String[data.length];
        int count = 0;
        for(int i = 0; i < size; i++) {
            if(!data[i].equals(value)) {
                newArray[count] = data[i];
                count++;
            }
        }
        this.data = newArray;
        size = count;
    }

    public int getSize() {
        return size;
    }

    public ArrayListIterator getIterator() {
        return new ArrayListIterator(this);
    }

    private String[] increaseArraySize(){
        String [] newArray=new String[this.data.length+1];
        System.arraycopy(data, 0, newArray, 0, data.length);
        return newArray;
    }

}