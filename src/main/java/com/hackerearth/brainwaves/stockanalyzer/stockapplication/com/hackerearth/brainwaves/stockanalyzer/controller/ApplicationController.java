package com.hackerearth.brainwaves.stockanalyzer.stockapplication.com.hackerearth.brainwaves.stockanalyzer.controller;

import com.hackerearth.brainwaves.stockanalyzer.stockapplication.com.hackerearth.brainwaves.stockanalyzer.Service.StockService;
import com.hackerearth.brainwaves.stockanalyzer.stockapplication.com.hackerearth.brainwaves.stockanalyzer.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApplicationController {
   @Autowired
   private StockService stockservice;

    @RequestMapping(value="/",method = RequestMethod.GET)
    public List<Stock> getallStocks(@RequestParam(value = "offset", required = false) String offset) {
        if(offset == null)
            return  stockservice.getAllStocks();
        return  stockservice.getAllStocks(Integer.valueOf(offset));
    }

    @RequestMapping(value="/findby/{searchfield}",method = RequestMethod.GET)
    public List<Stock> getstocksbyFilter(@RequestParam(value = "offset", required = false) String offset,
                                         @RequestParam(value = "fieldvalue") String fieldvalue,
                                         @PathVariable String searchfield) {
        int offst = offset == null ? 0: Integer.valueOf(offset);
        return stockservice.getstocksbyfilter(searchfield,fieldvalue,offst);


    }

}
