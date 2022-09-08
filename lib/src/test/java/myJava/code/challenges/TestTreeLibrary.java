/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package myJava.code.challenges;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestTreeLibrary {
    @Test void someLibraryMethodReturnsTrue() {
        Library classUnderTest = new Library();
        assertTrue(classUnderTest.someLibraryMethod(), "someLibraryMethod should return 'true'");
    }

    @Test void testBinaryNodeCanInstantiate() {
        int expectedValue = 11;
        MyBinaryNode sut = new MyBinaryNode(expectedValue);
        assertNotNull(sut);
        assertEquals(expectedValue, sut.getValue());
    }

    @Test void testBinaryNodeGetterSetters() {
        MyBinaryNode sut = new MyBinaryNode(11);
        MyBinaryNode leftSut = new MyBinaryNode(10);
        sut.setLeft(leftSut);
        assertEquals(leftSut, sut.getLeft());
        assertEquals(sut.getLeft().getValue(), leftSut.getValue());
        MyBinaryNode rightSut = new MyBinaryNode(12);
        sut.setRight(rightSut);
        assertEquals(rightSut, sut.getRight());
        assertEquals(sut.getRight().getValue(), rightSut.getValue());
    }
}
