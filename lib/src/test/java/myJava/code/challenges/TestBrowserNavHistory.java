package myJava.code.challenges;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestBrowserNavHistory {
    @Test
    public void test_CanInstantiateBrowserNavHistoryClass() {
        var sut = new BrowserNavHistory();
        assertNotNull(sut);
    }
    @Test
    public void test_GoAddsItemToEmptyList() {
        String expectedAddress = "uri-1";
        var sut = new BrowserNavHistory();
        assertEquals(0, sut.getCount());
        sut.go(expectedAddress);
        assertEquals(1, sut.getCount());
    }
    @Test
    public void test_GoAddsItemToOccupiedList() {
        String expectedAddress1 = "uri-1";
        String expectedAddress2 = "uri-2";
        var sut = new BrowserNavHistory();
        assertEquals(0, sut.getCount());
        sut.go(expectedAddress1);
        assertEquals(1, sut.getCount());
        assertTrue(sut.contains(expectedAddress1));
        sut.go(expectedAddress2);
        assertEquals(2, sut.getCount());
        assertTrue(sut.contains(expectedAddress2));
        assertEquals(expectedAddress1, sut.getTail());
        assertEquals(expectedAddress2, sut.getHead());
    }
    @Test
    public void test_ForwardToNullNodeReturnsBlankString() {
        String expectedAddress = "uri-1";
        String expectedResult = "";
        var sut = new BrowserNavHistory();
        assertEquals(0, sut.getCount());
        sut.go(expectedAddress);
        assertEquals(1, sut.getCount());
        assertEquals(expectedAddress, sut.getHead());
        assertEquals(expectedAddress, sut.getTail());
        assertEquals(expectedResult, sut.forward());
    }
    @Test
    public void test_ForwardToNodeWithValue() {
        String expectedAddress1 = "uri-1";
        String expectedAddress2 = "uri-2";
        var sut = new BrowserNavHistory();
        assertEquals(0, sut.getCount());
        sut.go(expectedAddress1);
        assertEquals(1, sut.getCount());
        assertTrue(sut.contains(expectedAddress1));
        sut.go(expectedAddress2);
        assertEquals(2, sut.getCount());
        assertEquals(expectedAddress1, sut.back());
        assertEquals(expectedAddress2, sut.forward());
    }
    @Test
    public void test_BackToHeadNode() {
        String expectedAddress1 = "uri-1";
        String expectedAddress2 = "uri-2";
        var sut = new BrowserNavHistory();
        assertEquals(0, sut.getCount());
        sut.go(expectedAddress1);
        assertEquals(1, sut.getCount());
        assertTrue(sut.contains(expectedAddress1));
        sut.go(expectedAddress2);
        assertEquals(2, sut.getCount());
        assertEquals(expectedAddress1, sut.back());
    }
    @Test
    public void test_BackToNodeWithValue() {
        String expectedAddress1 = "uri-1";
        String expectedAddress2 = "uri-2";
        String expectedAddress3 = "uri-3";
        var sut = new BrowserNavHistory();
        assertEquals(0, sut.getCount());
        sut.go(expectedAddress1);
        assertEquals(1, sut.getCount());
        assertTrue(sut.contains(expectedAddress1));
        sut.go(expectedAddress2);
        assertEquals(2, sut.getCount());
        assertEquals(expectedAddress1, sut.back());
        sut.go(expectedAddress3);
        assertEquals(3, sut.getCount());
        assertEquals(expectedAddress2, sut.back());
    }
    @Test
    public void test_GoGoBackForwardWorksAsExpected() {
        String expectedAddress1 = "uri-1";
        String expectedAddress2 = "uri-2";
        String expectedAddress3 = "uri-3";
        var sut = new BrowserNavHistory();
        assertEquals(0, sut.getCount());
        sut.go(expectedAddress1);
        assertEquals(1, sut.getCount());
        assertTrue(sut.contains(expectedAddress1));
        sut.go(expectedAddress2);
        assertEquals(2, sut.getCount());
        assertEquals(expectedAddress1, sut.back());
        sut.go(expectedAddress3);
        assertEquals(3, sut.getCount());
        assertEquals(expectedAddress2, sut.back());
        assertEquals(3, sut.getCount());
        assertEquals(expectedAddress3, sut.forward());
    }
}
