package com.hackerearth.brainwaves.stockanalyzer.stockapplication.com.hackerearth.brainwaves.stockanalyzer.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
@XmlRootElement
public class StockModel<T> {

    private long totalRecords;
    private List<T> stockList;

    public long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<T> getStockList() {
        return stockList;
    }

    public void setStockList(List<T> stockList) {
        this.stockList = stockList;
    }
}
