package uaslp.objetos.list.linked.list.arraylist;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uaslp.objetos.list.linked.list.exceptions.NullNotAllowedException;
import uaslp.objetos.list.linked.list.exceptions.WrongIndexException;

public class ArrayListTest {
    @Test
    public void testAddAtTail() throws NullNotAllowedException{
        //Initialization
            ArrayList test_array=new ArrayList();
        //Se evaluan los 2 casos base
        //1.-Que no exista ningun nodo, es decir es una lista vacia
        //Execution
            test_array.addAtTail("NodeTest1");
        //Validation
        Assertions.assertEquals("NodeTest1",test_array.getAt(0));
        //2.-Que exista uno o más nodos en la lista
        //Execution
            test_array.addAtTail("NodeTest2");
            test_array.addAtTail("NodeTest3");
        //Validation
            Assertions.assertEquals("NodeTest1",test_array.getAt(0));
            Assertions.assertEquals("NodeTest2",test_array.getAt(1));
            Assertions.assertEquals("NodeTest3",test_array.getAt(2));
            Assertions.assertEquals(3,test_array.getSize());
        //Validation cuando queremos agregar un elemento con un valor nulo
        Assertions.assertThrows(NullNotAllowedException.class,()->test_array.addAtTail(null));
    }

    @Test
    public void testAddAtFront() throws NullNotAllowedException{
        //Initialization
            ArrayList test_array=new ArrayList();
        //Se evaluan los 2 casos base
        //1.-Que no exista ningun nodo, es decir es una lista vacia
        //Execution
            test_array.addAtFront("NodeTest3");
        //Validation
            Assertions.assertEquals("NodeTest3",test_array.getAt(0));
        //2.-Que exista uno o más nodos en la lista
        //Execution
            test_array.addAtFront("NodeTest2");
            test_array.addAtFront("NodeTest1");
        //Validation
            Assertions.assertEquals("NodeTest1",test_array.getAt(0));
            Assertions.assertEquals("NodeTest2",test_array.getAt(1));
            Assertions.assertEquals("NodeTest3",test_array.getAt(2));
            Assertions.assertEquals(3,test_array.getSize());
        //Validation cuando queremos agregar un elemento con un valor nulo
        Assertions.assertThrows(NullNotAllowedException.class,()->test_array.addAtTail(null));
    }

    @Test
    public void testRemoveIndex() throws WrongIndexException {
        //Initialization
            ArrayList test_array=new ArrayList();
            test_array.addAtTail("NodeTest1");//0
            test_array.addAtTail("NodeTest2");   //0//0//0
            test_array.addAtTail("NodeTest3");      //1//1
            test_array.addAtTail("NodeTest4");      //2
            test_array.addAtTail("NodeTest5");//4//3
        //Se evaluan los 4 casos base
        //1.- El Nodo=head
        //Execution
            test_array.removeIndex(0);
        //Validation
            Assertions.assertEquals("NodeTest2",test_array.getAt(0));
        //2.- El Nodo=tail
        //Execution
            test_array.removeIndex(3);
        //Validation
            Assertions.assertEquals("NodeTest4",test_array.getAt(2));
        //3.- El nodo se encuentra entre head y tail
        //Execution
            test_array.removeIndex(1);
        //Validation
            Assertions.assertEquals("NodeTest4",test_array.getAt(1));
        //4.- head=tail
        //Execution
            test_array.removeIndex(0);
            test_array.removeIndex(0);
        //Validation
            Assertions.assertEquals(0,test_array.getSize());
        //Validation cuando se envia un index que no esta dentro de la lista
            Assertions.assertThrows(WrongIndexException.class,()->test_array.removeIndex(-1));
    }

    @Test
    public void testRemoveAll(){
        //Initialization
            ArrayList test_array=new ArrayList();
            test_array.addAtTail("NodeTest1");
            test_array.addAtTail("NodeTest2");
            test_array.addAtTail("NodeTest3");
            test_array.addAtTail("NodeTest4");
            test_array.addAtTail("NodeTest5");
        //Execution
            test_array.removeAll();
        //Validation
            Assertions.assertEquals(0,test_array.getSize());
    }

    @Test
    public void testSetAt()throws WrongIndexException,NullNotAllowedException{
        //Initialization
            ArrayList test_array=new ArrayList();
            test_array.addAtTail("NodeTest1");
        //Existen 2 casos
            //El elemento buscado existe
            //Execution
                test_array.setAt(0,"NodeTest2");
            //Validation
                Assertions.assertEquals("NodeTest2",test_array.getAt(0));
        //Validation cuando queremos agregar un elemento con un valor nulo
            Assertions.assertThrows(NullNotAllowedException.class,()->test_array.addAtTail(null));
        //Validation cuando se envia un index que no esta dentro de la lista
            Assertions.assertThrows(WrongIndexException.class,()->test_array.setAt(-1,"NodeTest3"));
    }

    @Test
    public void testGetAt()throws WrongIndexException{
        //Initialization
            ArrayList test_array=new ArrayList();
            test_array.addAtTail("NodeTest1");
        //Execution
            String data=test_array.getAt(0);
        //Validation
            Assertions.assertEquals("NodeTest1",data);
        //Validation cuando se envia un index que no esta dentro de la lista
            Assertions.assertThrows(WrongIndexException.class,()->test_array.getAt(-1));
    }
    @Test
    public void testRemoveAllWithValue(){
        //Initialization
            ArrayList test_array=new ArrayList();
            test_array.addAtTail("NodeTest1");
            test_array.addAtTail("NodeTest1");
            test_array.addAtTail("NodeTest2");
            test_array.addAtTail("NodeTest1");
            test_array.addAtTail("NodeTest2");
            test_array.addAtTail("NodeTest1");
        //Existen 2 casos posibles
        //Existen elementos dentro de la lista
        //Execution
            test_array.removeAllWithValue("NodeTest1");
        //Validation
            Assertions.assertEquals(test_array.getAt(0),"NodeTest2");
            Assertions.assertEquals(2,test_array.getSize());
        //No Existen elementos dentro de la lista
        //Execution
            test_array.removeAllWithValue("NodeTest2");
            test_array.removeAllWithValue("NodeTest1");
        //Validation
    }
    @Test
    public void testGetSize(){
        //Initialization
            ArrayList test_array=new ArrayList();
            test_array.addAtTail("NodeTest1");
            test_array.addAtTail("NodeTest2");
            test_array.addAtTail("NodeTest3");
        //Execution
            int size= test_array.getSize();
        //Validation
            Assertions.assertEquals(3,size);
    }
    @Test
    public void testGetIterator(){
        //Initialization
            ArrayList test_array=new ArrayList();
            test_array.addAtTail("NodeTest1");
            test_array.addAtTail("NodeTest2");
            test_array.addAtTail("NodeTest3");
        //Execution
            ArrayListIterator iterator=test_array.getIterator();
        //Validation
            int index=0;
            while (iterator.hasNext()){
                Assertions.assertEquals(test_array.getAt(index),iterator.Next());
                index++;
            }
    }
}
