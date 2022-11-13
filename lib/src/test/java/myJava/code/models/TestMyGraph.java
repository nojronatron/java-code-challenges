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
    @Test void test_GetVisitedNodeValuesReturnsCorrectValuesInAnArray() {
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

        int expectedResultLength = 6;
        int[] expectedResult = new int[]{ 11, 33, 22, 44, 66, 55 };
        MyGraphNode[] expectedVertexList = new MyGraphNode[]{ alpha, charlie, bravo, delta, foxtrot, echo };

        MyGraph sut = new MyGraph();

        List<MyGraphNode> resultList = sut.depthFirstTraversal(alpha);
        MyGraphNode[] visitedNodes = resultList.toArray(MyGraphNode[]::new);
        assertEquals(expectedResultLength, visitedNodes.length);
        assertArrayEquals(expectedVertexList, visitedNodes);

        int[] actualResult = sut.getVisitedNodeValues();
        assertArrayEquals(expectedResult, actualResult);
    }
    @Test void test_GetVisitedNodesListReturnsCorrectVertices() {
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

        int expectedResultLength = 6;
        MyGraphNode[] expectedVertexList = new MyGraphNode[]{ alpha, charlie, bravo, delta, foxtrot, echo };

        MyGraph sut = new MyGraph();

        List<MyGraphNode> resultList = sut.depthFirstTraversal(alpha);
        MyGraphNode[] visitedNodes = resultList.toArray(MyGraphNode[]::new);
        assertEquals(expectedResultLength, visitedNodes.length);
        assertArrayEquals(expectedVertexList, visitedNodes);

        MyGraphNode[] actualResult = sut.getVisitedNodes();
        assertArrayEquals(expectedVertexList, actualResult);
    }
    @Test void test_EmptyGraphReturnsEmptyAdjacencyList() {
        MyGraph sut = new MyGraph();

        List<MyGraphNode> breadthResultList = sut.breadthFirstTraversal(null);
        assertNull(breadthResultList);

        List<MyGraphNode> depthResultList = sut.depthFirstTraversal(null);
        assertNull(depthResultList);
    }
    @Test void test_DisconnectedNodeNotTraversedInDisconnectedGraph() {
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
        assertTrue(foxtrot.addNeighbor(delta)); // considered disconnected node in directed graph unless it is root

        MyGraphNode[] expectedResult = new MyGraphNode[]{ alpha, bravo, charlie, delta, echo };

        MyGraph sut = new MyGraph();

        List<MyGraphNode> resultList = sut.depthFirstTraversal(alpha);
        MyGraphNode[] actualResult = resultList.toArray(MyGraphNode[]::new);

        assertArrayEquals(expectedResult, actualResult);
    }
    @Test void test_WeightedGraphTraversal() {
        // TODO: code is boilerplate. implement this unit test.
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
    @Test void test_AddNodeToGraphIncreasesAdjacencyListSize() {
        int expectedAlphaNodeValue = 11;
        int expectedBravoNodeValue = 22;

        MyGraph sut = new MyGraph();

        int expectedCount = 0;
        assertEquals(expectedCount, sut.getGraphSize());

        assertTrue(sut.addNode(expectedAlphaNodeValue));

        expectedCount = 1;
        assertEquals(expectedCount, sut.getGraphSize());

        MyGraphNode bravo = new MyGraphNode(expectedBravoNodeValue);
        assertTrue(sut.addNode(bravo));

        expectedCount = 2;
        assertEquals(expectedCount, sut.getGraphSize());
    }
    @Test void test_RemoveNodeReducesAdjacencyListSize() {
        int expectedAlphaNodeValue = 11;
        int expectedBravoNodeValue = 22;

        MyGraph sut = new MyGraph();

        int expectedCount = 0;
        assertEquals(expectedCount, sut.getGraphSize());
        assertTrue(sut.addNode(expectedAlphaNodeValue));
        MyGraphNode bravo = new MyGraphNode(expectedBravoNodeValue);
        assertTrue(sut.addNode(bravo));
        expectedCount = 2;
        assertEquals(expectedCount, sut.getGraphSize());

        MyGraphNode result = sut.removeNode(bravo);
        assertEquals(bravo, result);

        expectedCount = 1;
        assertEquals(expectedCount, sut.getGraphSize());
    }
    @Test void test_RemovingValidNodeDoesNotThrow() {
        int expectedAlphaNodeValue = 11;
        int expectedBravoNodeValue = 22;

        MyGraph sut = new MyGraph();

        int expectedCount = 0;
        assertEquals(expectedCount, sut.getGraphSize());
        assertTrue(sut.addNode(expectedAlphaNodeValue));
        MyGraphNode bravo = new MyGraphNode(expectedBravoNodeValue);
        assertTrue(sut.addNode(bravo));
        expectedCount = 2;
        assertEquals(expectedCount, sut.getGraphSize());

        assertDoesNotThrow(()->{
            sut.removeNode(bravo);
        });

        expectedCount = 1;
        assertEquals(expectedCount, sut.getGraphSize());
    }
    @Test void test_GetNodeFromGraphReturnsFirstVertexInAdjacencyList() {
        int expectedAlphaNodeValue = 11;
        int expectedBravoNodeValue = 22;
        int expectedCharlieNodeValue = 33;

        int expectedAdjacencyListSize = 1;
        var sut = new MyGraph();

        var alphaGraphNode = new MyGraphNode(expectedAlphaNodeValue);
        var bravoGraphNode = new MyGraphNode(expectedBravoNodeValue);
        var charlieGraphNode = new MyGraphNode(expectedCharlieNodeValue);

        assertTrue(sut.addNode(alphaGraphNode));
        MyGraphNode actualAdjacencyListVertex = sut.getNodeFromGraph();
        assertEquals(expectedAdjacencyListSize, sut.getGraphSize());
        assertEquals(alphaGraphNode, actualAdjacencyListVertex);

        assertTrue(alphaGraphNode.addNeighbor(bravoGraphNode));
        assertTrue(alphaGraphNode.addNeighbor(charlieGraphNode));

        actualAdjacencyListVertex = sut.getNodeFromGraph();
        assertEquals(alphaGraphNode, actualAdjacencyListVertex);
    }
    @Test void test_RemoveVertexFromGraphReducesAdjacencyListAndRemovesEdgeFromVertex() {
        //  TODO: Refactor Vertex and Graph code because Adjacency List does not get updated when
        //  a vertext with neighbors is added.
        int expectedAlphaNodeValue = 11;
        int expectedBravoNodeValue = 22;
        int expectedCharlieNodeValue = 33;
        int expectedAdjacencyListSize = 1;

        var sut = new MyGraph();

        var alphaGraphNode = new MyGraphNode(expectedAlphaNodeValue);
        var bravoGraphNode = new MyGraphNode(expectedBravoNodeValue);
        var charlieGraphNode = new MyGraphNode(expectedCharlieNodeValue);

        assertTrue(alphaGraphNode.addNeighbor(bravoGraphNode));
        assertTrue(alphaGraphNode.addNeighbor(charlieGraphNode));
        assertTrue(bravoGraphNode.addNeighbor(charlieGraphNode));

        assertTrue(sut.addNode(alphaGraphNode));
        assertEquals(expectedAdjacencyListSize, sut.getGraphSize());

        MyGraphNode firstVertex = sut.getNodeFromGraph();
        assertEquals(alphaGraphNode, firstVertex);

        MyGraphNode removeResult = sut.removeNode(bravoGraphNode);
        var adjacencyListSize = sut.getGraphSize();

        assertTrue(removeResult.removeNeighbor(charlieGraphNode));
    }
}
