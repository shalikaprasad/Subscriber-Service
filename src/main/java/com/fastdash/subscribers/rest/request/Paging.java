package com.fastdash.subscribers.rest.request;

import java.io.Serializable;

public class Paging implements Serializable {
    private int PageSize;
    private int CurrentPage;
    private int TotalResults;
    private int TotalPageCount;
    private String SortExpression;
    private boolean SortIsAscending;

    public int getPageSize() {
        return PageSize;
    }

    public void setPageSize(int pageSize) {
        PageSize = pageSize;
    }

    public int getCurrentPage() {
        return CurrentPage;
    }

    public void setCurrentPage(int currentPage) {
        CurrentPage = currentPage;
    }

    public int getTotalResults() {
        return TotalResults;
    }

    public void setTotalResults(int totalResults) {
        TotalResults = totalResults;
    }

    public int getTotalPageCount() {
        return TotalPageCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        TotalPageCount = totalPageCount;
    }

    public String getSortExpression() {
        return SortExpression;
    }

    public void setSortExpression(String sortExpression) {
        SortExpression = sortExpression;
    }

    public boolean isSortIsAscending() {
        return SortIsAscending;
    }

    public void setSortIsAscending(boolean sortIsAscending) {
        SortIsAscending = sortIsAscending;
    }
}
