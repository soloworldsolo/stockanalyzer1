package com.hackerearth.brainwaves.stockanalyzer.stockapplication.com.hackerearth.brainwaves.stockanalyzer.dao;

public class queryConstants {

    public static final String FIND_ALL_QUERY_TOP_VOLUME = "SELECT * FROM STOCKS  ORDER BY volume  DESC LIMIT 10";

    public static final String FIND_ALL_STOCKS_FILTER = "SELECT * FROM STOCKS WHERE";
}
