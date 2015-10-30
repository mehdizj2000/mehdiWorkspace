/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mkyong.stock.dao.impl;

import com.mkyong.stock.dao.PersonDao;
import com.mkyong.stock.model.Person;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mehdi
 */
@Repository("personDao")
@Transactional 
public class PersonDaoImpl implements PersonDao {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     *
     * @param person
     */
    public void save(Person person) {
        sessionFactory.getCurrentSession().save(person);
    }

    /**
     *
     * @param person
     */
    public void update(Person person) {
        sessionFactory.getCurrentSession().update(person);
    }

    public void delete(Person person) {
        sessionFactory.getCurrentSession().delete(person);
    }

    public Person findByPersonId(String personId) {
        Criteria cr = sessionFactory.getCurrentSession().createCriteria(Person.class);
        cr.add(Restrictions.eq("id", personId));
        return (Person) cr.uniqueResult();
    }
    
    public List<Person> findAllPersons(){
//        Query query = sessionFactory.getCurrentSession().createQuery("from Person");
//        return query.list();
        Criteria cr = sessionFactory.getCurrentSession().createCriteria(Person.class);        
        return cr.list();
    }
}
