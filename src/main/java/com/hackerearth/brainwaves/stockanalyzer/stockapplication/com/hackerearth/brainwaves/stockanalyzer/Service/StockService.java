package com.hackerearth.brainwaves.stockanalyzer.stockapplication.com.hackerearth.brainwaves.stockanalyzer.Service;

import com.hackerearth.brainwaves.stockanalyzer.stockapplication.com.hackerearth.brainwaves.stockanalyzer.dao.StockDao;
import com.hackerearth.brainwaves.stockanalyzer.stockapplication.com.hackerearth.brainwaves.stockanalyzer.model.Stock;
import com.hackerearth.brainwaves.stockanalyzer.stockapplication.com.hackerearth.brainwaves.stockanalyzer.model.StockModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {
    @Autowired
    private StockDao<Stock> stockDao;

    public StockModel getAllStocks(){
         return  stockDao.getallStocks();
    }

    public StockModel getAllStocks(int offset){
        return  stockDao.getStocksbyOffset(offset);
    }

    public StockModel getstocksbyfilter(String fieldName,String fieldValue,int offset) {
        return  stockDao.findStockByqueryFilter(fieldName,fieldValue,offset);
    }
}
