package handler;

import source.MemorySourcePagesImlementation;

import java.util.LinkedList;
import java.util.List;


//TODO Переписать с помощью streamApi
public class StatePagesHandler {

    private MemorySourcePagesImlementation sourcePages;

    public StatePagesHandler(MemorySourcePagesImlementation sourcePages) {
        this.sourcePages = sourcePages;
    }

    /**
     * @return null if no deleted pages
     */
    public List<String> getDeletedUrls() {
        List<String> yesterdayUrls = new LinkedList<>(sourcePages.getYesterdayUrlsSet());
        List<String> deletedUrls = new LinkedList<>();

        for (String yesterdayUrl : yesterdayUrls) {
            if (!sourcePages.isTodayUrlsContains(yesterdayUrl)) {
                deletedUrls.add(yesterdayUrl);
            }
        }
        return deletedUrls;
    }

    /**
     * @return null if no created pages
     */
    public List<String> getCreatedUrls() {
        List<String> todayUrls = new LinkedList<>(sourcePages.getTodayUrlsSet());
        List<String> createdUrls = new LinkedList<>();

        for (String todayUrl : todayUrls) {
            if (!sourcePages.isYesterdayUrlsContains(todayUrl)) {
                createdUrls.add(todayUrl);
            }
        }
        return createdUrls;
    }

    /**
     * @return null if no updated pages
     */
    public List<String> getUpdatedUrls() {
        List<String> todayUrls = new LinkedList<>(sourcePages.getTodayUrlsSet());
        List<String> updatedUrls = new LinkedList<>();

        for (String todayUrl : todayUrls) {
            if (sourcePages.isYesterdayUrlsContains(todayUrl) &&
                    !(sourcePages.getYesterdayHtmlCode(todayUrl)).equals(sourcePages.getTodayHtmlCode(todayUrl))) {
                updatedUrls.add(todayUrl);
            }
        }
        return updatedUrls;
    }

}
