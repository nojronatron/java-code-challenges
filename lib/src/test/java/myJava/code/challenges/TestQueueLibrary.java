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

    @Test void testQueue_CanPeekSingleValue() {
        int expectedResult = 11;
        MyNode node = new MyNode(expectedResult);
        MyQueue sut = new MyQueue(node);
        assertFalse(sut.isEmpty());
        int actualResult = sut.peek();
        assertEquals(expectedResult, actualResult);
        assertFalse(sut.isEmpty());
    }

    @Test void testQueue_GrowAndShrinkQueue() {
        int firstExpectedResult = 11;
        int secondExpectedResult = 12;
        int thirdExpectedResult = 13;
        int fourthExpectedResult = 14;
        MyNode node = new MyNode(firstExpectedResult);
        MyQueue sut = new MyQueue(node);
        sut.enqueue(secondExpectedResult);
        sut.enqueue(thirdExpectedResult);
        sut.enqueue(fourthExpectedResult);
        assertFalse(sut.isEmpty());
        assertEquals(firstExpectedResult, sut.peek());
        assertFalse(sut.isEmpty());
        assertEquals(firstExpectedResult, sut.dequeue());
        assertFalse(sut.isEmpty());
        assertEquals(secondExpectedResult, sut.dequeue());
        assertFalse(sut.isEmpty());
        assertEquals(thirdExpectedResult, sut.dequeue());
        assertFalse(sut.isEmpty());
        assertEquals(fourthExpectedResult, sut.dequeue());
        assertTrue(sut.isEmpty());
    }

    // start throws exception tests
    @Test void testQueue_PeekEmptyQueueThrowsNullPointerException() {
        MyQueue sut = new MyQueue();
        assertThrows(NullPointerException.class, sut::peek); // uses method reference instead of lambda
    }

    @Test void testQueue_DequeueEmptyThrowsNullPointerException() {
        MyQueue sut = new MyQueue();
        assertThrows(NullPointerException.class, sut::dequeue);
    }
    // end throws exception tests
}
