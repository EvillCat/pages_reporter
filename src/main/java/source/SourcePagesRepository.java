package source;

import java.util.Set;

public interface SourcePagesRepository {

    String getTodayHtmlCode(String todayUrl);

    boolean isTodayUrlsContains(String yesterdayUrl);

    Set<String> getTodayUrlsSet();

    String getYesterdayHtmlCode(String yesterdayUrl);

    boolean isYesterdayUrlsContains(String todayUrl);

    Set<String> getYesterdayUrlsSet();
}
