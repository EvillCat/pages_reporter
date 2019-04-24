package source;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class MemorySourcePagesTest {

    private MemorySourcePages sourcePages;

    @Before
    public void setUp() {
        Map<String, String> todayPagesMap = new HashMap<>();
        Map<String, String> yesterdayPagesMap = new HashMap<>();

        yesterdayPagesMap.put("/home", "some code for home page yesterday");
        yesterdayPagesMap.put("/about", "some code for about page yesterday");

        todayPagesMap.put("/home", "some code for home page");
        todayPagesMap.put("/about", "some code for about page");

        sourcePages = new MemorySourcePages(todayPagesMap, yesterdayPagesMap);
    }

    @Test
    public void testGetTodayHtmlCode() {
        assertEquals("some code for home page", sourcePages.getTodayHtmlCode("/home"));
        assertEquals("some code for about page", sourcePages.getTodayHtmlCode("/about"));
    }

    @Test
    public void testIsTodayUrlsContains() {
        assertTrue(sourcePages.isTodayUrlsContains("/home"));
        assertTrue(sourcePages.isTodayUrlsContains("/about"));
    }

    @Test
    public void testGetTodayUrlsSet() {
        String[] testTodayUrls = new String[]{"/about", "/home"};
        String[] todayUrlsFromMethod = sourcePages.getTodayUrlsSet().toArray(new String[2]);
        assertArrayEquals(testTodayUrls, todayUrlsFromMethod);
    }

    @Test
    public void testGetYesterdayHtmlCode() {
        assertEquals("some code for home page yesterday", sourcePages.getYesterdayHtmlCode("/home"));
        assertEquals("some code for about page yesterday", sourcePages.getYesterdayHtmlCode("/about"));
    }

    @Test
    public void testIsYesterdayUrlsContains() {
        assertTrue(sourcePages.isYesterdayUrlsContains("/home"));
        assertTrue(sourcePages.isYesterdayUrlsContains("/about"));
    }

    @Test
    public void testGetYesterdayUrlsSet() {
        String[] testYesterdayUrls = new String[]{"/about", "/home"};
        String[] yesterdayUrlsFromMethod = sourcePages.getYesterdayUrlsSet().toArray(new String[2]);
        assertArrayEquals(testYesterdayUrls, yesterdayUrlsFromMethod);
    }
}