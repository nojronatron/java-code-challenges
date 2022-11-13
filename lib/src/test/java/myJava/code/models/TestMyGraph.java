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
    @Test void test_DirectedNonCyclicBreadthFirstTraversalReturnsAllNodesNoDuplicates() {
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
    @Test void test_DirectedCyclicBreadthFirstTraversalReturnsAllNodesNoDuplicates() {
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

        assertTrue(alpha.addNeighbor(charlie));
        assertTrue(charlie.addNeighbor(delta));
        assertTrue(delta.addNeighbor(foxtrot));
        assertTrue(foxtrot.addNeighbor(echo));
        assertTrue(echo.addNeighbor(bravo));
        assertTrue(bravo.addNeighbor(charlie)); // directed edge cyclical point

        MyGraphNode[] expectedResult = new MyGraphNode[]{ alpha, charlie, delta, foxtrot, echo, bravo };

        MyGraph sut = new MyGraph();

        List<MyGraphNode> resultList = sut.breadthFirstTraversal(alpha);
        MyGraphNode[] actualResult = resultList.toArray(MyGraphNode[]::new);

        assertArrayEquals(expectedResult, actualResult);    }
    @Test void test_NonCyclicDepthFirstTraversalReturnsAllNodesNoDuplicates() {
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

        MyGraphNode[] expectedResult = new MyGraphNode[]{ alpha, bravo, charlie, delta, echo, foxtrot };

        MyGraph sut = new MyGraph();

        List<MyGraphNode> resultList = sut.depthFirstTraversal(alpha);
        MyGraphNode[] actualResult = resultList.toArray(MyGraphNode[]::new);

        assertArrayEquals(expectedResult, actualResult);
    }
    @Test void test_CyclicDepthFirstTraversalReturnsAllNodesNoDuplicates() {
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

        assertTrue(alpha.addNeighbor(charlie));
        assertTrue(charlie.addNeighbor(delta));
        assertTrue(delta.addNeighbor(foxtrot));
        assertTrue(foxtrot.addNeighbor(echo));
        assertTrue(echo.addNeighbor(bravo));
        assertTrue(bravo.addNeighbor(charlie)); // directed edge cyclical point

        MyGraphNode[] expectedResult = new MyGraphNode[]{ alpha, charlie, delta, foxtrot, echo, bravo };

        MyGraph sut = new MyGraph();

        List<MyGraphNode> resultList = sut.depthFirstTraversal(alpha);
        MyGraphNode[] actualResult = resultList.toArray(MyGraphNode[]::new);

        assertArrayEquals(expectedResult, actualResult);
    }
    @Test void test_UndirectedDepthFirstTraversalReturnsAllNodesNoDuplicates() {
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
        assertTrue(bravo.addNeighbor(alpha));
        assertTrue(bravo.addNeighbor(charlie));
        assertTrue(charlie.addNeighbor(bravo));
        assertTrue(charlie.addNeighbor(delta));
        assertTrue(delta.addNeighbor(charlie));
        assertTrue(delta.addNeighbor(echo));
        assertTrue(echo.addNeighbor(delta));
        assertTrue(echo.addNeighbor(foxtrot));
        assertTrue(foxtrot.addNeighbor(echo));

        MyGraphNode[] expectedResult = new MyGraphNode[]{ alpha, bravo, charlie, delta, echo, foxtrot };

        MyGraph sut = new MyGraph();

        List<MyGraphNode> resultList = sut.depthFirstTraversal(alpha);
        MyGraphNode[] actualResult = resultList.toArray(MyGraphNode[]::new);

        assertArrayEquals(expectedResult, actualResult);
    }
    @Test void test_UndirectedCyclicDepthFirstTraversalReturnsAllNodesNoDuplicates() {
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

        assertTrue(alpha.addNeighbor(charlie));
        assertTrue(charlie.addNeighbor(alpha));

        assertTrue(charlie.addNeighbor(alpha));
        assertTrue(charlie.addNeighbor(bravo));
        assertTrue(charlie.addNeighbor(delta));

        assertTrue(delta.addNeighbor(charlie));
        assertTrue(delta.addNeighbor(foxtrot));

        assertTrue(foxtrot.addNeighbor(delta));
        assertTrue(foxtrot.addNeighbor(echo));

        assertTrue(echo.addNeighbor(bravo));
        assertTrue(echo.addNeighbor(foxtrot));

        MyGraphNode[] expectedResult = new MyGraphNode[]{ alpha, charlie, bravo, delta, foxtrot, echo };

        MyGraph sut = new MyGraph();

        List<MyGraphNode> resultList = sut.depthFirstTraversal(alpha);
        MyGraphNode[] actualResult = resultList.toArray(MyGraphNode[]::new);

        assertArrayEquals(expectedResult, actualResult);
    }
    @Test void test_EmptyGraphReturnsEmptyAdjacencyList() {
        MyGraphNode[] expectedResult = new MyGraphNode[]{ };

        MyGraph sut = new MyGraph();

        List<MyGraphNode> breadthResultList = sut.breadthFirstTraversal(null);
        assertNull(breadthResultList);

        List<MyGraphNode> depthResultList = sut.depthFirstTraversal(null);
        assertNull(depthResultList);
    }
    @Test void test_DisconnectedNodeNotTraversedInDisconnectedGraphs() {

    }
    @Test void test_WeightedGraphTraversal() {

    }
}
