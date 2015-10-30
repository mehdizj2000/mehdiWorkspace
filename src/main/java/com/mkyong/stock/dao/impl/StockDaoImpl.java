package com.mkyong.stock.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mkyong.stock.dao.StockDao;
import com.mkyong.stock.model.Stock;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Repository("stockDao")
@Transactional
public class StockDaoImpl implements StockDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(Stock stock) {
        sessionFactory.getCurrentSession().save(stock);
    }

    public void update(Stock stock) {
        sessionFactory.getCurrentSession().update(stock);
    }

    public void delete(Stock stock) {
        sessionFactory.getCurrentSession().delete(stock);
    }

    public Stock findByStockCode(String stockCode) {
        Criteria cr = sessionFactory.getCurrentSession().createCriteria(Stock.class);
        cr.add(Restrictions.eq("stockCode", stockCode));
        return (Stock) cr.uniqueResult();
    }
    
    public List<Stock> findAllStocks(){
        Criteria cr = sessionFactory.getCurrentSession().createCriteria(Stock.class);        
        return cr.list();
    }
}
