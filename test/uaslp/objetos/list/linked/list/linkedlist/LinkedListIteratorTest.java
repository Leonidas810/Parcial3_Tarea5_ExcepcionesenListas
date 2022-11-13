package uaslp.objetos.list.linked.list.linkedlist;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LinkedListIteratorTest {
    @Test
    public void testHasNext(){
    //Initialization
        LinkedListIterator iterator=new LinkedListIterator(new Node("NodeTest1"));
    //Execution
        boolean res=iterator.hasNext();
    //Validation
        Assertions.assertTrue(res);
    }

    @Test
    public void testNext(){
    //Initialization
        LinkedListIterator iterator=new LinkedListIterator(new Node("NodeTest1"));
    //Execution
        String data=iterator.Next();
    //Validation
        Assertions.assertEquals("NodeTest1",data);
    }

}
