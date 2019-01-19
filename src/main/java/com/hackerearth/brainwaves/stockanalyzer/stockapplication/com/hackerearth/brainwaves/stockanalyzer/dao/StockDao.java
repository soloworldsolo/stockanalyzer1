package com.hackerearth.brainwaves.stockanalyzer.stockapplication.com.hackerearth.brainwaves.stockanalyzer.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StockDao<T> {
    List<T> getallStocks();
    List<T> getStocksbyOffset(int offset);
    List<T>  findStockByqueryFilter(String fieldName,String stockName,int offset);



}
