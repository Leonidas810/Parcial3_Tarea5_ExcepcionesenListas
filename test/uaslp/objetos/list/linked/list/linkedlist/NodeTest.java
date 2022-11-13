package uaslp.objetos.list.linked.list.linkedlist;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NodeTest {

    @Test
    public void testGetData(){
        //Initialization
            Node node=new Node("NodeTest1");
        //Execution
            String data=node.getData();
        //Validation
            Assertions.assertEquals("NodeTest1",data);
    }

    @Test
    public void testSetData(){
        //Initialization
            Node node=new Node("NodeTest1");
        //Execution
            node.setData("NodeTest2");
        //Validation
            Assertions.assertEquals("NodeTest2",node.getData());
    }

    @Test
    public void testGetNext(){
        //Initialization
            Node node=new Node("NodeTest1");
        //Execution
            Node node_next=node.getNext();
        //Validation
            Assertions.assertNull(node_next);
    }

    @Test
    public void testSetNext(){
        //Initialization
            Node node=new Node("NodeTest1");
            Node node2=new Node("NodeTest2");
        //Execution
            node.setNext(node2);
        //Validation
            Assertions.assertEquals(node2,node.getNext());
    }

    @Test
    public void testSetPrevious(){
        //Initialization
            Node node=new Node("NodeTest1");
            Node node2=new Node("NodeTest2");
        //Execution
            node2.setPrevious(node);
        //Validation
            Assertions.assertEquals(node,node2.getPrevious());
    }

    @Test
    public void testGetPrevious(){
        //Initialization
            Node node=new Node("NodeTest");
        //Execution
            Node node_previous=node.getPrevious();
        //Validation
            Assertions.assertNull(node_previous);
    }
}
