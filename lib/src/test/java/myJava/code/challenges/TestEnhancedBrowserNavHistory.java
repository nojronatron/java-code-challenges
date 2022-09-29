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
    public void test_GoDoesNotThrowWhenGivenBlankOrSpaceInput() {
        String blank = "";
        String singleSpace = " ";
        String twoSpaces = "  ";
        String elevenSpaces = "           ";
        var sut = new BrowserNavHistory();

        assertEquals(0, sut.getCount());

        assertDoesNotThrow(()->{
            sut.enhancedGo(blank);
            sut.enhancedGo(singleSpace);
            sut.enhancedGo(twoSpaces);
            sut.enhancedGo(elevenSpaces);
        });

        assertEquals(0, sut.getCount());
    }
    @Test
    public void test_GoAddsItemToEmptyList() {
        String expectedAddress = "http://u.ri/1";
        var sut = new BrowserNavHistory();
        assertEquals(0, sut.getCount());
        sut.enhancedGo(expectedAddress);
        assertEquals(1, sut.getCount());
    }
    @Test
    public void test_GoAddsItemToOccupiedList() {
        String expectedAddress1 = "http://u.ri/1";
        String expectedAddress2 = "http://u.ri/2";
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
        String expectedAddress = "http://u.ri/1";
        var sut = new BrowserNavHistory();
        assertEquals(0, sut.getCount());
        sut.enhancedGo(expectedAddress);
        assertEquals(1, sut.getCount());
        assertEquals(expectedAddress, sut.getHead());
        assertEquals(expectedAddress, sut.getTail());
        assertEquals(expectedAddress, sut.enhancedForward());
    }
    @Test
    public void test_ForwardToNodeWithValue() {
        String expectedAddress1 = "http://u.ri/1";
        String expectedAddress2 = "http://u.ri/2";
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
        String expectedAddress1 = "http://u.ri/1";
        String expectedAddress2 = "http://u.ri/2";
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
        String expectedAddress1 = "http://u.ri/1";
        String expectedAddress2 = "http://u.ri/2";
        String expectedAddress3 = "http://u.ri/3";
        var sut = new BrowserNavHistory();
        assertEquals(0, sut.getCount());

        sut.enhancedGo(expectedAddress1);   //  http://u.ri/1 -> null
        assertEquals(1, sut.getCount());
        assertTrue(sut.contains(expectedAddress1));

        sut.enhancedGo(expectedAddress2);   //  http://u.ri/2 -> http://u.ri/1 -> null
        assertEquals(2, sut.getCount());
        assertTrue(sut.contains(expectedAddress1));
        assertTrue(sut.contains(expectedAddress2));
        assertEquals(expectedAddress1, sut.enhancedBack());

        sut.enhancedGo(expectedAddress3);   //  http://u.ri/2 -> http://u.ri/3 > http://u.ri/1 -> null
        assertEquals(3, sut.getCount());
        assertTrue(sut.contains(expectedAddress3));
        assertEquals(expectedAddress1, sut.enhancedBack());
    }
    @Test
    public void test_GoGoBackForwardWorksAsExpected() {
        String expectedAddress1 = "http://u.ri/1";
        String expectedAddress2 = "http://u.ri/2";
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
