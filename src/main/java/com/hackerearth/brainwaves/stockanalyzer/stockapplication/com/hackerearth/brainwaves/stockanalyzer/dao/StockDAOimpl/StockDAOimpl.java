
package com.hackerearth.brainwaves.stockanalyzer.stockapplication.com.hackerearth.brainwaves.stockanalyzer.dao.StockDAOimpl;

import com.hackerearth.brainwaves.stockanalyzer.stockapplication.com.hackerearth.brainwaves.stockanalyzer.dao.StockDao;
import com.hackerearth.brainwaves.stockanalyzer.stockapplication.com.hackerearth.brainwaves.stockanalyzer.dao.queryConstants;
import com.hackerearth.brainwaves.stockanalyzer.stockapplication.com.hackerearth.brainwaves.stockanalyzer.model.Stock;
import com.hackerearth.brainwaves.stockanalyzer.stockapplication.com.hackerearth.brainwaves.stockanalyzer.model.StockModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;



@Repository
public class StockDAOimpl implements StockDao<Stock> {
    @Autowired
    private SessionFactory sessionfactory;

    /*
      returns the first ten stocks by default
     */
    public StockModel getallStocks() {
        String query = queryConstants.FIND_ALL_QUERY_TOP_VOLUME;
        Session session = getSession();
        NativeQuery queryobject = session.createNativeQuery(query).addEntity(Stock.class);
        queryobject.setFirstResult(0);
        queryobject.setMaxResults(20);
        StockModel stockModel = new StockModel();
        stockModel.setStockList(queryobject.list());
        long count = ((Long)getSession().createQuery("select count(*) from Stock").uniqueResult()).longValue();
        stockModel.setTotalRecords(count);
        return stockModel;
    }

    public StockModel getStocksbyOffset(int offset) {
        int ofset = offset<0 ?0 : offset;
        String query = queryConstants.FIND_ALL_QUERY_TOP_VOLUME;
        NativeQuery queryobj= getSession().createNativeQuery(query).addEntity(Stock.class);
        queryobj.setFirstResult(offset);
        queryobj.setFirstResult(offset);
        queryobj.setMaxResults(20);
        StockModel model = new StockModel();
        model.setStockList(queryobj.list());
        CriteriaQuery<Stock> cr= DaoHelper.getcriteriaQuery(getSession(), Stock.class);
        Query<Stock> hibquery = getSession().createQuery(cr);
        long count = hibquery.getResultList().size();
        model.setTotalRecords(count);
        return model;
    }

    public StockModel findStockByqueryFilter(String fieldName, String fieldValue,int offset) {

       StockModel model = new StockModel();
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaQuery<Stock> cr = cb.createQuery(Stock.class);
        Root<Stock> root = cr.from(Stock.class);
        cr= cr.multiselect(root.get(""),root.get("")).where(cb.equal(root.get(fieldName), fieldValue));
        Query<Stock> hiberqreylist = getSession().createQuery(cr);

        hiberqreylist.setFirstResult(offset);
        hiberqreylist.setMaxResults(20);

        model.setStockList(hiberqreylist.getResultList());
        model.setTotalRecords( getSession().createQuery(cr).getResultList().size());
        return  model;
    }


    private final Session getSession() {
       return sessionfactory.openSession();
    }
}
