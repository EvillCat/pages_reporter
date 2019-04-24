package handler;

import source.MemorySourcePages;

import java.util.LinkedList;
import java.util.List;

public class StatePagesHandler {

    private MemorySourcePages sourcePages;

    public StatePagesHandler(MemorySourcePages sourcePages) {
        this.sourcePages = sourcePages;
    }

    //Возвращает null, если нет удалённых страниц
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

    //Возвращает null, если нет созданных страниц*/
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

    //Возвращает null, если нет обновленных страниц*/
    public List<String> getUpdatedUrls() {
        List<String> todayUrls = new LinkedList<>(sourcePages.getTodayUrlsSet());
        List<String> updatedUrls = new LinkedList<>();

        for (String todayUrl : todayUrls) {
            if (sourcePages.isYesterdayUrlsContains(todayUrl)) {
                if (!(sourcePages.getYesterdayHtmlCode(todayUrl)).equals(sourcePages.getTodayHtmlCode(todayUrl))) {
                    updatedUrls.add(todayUrl);
                }
            }
        }
        return updatedUrls;
    }

}
