package uaslp.objetos.list.linked.list.linkedlist;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uaslp.objetos.list.linked.list.exceptions.NullNotAllowedException;
import uaslp.objetos.list.linked.list.exceptions.WrongIndexException;

public class LinkedListTest {

    @Test
    public void testAddAtTail () throws NullNotAllowedException {
        //Initialization
            LinkedList test_list=new LinkedList();
        //Se evaluan los 2 casos base
        //1.-Que no exista ningun nodo, es decir es una lista vacia
        //Execution
            test_list.addAtTail("NodeTest1");
        //Validation
            Assertions.assertEquals("NodeTest1",test_list.getAt(0));
        //2.-Que exista uno o más nodos en la lista
        //Execution
            test_list.addAtTail("NodeTest2");
        //Validation
            Assertions.assertEquals("NodeTest1",test_list.getAt(0));
            Assertions.assertEquals("NodeTest2",test_list.getAt(1));
            Assertions.assertEquals(2,test_list.getSize());
        //Validation cuando queremos agregar un elemento con un valor nulo
            Assertions.assertThrows(NullNotAllowedException.class,()->test_list.addAtTail(null));
    }

    @Test
    public void testAddAtFront() throws NullNotAllowedException{
        //Initialization
            LinkedList test_list=new LinkedList();
        //Se evaluan los 2 casos base
        //1.-Que no exista ningun nodo, es decir es una lista vacia
        //Execution
            test_list.addAtFront("NodeTest2");
        //Validation
            Assertions.assertEquals("NodeTest2",test_list.getAt(0));
        //2.-Que exista uno o más nodos en la lista
        //Execution
            test_list.addAtFront("NodeTest1");
        //Validation
            Assertions.assertEquals("NodeTest1",test_list.getAt(0));
            Assertions.assertEquals("NodeTest2",test_list.getAt(1));
            Assertions.assertEquals(2,test_list.getSize());
        //Validation cuando queremos agregar un elemento con un valor nulo
            Assertions.assertThrows(NullNotAllowedException.class,()->test_list.addAtTail(null));
    }

    @Test
    public void testRemoveIndex() throws WrongIndexException {
        //Initialization
            LinkedList test_list=new LinkedList();
            test_list.addAtTail("NodeTest1");//0
            test_list.addAtTail("NodeTest2");   //0//0//0
            test_list.addAtTail("NodeTest3");      //1//1
            test_list.addAtTail("NodeTest4");      //2
            test_list.addAtTail("NodeTest5");//4//3
        //Se evaluan los 4 casos base
        //1.- El Nodo=head
            //Execution
            test_list.removeIndex(0);
            //Validation
            Assertions.assertEquals("NodeTest2",test_list.getAt(0));
        //2.- El Nodo=tail
            //Execution
            test_list.removeIndex(3);
            //Validation
            Assertions.assertEquals("NodeTest4",test_list.getAt(2));
        //3.- El nodo se encuentra entre head y tail
            //Execution
            test_list.removeIndex(1);
            //Validation
            Assertions.assertEquals("NodeTest4",test_list.getAt(1));
        //4.- head=tail
        //Execution
            test_list.removeIndex(0);
            test_list.removeIndex(0);
        //Validation
            Assertions.assertEquals(0,test_list.getSize());
        //Validation cuando se envia un index que no esta dentro de la lista
            Assertions.assertThrows(WrongIndexException.class,()->test_list.removeIndex(-1));
    }

    @Test
    public void testRemoveAll(){
        //Initialization
            LinkedList test_list=new LinkedList();
            test_list.addAtTail("NodeTest1");
            test_list.addAtTail("NodeTest2");
            test_list.addAtTail("NodeTest3");
            test_list.addAtTail("NodeTest4");
            test_list.addAtTail("NodeTest5");
        //Execution
            test_list.removeAll();
        //Validation
            Assertions.assertEquals(0,test_list.getSize());
    }

    @Test
    public void testSetAt() throws WrongIndexException,NullNotAllowedException{
        //Initialization
            LinkedList test_list=new LinkedList();
            test_list.addAtTail("NodeTest1");
        //Existen 2 casos
        //El elemento buscado existe
            //Execution
                test_list.setAt(0,"NodeTest2");
            //Validation
                Assertions.assertEquals("NodeTest2",test_list.getAt(0));
            //Validation cuando queremos agregar un elemento con un valor nulo
            Assertions.assertThrows(NullNotAllowedException.class,()->test_list.addAtTail(null));
        //Validation cuando se envia un index que no esta dentro de la lista
            Assertions.assertThrows(WrongIndexException.class,()->test_list.setAt(-1,"NodeTest3"));
    }

    @Test
    public void testGetAt() throws WrongIndexException{
        //Initialization
            LinkedList test_list=new LinkedList();
            test_list.addAtTail("NodeTest1");
        //Execution
            String data=test_list.getAt(0);
        //Validation
            Assertions.assertEquals("NodeTest1",data);
        //Validation cuando se envia un index que no esta dentro de la lista
        Assertions.assertThrows(WrongIndexException.class,()->test_list.getAt(-1));
    }
    @Test
    public void testRemoveAllWithValue(){
        //Initialization
            LinkedList test_list=new LinkedList();
            test_list.addAtTail("NodeTest1");
            test_list.addAtTail("NodeTest1");
            test_list.addAtTail("NodeTest2");
            test_list.addAtTail("NodeTest1");
            test_list.addAtTail("NodeTest2");
            test_list.addAtTail("NodeTest1");
        //Existen 2 casos posibles
        //Existen elementos dentro de la lista
        //Execution
            test_list.removeAllWithValue("NodeTest1");
        //Validation
            Assertions.assertEquals(test_list.getAt(0),"NodeTest2");
            Assertions.assertEquals(2,test_list.getSize());
        //No Existen elementos dentro de la lista
        //Execution
            test_list.removeAllWithValue("NodeTest2");
            test_list.removeAllWithValue("NodeTest1");
        //Validation
    }

    @Test
    public void testGetSize(){
        //Initialization
            LinkedList test_list=new LinkedList();
            test_list.addAtTail("NodeTest1");
            test_list.addAtTail("NodeTest2");
            test_list.addAtTail("NodeTest3");
        //Execution
            int size= test_list.getSize();
        //Validation
            Assertions.assertEquals(3,size);
    }

    @Test
    public void testGetIterator(){
        //Initialization
            LinkedList test_list=new LinkedList();
            test_list.addAtTail("NodeTest1");
            test_list.addAtTail("NodeTest2");
            test_list.addAtTail("NodeTest3");
        //Execution
            LinkedListIterator iterator=test_list.getIterator();
        //Validation
            int index=0;
            while (iterator.hasNext()){
                Assertions.assertEquals(test_list.getAt(index),iterator.Next());
                index++;
            }
    }
}
