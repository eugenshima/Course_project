package org.example.interfaces;


import org.example.model.Person;

import java.util.ArrayList;

public interface personSQL {
    void RegPerson(Person person);
    Person getPerson(Person person);

    void DelPerson(Person person);


}
