package com.hackerearth.brainwaves.stockanalyzer.stockapplication.com.hackerearth.brainwaves.stockanalyzer.Service;

import com.hackerearth.brainwaves.stockanalyzer.stockapplication.com.hackerearth.brainwaves.stockanalyzer.dao.StockDao;
import com.hackerearth.brainwaves.stockanalyzer.stockapplication.com.hackerearth.brainwaves.stockanalyzer.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {
    @Autowired
    private StockDao<Stock> stockDao;

    public List<Stock> getAllStocks(){
         return  stockDao.getallStocks();
    }

    public List<Stock> getAllStocks(int offset){
        return  stockDao.getStocksbyOffset(offset);
    }

    public List<Stock> getstocksbyfilter(String fieldName,String fieldValue,int offset) {
        return  stockDao.findStockByqueryFilter(fieldName,fieldValue,offset);
    }
}
