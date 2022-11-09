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
        var actualValue = sut.getValue();
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
    }
    @Test void test_AdjacencyListPopulatesCorrectly() {
        int expectedAlphaNodeValue = 11;
        int expectedBravoNodeValue = 22;
        int expectedCharlieNodeValue = 33;
        int expectedEdgeWeightThree = 3;
        int expectedEdgeWeightFour = 4;
        int expectedEdgeWeightFive = 5;
        int expectedEdgeListSize = 3;
        var sut = new MyGraph();

        var alphaGraphNode = new MyGraphNode(expectedAlphaNodeValue);
        var bravoGraphNode = new MyGraphNode(expectedBravoNodeValue);
        var charlieGraphNode = new MyGraphNode(expectedCharlieNodeValue);

        alphaGraphNode.addNeighbor(bravoGraphNode, expectedEdgeWeightThree);
        alphaGraphNode.addNeighbor(charlieGraphNode, expectedEdgeWeightFour);
        bravoGraphNode.addNeighbor(charlieGraphNode, expectedEdgeWeightFive);

        assertTrue(graphNode.addNeighbor(neighbor, expectedEdgeWeight));

        int actualValue = graphNode.getValue();
        assertEquals(expectedValue, actualValue);

        List<MyGraphEdge> edges = graphNode.getEdges();
        assertEquals(expectedEdgeListSize, edges.size());

        int actualEdgeWeight = edges.get(0).getWeight();
        assertEquals(expectedEdgeWeight, actualEdgeWeight);
    }
}
