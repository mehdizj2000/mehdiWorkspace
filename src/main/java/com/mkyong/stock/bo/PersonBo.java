/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mkyong.stock.bo;

import com.mkyong.stock.model.Person;
import java.util.List;

/**
 *
 * @author mehdi
 */
public interface PersonBo {

    void save(Person person);

    void update(Person person);

    void delete(Person person);

    Person findByPersonId(String personId);
    
    List<Person> findAllPersons();

}
