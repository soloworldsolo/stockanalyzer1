package com.hackerearth.brainwaves.stockanalyzer.stockapplication.com.hackerearth.brainwaves.stockanalyzer.dao;

import com.hackerearth.brainwaves.stockanalyzer.stockapplication.com.hackerearth.brainwaves.stockanalyzer.model.StockModel;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StockDao<T> {
    StockModel getallStocks();
    StockModel getStocksbyOffset(int offset);
    StockModel  findStockByqueryFilter(String fieldName,String stockName,int offset);



}
