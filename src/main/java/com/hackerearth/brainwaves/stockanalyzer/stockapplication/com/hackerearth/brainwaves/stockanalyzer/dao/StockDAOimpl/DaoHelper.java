package com.hackerearth.brainwaves.stockanalyzer.stockapplication.com.hackerearth.brainwaves.stockanalyzer.dao.StockDAOimpl;

import com.hackerearth.brainwaves.stockanalyzer.stockapplication.com.hackerearth.brainwaves.stockanalyzer.model.Stock;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Objects;

@Service
public class DaoHelper {

     public  static<T> CriteriaQuery<T>  getcriteriaQuery(Session session, Class<T> clazz) {
         Objects.requireNonNull(session, "session is null");
         Objects.requireNonNull(clazz, "class canpot ber null");
         CriteriaBuilder cb = session.getCriteriaBuilder();
         CriteriaQuery<T> cr = cb.createQuery(clazz);
         return cr;
     }
}
