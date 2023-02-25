package myJava.code.models.DirectedCompleteGraph;

import org.junit.jupiter.api.Test;

import java.util.Hashtable;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class TestDirectedCompleteGraph {
    @Test
    void test_canInstantiateGraphNode() {
        int expectedEdges = 0;
        int expectedIntValue = 11;
        var sutInt = new MyGraphNode<>(expectedIntValue);
        assertEquals(expectedIntValue, sutInt.getValue());
        assertEquals(expectedEdges, sutInt.edgeCount());

        var expectedStringValue = "alpha";
        var sutString = new MyGraphNode<>(expectedStringValue);
        assertEquals(expectedStringValue, sutString.getValue());
        assertEquals(expectedEdges, sutString.edgeCount());
    }

    @Test
    void test_canAddEdgeBetweenGraphNodes() {
        var alphaVal = "A";
        var bravoVal = "B";
        var abWeight = 1;
        var alpha = new MyGraphNode<>(alphaVal);
        var bravo = new MyGraphNode<>(bravoVal);

        alpha.setEdge(bravo, abWeight);

        var expectedEdgeCount = 1;
        assertEquals(expectedEdgeCount, alpha.edgeCount());
    }

    @Test
    void test_canInstantiateGraph() {
        var alphaVal = "A";
        var bravoVal = "B";
        var charlieVal = "C";

        var alpha = new MyGraphNode<>(alphaVal);
        var sut = new MyGraph<>(alpha);
        assertNotNull(sut);

        var expectedCount = 3;
        Map<String, MyGraphNode<String>> vertices = new Hashtable<>();
        var bravo = new MyGraphNode<>(bravoVal);
        var charlie = new MyGraphNode<>(charlieVal);
        vertices.put(alpha.getValue(), alpha);
        vertices.put(bravo.getValue(), bravo);
        vertices.put(charlie.getValue(), charlie);

        sut = new MyGraph<>(vertices);
        assertNotNull(sut);
        assertEquals(sut.getCount(), expectedCount);
    }

    @Test
    void test_addVertexUsingGraphNodeClass() {
        var alphaVal = "A";
        var bravoVal = "B";
        var charlieVal = "C";
        var deltaVal = "D";

        var alpha = new MyGraphNode<>(alphaVal);
        var sut = new MyGraph<>(alpha);

        var expectedCount = 1;
        assertEquals(sut.getCount(), expectedCount);

        var bravo = new MyGraphNode<>(bravoVal);
        var charlie = new MyGraphNode<>(charlieVal);
        var delta = new MyGraphNode<>(deltaVal);

        assertDoesNotThrow(() -> {
            sut.addVertex(bravo);
        });

        sut.addVertex(charlie);
        sut.addVertex(delta);
        System.out.println(sut.toString());

        expectedCount = 4;
        assertEquals(expectedCount, sut.getCount());
    }

    @Test
    void test_addEdgeBetweenTwoGivenVertices() {
        var alphaVal = "A";
        var bravoVal = "B";
        var edgeWeight = 1;

        var alpha = new MyGraphNode<>(alphaVal);
        var bravo = new MyGraphNode<>(bravoVal);
        System.out.println(alpha);
        System.out.println(bravo);

        alpha.setEdge(bravo, edgeWeight);
        System.out.println(alpha);
        System.out.println(bravo);

        var expectedEdgeCount = 1;
        assertEquals(expectedEdgeCount, alpha.edgeCount());
        assertEquals(0, bravo.edgeCount());

        bravo.setEdge(alpha,  edgeWeight);
        System.out.println(alpha);
        System.out.println(bravo);
        assertEquals(expectedEdgeCount, bravo.edgeCount());
        assertEquals(expectedEdgeCount, alpha.edgeCount());
    }

    @Test
    void test_buildSmallComplexGraph(){
        var alphaVal = "A";
        var bravoVal = "B";
        var charlieVal = "C";
        var deltaVal = "D";

        var alpha = new MyGraphNode<>(alphaVal);
        var sut = new MyGraph<>(alpha);

        var expectedCount = 1;
        assertEquals(sut.getCount(), expectedCount);

        var bravo = new MyGraphNode<>(bravoVal);
        var charlie = new MyGraphNode<>(charlieVal);
        var delta = new MyGraphNode<>(deltaVal);

        sut.addVertex(bravo);
        sut.addVertex(charlie);
        sut.addVertex(delta);

        System.out.println(sut.toString());

        alpha.setEdge(bravo, 1);
        alpha.setEdge(charlie, 1);
        bravo.setEdge(delta, 3);
        charlie.setEdge(delta, 2);
        delta.setEdge(charlie, 3);

        System.out.println(sut.toString());

        var expectedNodesInGraph = 4;
        assertEquals(expectedNodesInGraph, sut.getCount());
    }

    @Test
    void test_findVertexInstance() {
        var alphaVal = "A";
        var bravoVal = "B";
        var charlieVal = "C";
        var deltaVal = "D";

        var alpha = new MyGraphNode<>(alphaVal);
        var sut = new MyGraph<>(alpha);

        var bravo = new MyGraphNode<>(bravoVal);
        var charlie = new MyGraphNode<>(charlieVal);
        var delta = new MyGraphNode<>(deltaVal);

        sut.addVertex(bravo);
        sut.addVertex(charlie);
        sut.addVertex(delta);

        alpha.setEdge(bravo, 1);
        alpha.setEdge(charlie, 1);
        bravo.setEdge(delta, 3);
        charlie.setEdge(delta, 2);
        delta.setEdge(charlie, 3);

        var result = sut.findVertexBreadthFirst(alpha, deltaVal);

        System.out.printf("Search for [ %s ] found Vertex with value [ %s ].%n", deltaVal, result.getValue());

        assertEquals(delta, result);
    }

    @Test
    void test_findVertexByValue() {
        var alphaVal = "A";
        var bravoVal = "B";
        var charlieVal = "C";
        var deltaVal = "D";

        var alpha = new MyGraphNode<>(alphaVal);
        var sut = new MyGraph<>(alpha);

        var bravo = new MyGraphNode<>(bravoVal);
        var charlie = new MyGraphNode<>(charlieVal);
        var delta = new MyGraphNode<>(deltaVal);

        sut.addVertex(bravo);
        sut.addVertex(charlie);
        sut.addVertex(delta);

        alpha.setEdge(bravo, 1);
        alpha.setEdge(charlie, 1);
        bravo.setEdge(delta, 3);
        charlie.setEdge(delta, 2);
        delta.setEdge(charlie, 3);

        var result = sut.findVertexValueByValueBF(alphaVal, deltaVal);

        System.out.printf("Search for [ %s ] found Vertex with value [ %s ].%n", deltaVal, result);

        assertEquals(deltaVal, result);    }

    @Test
    void test_removeGraphNode() {
        var expectedCount = 1;
        var alphaVal = "A";

        var alpha = new MyGraphNode<>(alphaVal);
        var sut = new MyGraph<>(alpha);

        assertEquals(expectedCount, sut.getCount());

        expectedCount = 0;
        sut.removeVertex(alpha);

        assertEquals(expectedCount, sut.getCount());

        sut = new MyGraph<>(alpha);
        var bravoVal = "B";
        var charlieVal = "C";
        var deltaVal = "D";

        var bravo = new MyGraphNode<>(bravoVal);
        var charlie = new MyGraphNode<>(charlieVal);
        var delta = new MyGraphNode<>(deltaVal);

        sut.addVertex(bravo);
        sut.addVertex(charlie);
        sut.addVertex(delta);

        alpha.setEdge(bravo, 1);
        alpha.setEdge(charlie, 1);
        bravo.setEdge(delta, 3);
        charlie.setEdge(delta, 2);
        delta.setEdge(charlie, 3);

        expectedCount = 4;
        assertEquals(expectedCount, sut.getCount());
        sut.removeVertex(alpha);
        expectedCount--;
        assertEquals(expectedCount, sut.getCount());
    }

    @Test
    public void test_removeMultiEdgeVertexFromGraph() {
        var alphaVal = "A";

        var alpha = new MyGraphNode<>(alphaVal);
        var sut = new MyGraph<>(alpha);
        var bravoVal = "B";
        var charlieVal = "C";
        var deltaVal = "D";

        var bravo = new MyGraphNode<>(bravoVal);
        var charlie = new MyGraphNode<>(charlieVal);
        var delta = new MyGraphNode<>(deltaVal);

        sut.addVertex(bravo);
        sut.addVertex(charlie);
        sut.addVertex(delta);

        alpha.setEdge(bravo, 1);
        alpha.setEdge(charlie, 1);
        bravo.setEdge(delta, 3);
        charlie.setEdge(delta, 2);
        delta.setEdge(charlie, 3);

        var expectedCount = 4;
        assertEquals(expectedCount, sut.getCount());
        sut.removeVertex(delta);
        expectedCount --;
        assertEquals(expectedCount, sut.getCount());
    }

    @Test
    void test_findWeightBetweenTwoGraphNodes() {
        assertTrue(false);
    }

    @Test
    void test_visitedNodesReturnsEmptyWithoutTraversingFirst() {
        var alphaVal = "A";
        var alpha = new MyGraphNode<>(alphaVal);
        var sut = new MyGraph<>(alpha);
        var expectedCount = 1;
        var expectedResult = 0;
        var visitedNodeValues = sut.getVisitedNodes();

        assertEquals(expectedCount, sut.getCount());
        assertEquals(expectedResult, visitedNodeValues.size());
    }

    @Test
    void test_findVertexIntegerValueBreadthFirstSucceeds() {
        assertTrue(false);
    }

    @Test
    void test_findVertexStringValueBreadthFirstSucceeds() {
        assertTrue(false);
    }
}
