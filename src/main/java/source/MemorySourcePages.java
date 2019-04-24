package source;

import java.util.Map;
import java.util.Set;

public class MemorySourcePages {

    private Map<String, String> todayPagesMap;
    private Map<String, String> yesterdayPagesMap;

    public MemorySourcePages(Map<String, String> todayPagesMap, Map<String, String> yesterdayPagesMap) {
        this.todayPagesMap = todayPagesMap;
        this.yesterdayPagesMap = yesterdayPagesMap;
    }

    public String getTodayHtmlCode(String todayUrl) {
        return todayPagesMap.get(todayUrl);
    }

    public boolean isTodayUrlsContains(String yesterdayUrl) {
        return todayPagesMap.containsKey(yesterdayUrl);
    }

    public Set<String> getTodayUrlsSet() {
        return todayPagesMap.keySet();
    }

    public String getYesterdayHtmlCode(String yesterdayUrl) {
        return yesterdayPagesMap.get(yesterdayUrl);
    }

    public boolean isYesterdayUrlsContains(String todayUrl) {
        return yesterdayPagesMap.containsKey(todayUrl);
    }

    public Set<String> getYesterdayUrlsSet() {
        return yesterdayPagesMap.keySet();
    }

}
