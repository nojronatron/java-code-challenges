package myJava.code.challenges;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestQueueLibrary {
    @Test void testQueue_CanInstantiateEmptyQueue() {
        MyQueue sut = new MyQueue();
        assertNotNull(sut);
    }

    @Test void testQueue_IsEmptyReturnsTrue() {
        MyQueue sut = new MyQueue();
        assertTrue(sut.isEmpty());
    }

    @Test void testQueue_CanEnqueueSingleValue() {
        MyQueue sut = new MyQueue();
        assertTrue(sut.isEmpty());
        sut.enqueue(11);
        assertFalse(sut.isEmpty());
    }

    @Test void testQueue_CanDequeueSingleValue() {
        int expectedResult = 11;
        MyNode node =new MyNode(expectedResult);
        MyQueue sut =new MyQueue(node);
        assertFalse(sut.isEmpty());
        int actualResult = sut.dequeue();
        assertEquals(expectedResult, actualResult);
        assertTrue(sut.isEmpty());
    }
}
