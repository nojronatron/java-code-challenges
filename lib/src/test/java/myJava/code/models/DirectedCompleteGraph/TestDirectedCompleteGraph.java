package myJava.code.models.DirectedCompleteGraph;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
        System.out.println(sut);

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

        System.out.println(sut);

        alpha.setEdge(bravo, 1);
        alpha.setEdge(charlie, 1);
        bravo.setEdge(delta, 3);
        charlie.setEdge(delta, 2);
        delta.setEdge(charlie, 3);

        System.out.println(sut);

        var expectedNodesInGraph = 4;
        assertEquals(expectedNodesInGraph, sut.getCount());
    }

    @Test
    void test_findVertexStringValueBreadthFirstSucceeds() {
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

        System.out.println(sut);

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
        System.out.println(sut);
        assertEquals(expectedCount, sut.getCount());

        sut.removeVertex(alpha);
        expectedCount--;
        System.out.println(sut);
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
        System.out.println(sut);
        assertEquals(expectedCount, sut.getCount());

        sut.removeVertex(delta);
        expectedCount --;
        System.out.println(sut);
        assertEquals(expectedCount, sut.getCount());
    }

    @Test
    void test_findWeightBetweenTwoGraphNodes() {
        var alpha = new MyGraphNode<>("A");
        var bravo = new MyGraphNode<>("B");
        var charlie = new MyGraphNode<>("C");
        var delta = new MyGraphNode<>("D");
        var echo = new MyGraphNode<>("E");
        var foxtrot = new MyGraphNode<>("F");
        var golf = new MyGraphNode<>("G");
        var hotel = new MyGraphNode<>("H");
        var juliet = new MyGraphNode<>("J");
        var sut = new MyGraph<>(alpha);

        sut.addVertex(bravo);
        sut.addVertex(charlie);
        sut.addVertex(delta);
        sut.addVertex(echo);
        sut.addVertex(foxtrot);
        sut.addVertex(golf);
        sut.addVertex(hotel);
        sut.addVertex(juliet);

        alpha.setEdge(bravo, 1);
        alpha.setEdge(charlie, 2);
        alpha.setEdge(delta, 1);

        bravo.setEdge(echo, 1);
        bravo.setEdge(foxtrot, 3);
        charlie.setEdge(golf, 3);
        delta.setEdge(hotel, 1);
        delta.setEdge(juliet, 1);

        System.out.println(sut);

        var expectedResult = 5;
        var actualResult = sut.getWeightBetweenVertices(alpha, golf);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test_findWeightBetweenTwoGraphNodesLarger() {
        var alpha = new MyGraphNode<>("A");
        var bravo = new MyGraphNode<>("B");
        var charlie = new MyGraphNode<>("C");
        var delta = new MyGraphNode<>("D");
        var echo = new MyGraphNode<>("E");
        var foxtrot = new MyGraphNode<>("F");
        var golf = new MyGraphNode<>("G");
        var hotel = new MyGraphNode<>("H");
        var juliet = new MyGraphNode<>("J");
        var kilo = new MyGraphNode<>("K");
        var lima = new MyGraphNode<>("L");
        var mike = new MyGraphNode<>("M");
        var november = new MyGraphNode<>("N");
        var sut = new MyGraph<>(alpha);

        sut.addVertex(bravo);
        sut.addVertex(charlie);
        sut.addVertex(delta);
        sut.addVertex(echo);
        sut.addVertex(foxtrot);
        sut.addVertex(golf);
        sut.addVertex(hotel);
        sut.addVertex(juliet);
        sut.addVertex(kilo);
        sut.addVertex(lima);
        sut.addVertex(mike);
        sut.addVertex(november);

        alpha.setEdge(bravo, 1);
        alpha.setEdge(charlie, 2);
        alpha.setEdge(delta, 3);
        bravo.setEdge(echo, 2);
        bravo.setEdge(foxtrot, 2);
        charlie.setEdge(golf, 4);
        delta.setEdge(hotel, 6);
        delta.setEdge(juliet, 6);
        foxtrot.setEdge(kilo, 3);
        foxtrot.setEdge(lima, 3);
        hotel.setEdge(mike, 9);
        juliet.setEdge(november, 9);

        System.out.println(sut);

        var expectedResult = 9;
        var actualResult = sut.getWeightBetweenVertices(alpha, juliet);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test_findWeightBetweenTwoMiddleZoneGraphNodes() {
        var alpha = new MyGraphNode<>("A");
        var bravo = new MyGraphNode<>("B");
        var charlie = new MyGraphNode<>("C");
        var delta = new MyGraphNode<>("D");
        var echo = new MyGraphNode<>("E");
        var foxtrot = new MyGraphNode<>("F");
        var golf = new MyGraphNode<>("G");
        var hotel = new MyGraphNode<>("H");
        var juliet = new MyGraphNode<>("J");
        var kilo = new MyGraphNode<>("K");
        var lima = new MyGraphNode<>("L");
        var mike = new MyGraphNode<>("M");
        var november = new MyGraphNode<>("N");
        var sut = new MyGraph<>(alpha);

        sut.addVertex(bravo);
        sut.addVertex(charlie);
        sut.addVertex(delta);
        sut.addVertex(echo);
        sut.addVertex(foxtrot);
        sut.addVertex(golf);
        sut.addVertex(hotel);
        sut.addVertex(juliet);
        sut.addVertex(kilo);
        sut.addVertex(lima);
        sut.addVertex(mike);
        sut.addVertex(november);

        alpha.setEdge(bravo, 1);
        alpha.setEdge(charlie, 2);
        alpha.setEdge(delta, 3);
        bravo.setEdge(echo, 2);
        bravo.setEdge(foxtrot, 2);
        charlie.setEdge(golf, 4);
        delta.setEdge(hotel, 6);
        delta.setEdge(juliet, 6);
        foxtrot.setEdge(kilo, 3);
        foxtrot.setEdge(lima, 3);
        hotel.setEdge(mike, 9);
        juliet.setEdge(november, 9);
        kilo.setEdge(lima, 1);

        System.out.println(sut);

        var expectedResult = new ArrayList<Integer>();
        expectedResult.add(6);
        expectedResult.add(7);

        var actualResult = sut.getWeightBetweenVertices(alpha, lima);
        System.out.printf("Discovered path weight: %s%n", actualResult);
        assertTrue(expectedResult.contains( actualResult));
    }

    @Test
    void test_findWeightBetweenNodesInGraphWithMergingPaths() {
        var alpha = new MyGraphNode<>("A");
        var bravo = new MyGraphNode<>("B");
        var charlie = new MyGraphNode<>("C");
        var delta = new MyGraphNode<>("D");
        var echo = new MyGraphNode<>("E");
        var foxtrot = new MyGraphNode<>("F");
        var golf = new MyGraphNode<>("G");
        var hotel = new MyGraphNode<>("H");
        var juliet = new MyGraphNode<>("J");
        var kilo = new MyGraphNode<>("K");
        var lima = new MyGraphNode<>("L");
        var mike = new MyGraphNode<>("M");
        var november = new MyGraphNode<>("N");
        var sut = new MyGraph<>(alpha);

        sut.addVertex(bravo);
        sut.addVertex(charlie);
        sut.addVertex(delta);
        sut.addVertex(echo);
        sut.addVertex(foxtrot);
        sut.addVertex(golf);
        sut.addVertex(hotel);
        sut.addVertex(juliet);
        sut.addVertex(kilo);
        sut.addVertex(lima);
        sut.addVertex(mike);
        sut.addVertex(november);

        alpha.setEdge(bravo, 1);
        alpha.setEdge(charlie, 2);
        alpha.setEdge(delta, 3);
        bravo.setEdge(echo, 2);
        bravo.setEdge(foxtrot, 2);
        charlie.setEdge(golf, 4);
        delta.setEdge(hotel, 6);
        delta.setEdge(juliet, 6);
        foxtrot.setEdge(kilo, 3);
        foxtrot.setEdge(lima, 3);
        foxtrot.setEdge(golf, 6);
        golf.setEdge(mike, 6);
        hotel.setEdge(mike, 9);
        juliet.setEdge(november, 9);
        kilo.setEdge(lima, 1);

        System.out.println(sut);

        var expectedResult = new ArrayList<Integer>();
        expectedResult.add(20);
        expectedResult.add(17);
        expectedResult.add(18);

        var actualResult = sut.getWeightBetweenVertices(alpha, mike);
        System.out.printf("Discovered path weight: %s%n", actualResult);
        assertTrue(expectedResult.contains( actualResult));
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
        var alphaVal = 11;
        var bravoVal = 22;
        var charlieVal = 33;
        var deltaVal = 44;

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

        System.out.println(sut);

        var result = sut.findVertexBreadthFirst(alpha, deltaVal);

        System.out.printf("Search for [ %s ] found Vertex with value [ %s ].%n", deltaVal, result.getValue());

        assertEquals(delta, result);
    }

}
