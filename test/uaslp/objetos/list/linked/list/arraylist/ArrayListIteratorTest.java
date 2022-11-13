package uaslp.objetos.list.linked.list.arraylist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayListIteratorTest {
    @Test
    public void testHasNext(){
        //Initialization
        ArrayList test=new ArrayList();
        test.addAtTail("Nodetest1");
        ArrayListIterator iterator=new ArrayListIterator(test);
        //Execution
        boolean res=iterator.hasNext();
        //Validation
        Assertions.assertTrue(res);

    }

    @Test
    public void testNext(){
        //Initialization
        ArrayList test=new ArrayList();
        test.addAtTail("Nodetest1");
        ArrayListIterator iterator=new ArrayListIterator(test);
        //Execution
        String data=iterator.Next();
        //Validation
        Assertions.assertEquals("Nodetest1",data);
    }
}
