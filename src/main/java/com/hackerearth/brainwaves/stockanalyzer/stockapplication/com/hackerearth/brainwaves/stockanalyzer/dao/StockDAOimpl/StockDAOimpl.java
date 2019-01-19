
package com.hackerearth.brainwaves.stockanalyzer.stockapplication.com.hackerearth.brainwaves.stockanalyzer.dao.StockDAOimpl;

import com.hackerearth.brainwaves.stockanalyzer.stockapplication.com.hackerearth.brainwaves.stockanalyzer.dao.StockDao;
import com.hackerearth.brainwaves.stockanalyzer.stockapplication.com.hackerearth.brainwaves.stockanalyzer.dao.queryConstants;
import com.hackerearth.brainwaves.stockanalyzer.stockapplication.com.hackerearth.brainwaves.stockanalyzer.model.Stock;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class StockDAOimpl implements StockDao<Stock> {
    @Autowired
    private SessionFactory sessionfactory;
    /*
      returns the first ten stocks by default
     */
    public List<Stock> getallStocks() {
        String query = queryConstants.FIND_ALL_QUERY_TOP_VOLUME;

        return getSession().createNativeQuery(query).addEntity(Stock.class).list();
    }

    public List<Stock> getStocksbyOffset(int offset) {
        int ofset = offset<0 ?0 : offset;
        String query = queryConstants.FIND_ALL_QUERY_TOP_VOLUME + " OFFSET " +offset;
        return  getSession().createNativeQuery(query).addEntity(Stock.class).list();
    }

    public List<Stock> findStockByqueryFilter(String fieldName, String fieldValue,int offset) {

        String query = queryConstants.FIND_ALL_STOCKS_FILTER +" " +fieldName+"= :fieldValue";
        if (offset>0)
            query += " offset"+ offset;

        return  getSession().createNativeQuery(query).addEntity(Stock.class)
                .setParameter("fieldValue",fieldValue).
                        list();
    }


    private final Session getSession() {
       return sessionfactory.openSession();
    }
}
