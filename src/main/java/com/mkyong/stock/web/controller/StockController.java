/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mkyong.stock.web.controller;

import com.mkyong.stock.bo.PersonBo;
import com.mkyong.stock.bo.StockBo;
import com.mkyong.stock.model.Person;
import com.mkyong.stock.model.Stock;
import static com.mkyong.stock.web.controller.EmpRestURIConstants.LIST_PERSON;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author mehdi
 */
@Controller
public class StockController {
    
    @Autowired
    private StockBo stockBo;
    
    @Autowired
    private PersonBo personBo;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Spring 3 MVC Hello World");
        return "hello";

    }

    @RequestMapping(value = LIST_PERSON, method = RequestMethod.GET)
    public ResponseEntity<List<Person>> printWelcome1() {
        List<Person> persons = personBo.findAllPersons();
        if(persons.isEmpty()){
            return new ResponseEntity<List<Person>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Person>>(persons, HttpStatus.OK);

    }

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public ResponseEntity<List<Stock>> printWelcome1() {
//        List<Stock> stocks = stockBo.findAllStocks();
//        if(stocks.isEmpty()){
//            return new ResponseEntity<List<Stock>>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<List<Stock>>(stocks, HttpStatus.OK);
//
//    }
    
//    @RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
//    public ModelAndView hello(@PathVariable("name") String name) {
//
//        ModelAndView model = new ModelAndView();
//        model.setViewName("hello");
//        model.addObject("msg", name);
//
//        return model;
//
//    }

}
