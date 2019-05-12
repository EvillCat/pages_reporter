package source;

import java.util.Map;
import java.util.Set;

/**
 * It's assumed that it should be work with database, but indicated work with memory in the task.
 */
public class MemorySourcePagesImlementation implements SourcePagesRepository {

    private Map<String, String> todayPagesMap;
    private Map<String, String> yesterdayPagesMap;

    public MemorySourcePagesImlementation(Map<String, String> todayPagesMap, Map<String, String> yesterdayPagesMap) {
        this.todayPagesMap = todayPagesMap;
        this.yesterdayPagesMap = yesterdayPagesMap;
    }

    @Override
    public String getTodayHtmlCode(String todayUrl) {
        return todayPagesMap.get(todayUrl);
    }

    @Override
    public boolean isTodayUrlsContains(String yesterdayUrl) {
        return todayPagesMap.containsKey(yesterdayUrl);
    }

    @Override
    public Set<String> getTodayUrlsSet() {
        return todayPagesMap.keySet();
    }

    @Override
    public String getYesterdayHtmlCode(String yesterdayUrl) {
        return yesterdayPagesMap.get(yesterdayUrl);
    }

    @Override
    public boolean isYesterdayUrlsContains(String todayUrl) {
        return yesterdayPagesMap.containsKey(todayUrl);
    }

    @Override
    public Set<String> getYesterdayUrlsSet() {
        return yesterdayPagesMap.keySet();
    }

}
