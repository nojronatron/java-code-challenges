package myJava.code.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestDirectedCompleteGraph {
    @Test
    void test_canInstantiateGraph() {
        var sut = new DirectedCompleteGraph<>(11);
        assertNotNull(sut);
    }

//    @Test
//    void test_addVertexWithNullNeighborThrowsNullPointerException() {
//        var sut = new DirectedCompleteGraph<>(11);
//        assertThrows(NullPointerException.class, () -> {
//            sut.addVertex(12, 1, null);
//        });
//    }

    @Test
    void test_addVertexUsingIntegerValue() {
        var sut = new DirectedCompleteGraph<>(11);
        sut.addVertex(12, 2, 11);
    }

    @Test
    void test_visitedNodesReturnsEmptyWithoutTraversingFirst() {
        var sut = new DirectedCompleteGraph<>(11);
        var expectedCount = 0;
        var expectedResult = 0;
        var visitedNodeValues = sut.getVisitedNodes();
        var actualCount = visitedNodeValues.size();
        assertEquals(expectedCount, actualCount);
        var actualResult = visitedNodeValues.size();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test_findVertexIntegerValueBreadthFirstSucceeds() {
        var sut = new DirectedCompleteGraph<>(11);
        sut.addVertex(12, 2, 11);
        var expectedValue = 12;
        var actualValue = sut.findVertexByValueBF(12);
        assertEquals(expectedValue, actualValue);
    }
    @Test
    void test_findVertexStringValueBreadthFirstSucceeds() {
        var sut = new DirectedCompleteGraph<>("alpha");
        sut.addVertex("bravo", 1, "alpha");
        sut.addVertex("charlie", 1, "alpha");
        sut.addVertex("delta", 3, "bravo");
        sut.addVertex("delta", 2, "charlie");

        var expectedValue = "delta";
        var actualValue = sut.findVertexByValueBF("delta");
        assertEquals(expectedValue, actualValue);
    }
}
