package myJava.code.challenges;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestEnhancedBrowserNavHistory {
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
        sut.enhancedGo(expectedAddress);
        assertEquals(1, sut.getCount());
    }
    @Test
    public void test_GoAddsItemToOccupiedList() {
        String expectedAddress1 = "uri-1";
        String expectedAddress2 = "uri-2";
        var sut = new BrowserNavHistory();
        assertEquals(0, sut.getCount());
        sut.enhancedGo(expectedAddress1);
        assertEquals(1, sut.getCount());
        assertTrue(sut.contains(expectedAddress1));
        sut.enhancedGo(expectedAddress2);
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
        sut.enhancedGo(expectedAddress);
        assertEquals(1, sut.getCount());
        assertEquals(expectedAddress, sut.getHead());
        assertEquals(expectedAddress, sut.getTail());
        assertEquals(expectedResult, sut.enhancedForward());
    }
    @Test
    public void test_ForwardToNodeWithValue() {
        String expectedAddress1 = "uri-1";
        String expectedAddress2 = "uri-2";
        var sut = new BrowserNavHistory();
        assertEquals(0, sut.getCount());
        sut.enhancedGo(expectedAddress1);
        assertEquals(1, sut.getCount());
        assertTrue(sut.contains(expectedAddress1));
        sut.enhancedGo(expectedAddress2);
        assertEquals(2, sut.getCount());
        assertEquals(expectedAddress1, sut.enhancedBack());
        assertEquals(expectedAddress2, sut.enhancedForward());
    }
    @Test
    public void test_BackToHeadNode() {
        String expectedAddress1 = "uri-1";
        String expectedAddress2 = "uri-2";
        var sut = new BrowserNavHistory();
        assertEquals(0, sut.getCount());
        sut.enhancedGo(expectedAddress1);
        assertEquals(1, sut.getCount());
        assertTrue(sut.contains(expectedAddress1));
        sut.enhancedGo(expectedAddress2);
        assertEquals(2, sut.getCount());
        assertEquals(expectedAddress2, sut.getHead());
        assertEquals(expectedAddress1, sut.getTail());
    }
    @Test
    public void test_BackToNodeWithValue() {
        String expectedAddress1 = "uri-1";
        String expectedAddress2 = "uri-2";
        String expectedAddress3 = "uri-3";
        var sut = new BrowserNavHistory();
        assertEquals(0, sut.getCount());

        sut.enhancedGo(expectedAddress1);   //  uri-1 -> null
        assertEquals(1, sut.getCount());
        assertTrue(sut.contains(expectedAddress1));

        sut.enhancedGo(expectedAddress2);   //  uri-2 -> uri-1 -> null
        assertEquals(2, sut.getCount());
        assertTrue(sut.contains(expectedAddress1));
        assertTrue(sut.contains(expectedAddress2));
        assertEquals(expectedAddress1, sut.enhancedBack());

        sut.enhancedGo(expectedAddress3);   //  uri-2 -> uri-3 > uri-1 -> null
        assertEquals(3, sut.getCount());
        assertTrue(sut.contains(expectedAddress3));
        assertEquals(expectedAddress1, sut.enhancedBack());
    }
    @Test
    public void test_GoGoBackForwardWorksAsExpected() {
        String expectedAddress1 = "uri-1";
        String expectedAddress2 = "uri-2";
        var sut = new BrowserNavHistory();
        assertEquals(0, sut.getCount());
        sut.enhancedGo(expectedAddress1);
        assertEquals(1, sut.getCount());
        assertTrue(sut.contains(expectedAddress1));
        sut.enhancedGo(expectedAddress2);
        assertEquals(2, sut.getCount());
        assertEquals(expectedAddress1, sut.enhancedBack());
        assertEquals(expectedAddress2, sut.enhancedForward());
    }
}
