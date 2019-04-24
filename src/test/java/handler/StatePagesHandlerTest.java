package handler;

import org.junit.Before;
import org.junit.Test;
import source.MemorySourcePages;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class StatePagesHandlerTest {

    private StatePagesHandler statePagesHandler;
    private MemorySourcePages sourcePages;

    @Before
    public void setUp() {
        Map<String, String> todayPagesMap = new HashMap<>();
        Map<String, String> yesterdayPagesMap = new HashMap<>();

        yesterdayPagesMap.put("/a", "a page");
        yesterdayPagesMap.put("/b", "b page");
        yesterdayPagesMap.put("/c", "c page");
        yesterdayPagesMap.put("/e", "e page");

        todayPagesMap.put("/b", "b page modified");
        todayPagesMap.put("/c", "c page");
        todayPagesMap.put("/d", "d page");
        todayPagesMap.put("/e", "e page");

        sourcePages = new MemorySourcePages(todayPagesMap, yesterdayPagesMap);
        statePagesHandler = new StatePagesHandler(sourcePages);
    }

    @Test
    public void testGetDeletedUrls() {
        String[] testDeletedUrls = new String[]{"/a"};
        assertArrayEquals(testDeletedUrls, statePagesHandler.getDeletedUrls().toArray());
    }

    @Test
    public void testGetCreatedUrls() {
        String[] testCreatedUrls = new String[]{"/d"};
        assertArrayEquals(testCreatedUrls, statePagesHandler.getCreatedUrls().toArray());
    }

    @Test
    public void testGetUpdatedUrls() {
        String[] testUpdatedUrls = new String[]{"/b"};
        assertArrayEquals(testUpdatedUrls, statePagesHandler.getUpdatedUrls().toArray());
    }
}