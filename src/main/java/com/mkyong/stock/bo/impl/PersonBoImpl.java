/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mkyong.stock.bo.impl;

import com.mkyong.stock.bo.PersonBo;
import com.mkyong.stock.dao.PersonDao;
import com.mkyong.stock.model.Person;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mehdi
 */
@Service("personBo")
public class PersonBoImpl implements PersonBo {

    @Autowired
    PersonDao personDao;

    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    public void save(Person person) {
        personDao.save(person);
    }

    public void update(Person person) {
        personDao.update(person);
    }

    public void delete(Person person) {
        personDao.delete(person);
    }

    public Person findByPersonId(String personId) {
        return personDao.findByPersonId(personId);
    }
    
    public List<Person> findAllPersons(){
        return personDao.findAllPersons();
    }
}
