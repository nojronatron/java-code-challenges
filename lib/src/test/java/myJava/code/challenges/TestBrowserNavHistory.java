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
        var sut = new BrowserNavHistory();
        assertEquals(0, sut.getCount());
        sut.go("uri-1");
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

    }
    @Test
    public void test_ForwardToNodeWithValue() {

    }
    @Test
    public void test_BackToHeadNode() {

    }
    @Test
    public void test_BackToNodeWithValue() {

    }
    @Test
    public void test_GoGoBackGoForwardWorksAsExpected() {

    }
}
