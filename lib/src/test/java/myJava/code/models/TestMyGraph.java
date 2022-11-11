package myJava.code.models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestMyGraph {
    @Test void test_CanInstantiateMyGraphClass() {
        MyGraph sut = new MyGraph();
        assertNotNull(sut);
    }
    @Test void test_CanInstantiateNode() {
        int expectedValue = 11;
        var sut = new MyGraphNode(expectedValue);
        assertNotNull(sut);
        int actualValue = sut.getValue();
        assertEquals(expectedValue, actualValue);
    }
    @Test void test_CanInstantiateEdge() {
        int expectedNeighborValue = 22;
        int expectedEdgeWeight = 3;
        var neighbor = new MyGraphNode(expectedNeighborValue);
        var sut = new MyGraphEdge(neighbor, expectedEdgeWeight);

        assertNotNull(sut);

        int actualEdgeWeight = sut.getWeight();

        assertEquals(expectedEdgeWeight, actualEdgeWeight);
    }
    @Test void test_NodeCanHaveEdgeWithNeighborAttached() {
        int expectedValue = 11;
        int expectedNeighborValue = 22;
        int expectedEdgeWeight = 3;
        int expectedEdgeListSize = 1;
        var sut = new MyGraphNode(expectedValue);
        var neighbor = new MyGraphNode(expectedNeighborValue);

        assertTrue(sut.addNeighbor(neighbor, expectedEdgeWeight));

        int actualValue = sut.getValue();
        assertEquals(expectedValue, actualValue);

        List<MyGraphEdge> edges = sut.getEdges();
        assertEquals(expectedEdgeListSize, edges.size());

        int actualEdgeWeight = edges.get(0).getWeight();
        assertEquals(expectedEdgeWeight, actualEdgeWeight);
    }
    @Test void test_GraphNodeEdgeCanPointToSameGraphNode() {
        int expectedValue = 11;
        int expectedNeighborValue = 11;
        int expectedEdgeWeight = 0;
        int expectedEdgeListSize = 1;
        var sut = new MyGraphNode(expectedValue);

        assertTrue(sut.addNeighbor(sut, expectedEdgeWeight));

        int actualValue = sut.getValue();
        assertEquals(expectedValue, actualValue);

        List<MyGraphEdge> edges = sut.getEdges();
        assertEquals(expectedEdgeListSize, edges.size());

        int actualEdgeWeight = edges.get(0).getWeight();
        assertEquals(expectedEdgeWeight, actualEdgeWeight);

        ArrayList<MyGraphNode> actualNeighborNode = sut.getNeighbors();
        assertEquals(expectedEdgeListSize, actualNeighborNode.size());

        int actualNeighborValue = sut.getNeighbors().get(0).getValue();
        assertEquals(expectedNeighborValue, actualNeighborValue);
    }
    @Test void test_AdjacencyListPopulatesCorrectly() {
        int expectedAlphaNodeValue = 11;
        int expectedBravoNodeValue = 22;
        int expectedCharlieNodeValue = 33;

        int expectedEdgeWeightThree = 3;
        int expectedEdgeWeightFour = 4;
        int expectedEdgeWeightFive = 5;

        int expectedAdjacencyListSize = 3;
        var sut = new MyGraph();

        var alphaGraphNode = new MyGraphNode(expectedAlphaNodeValue);
        var bravoGraphNode = new MyGraphNode(expectedBravoNodeValue);
        var charlieGraphNode = new MyGraphNode(expectedCharlieNodeValue);

        assertTrue(alphaGraphNode.addNeighbor(bravoGraphNode, expectedEdgeWeightThree));
        assertTrue(alphaGraphNode.addNeighbor(charlieGraphNode, expectedEdgeWeightFour));
        assertTrue(bravoGraphNode.addNeighbor(charlieGraphNode, expectedEdgeWeightFive));

        assertTrue(sut.addNode(alphaGraphNode));
        assertTrue(sut.addNode(bravoGraphNode));
        assertTrue(sut.addNode(charlieGraphNode));
        assertEquals(expectedAdjacencyListSize, sut.getGraphSize());
    }
    @Test void test_NonCyclicBreadthFirstTraversalReturnsAllNodesNoDuplicates() {
        int expectedAlphaNodeValue = 11;
        int expectedBravoNodeValue = 22;
        int expectedCharlieNodeValue = 33;
        int expectedDeltaNodeValue = 44;
        int expectedEchoNodeValue = 55;
        int expectedFoxtrotNodeValue = 66;

        MyGraphNode alpha = new MyGraphNode(expectedAlphaNodeValue);
        MyGraphNode bravo = new MyGraphNode(expectedBravoNodeValue);
        MyGraphNode charlie = new MyGraphNode(expectedCharlieNodeValue);
        MyGraphNode delta = new MyGraphNode(expectedDeltaNodeValue);
        MyGraphNode echo = new MyGraphNode(expectedEchoNodeValue);
        MyGraphNode foxtrot = new MyGraphNode(expectedFoxtrotNodeValue);

        assertTrue(alpha.addNeighbor(bravo));
        assertTrue(alpha.addNeighbor(charlie));
        assertTrue(bravo.addNeighbor(charlie));
        assertTrue(bravo.addNeighbor(echo));
        assertTrue(charlie.addNeighbor(delta));
        assertTrue(delta.addNeighbor(echo));
        assertTrue(delta.addNeighbor(foxtrot));
        assertTrue(foxtrot.addNeighbor(echo));

        MyGraphNode[] expectedResult = new MyGraphNode[]{ alpha, bravo, charlie, echo, delta, foxtrot };

        MyGraph sut = new MyGraph();

        List<MyGraphNode> resultList = sut.breadthFirstTraversal(alpha);
        MyGraphNode[] actualResult = resultList.toArray(MyGraphNode[]::new);

        assertArrayEquals(expectedResult, actualResult);
    }
    @Test void test_CyclicBreadthFirstTraversalReturnsAllNodesNoDuplicates() {
        int expectedAlphaNodeValue = 11;
        int expectedBravoNodeValue = 22;
        int expectedCharlieNodeValue = 33;
        int expectedDeltaNodeValue = 44;
        int expectedEchoNodeValue = 55;
        int expectedFoxtrotNodeValue = 66;

        MyGraphNode alpha = new MyGraphNode(expectedAlphaNodeValue);
        MyGraphNode bravo = new MyGraphNode(expectedBravoNodeValue);
        MyGraphNode charlie = new MyGraphNode(expectedCharlieNodeValue);
        MyGraphNode delta = new MyGraphNode(expectedDeltaNodeValue);
        MyGraphNode echo = new MyGraphNode(expectedEchoNodeValue);
        MyGraphNode foxtrot = new MyGraphNode(expectedFoxtrotNodeValue);

        assertTrue(alpha.addNeighbor(bravo));
        assertTrue(alpha.addNeighbor(charlie));
        assertTrue(bravo.addNeighbor(charlie)); // undirected edge in graph
        assertTrue(bravo.addNeighbor(echo)); // undirected ege in graph
        assertTrue(charlie.addNeighbor(delta)); // undirected ege in graph
        assertTrue(charlie.addNeighbor(bravo)); // undirected edge in graph
        assertTrue(delta.addNeighbor(echo));
        assertTrue(delta.addNeighbor(foxtrot));
        assertTrue(delta.addNeighbor(charlie)); // undirected ege in graph
        assertTrue(echo.addNeighbor(bravo)); // undirected ege in graph
        assertTrue(foxtrot.addNeighbor(echo));

        MyGraphNode[] expectedResult = new MyGraphNode[]{ alpha, bravo, charlie, echo, delta, foxtrot };

        MyGraph sut = new MyGraph();

        List<MyGraphNode> resultList = sut.breadthFirstTraversal(alpha);
        MyGraphNode[] actualResult = resultList.toArray(MyGraphNode[]::new);

        assertArrayEquals(expectedResult, actualResult);    }
    @Test void test_NonCyclicDepthFirstTraversalReturnsAllNodesNoDuplicates() {

    }
    @Test void test_CyclicDepthFirstTraversalReturnsAllNodesNoDuplicates() {

    }
    @Test void test_DirectedNonCyclicBreadthFirstTraversalReturnsAllNodesNoDuplicates() {

    }
    @Test void test_DirectedCyclicBreadthFirstTraversalReturnsAllNodesNoDuplicates() {

    }
    @Test void test_UndirectedNonCyclicDepthFirstTraversalReturnsAllNodesNoDuplicates() {

    }
    @Test void test_UndirectedCyclicDepthFirstTraversalReturnsAllNodesNoDuplicates() {

    }
    @Test void test_EmptyGraphReturnsEmptyAdjacencyList() {

    }
    @Test void test_DisconnectedNodeNoteTraversedInDisconnectedGraphs() {

    }
    @Test void test_WeightedGraphTraversal() {

    }
}
