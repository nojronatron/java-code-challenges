package myJava.code.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestDirectedCompleteGraph {
    @Test
    void test_canInstantiateGraph() {
        var sut = new DirectedCompleteGraph<>(11);
        assertNotNull(sut);
    }

    @Test
    void test_addVertexUsingGraphNodeClass() {
        var sut = new DirectedCompleteGraph<>("A");
        var bravo = new DirectedCompleteGraph.GraphNode<>("B");
        var charlie = new DirectedCompleteGraph.GraphNode<>("C");
        var delta = new DirectedCompleteGraph.GraphNode<>("D");

        assertDoesNotThrow(() -> {
            sut.addVertex(bravo);
        });

        sut.addVertex(charlie);
        sut.addVertex(delta);
        System.out.println(sut.getAdjacencyTable());

        var expectedCount = 4;
        var actualCount = sut.getCount();
        assertEquals(expectedCount, actualCount);
    }

//    @Test
//    void test_addVertexUsingIntegerValue() {
//        var sut = new DirectedCompleteGraph<>("A");
//        sut.addVertex("B", 1, "A");
//        sut.addVertex("C", 1, "A");
//        sut.addVertex("D", 3, "B");
//        sut.addVertex("D", 2, "C");
//        sut.addVertex("C", 3, "D");
//
//        var expectedResult = "D";
//        var actualResult = sut.findVertexValueByValueBF(expectedResult);
//        assertEquals(expectedResult, actualResult);
//    }

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
        var actualValue = sut.findVertexValueByValueBF(12);
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
        var actualValue = sut.findVertexValueByValueBF("delta");
        assertEquals(expectedValue, actualValue);
    }
}
