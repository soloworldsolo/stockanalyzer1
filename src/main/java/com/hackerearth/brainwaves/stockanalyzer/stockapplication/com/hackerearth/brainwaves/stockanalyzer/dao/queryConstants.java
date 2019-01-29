package com.hackerearth.brainwaves.stockanalyzer.stockapplication.com.hackerearth.brainwaves.stockanalyzer.dao;

import org.hibernate.sql.Select;

public class queryConstants {

    public static final String FIND_ALL_QUERY_TOP_VOLUME = "SELECT * FROM STOCKS  ORDER BY volume";

    public static final String FIND_ALL_STOCKS_FILTER = "SELECT * FROM STOCKS";

    public static final String GET_TOTAL_RECORDS_PRESENT = "SELECT COUNT(id) FROM STOCKS";
}
