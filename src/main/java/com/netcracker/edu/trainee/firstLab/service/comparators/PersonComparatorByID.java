package com.netcracker.edu.trainee.firstLab.service.comparators;

import com.netcracker.edu.trainee.firstLab.entities.Person;

import java.util.Comparator;

public class PersonComparatorByID<T> implements Comparator<T> {

    /**
     * @param item1 - Object of type Person
     * @param item2 - Object of type Person
     * @return 1 if item1 > item2
     *         2 if item1 < item2
     *         0 if they are equal
     */
    @Override
    public int compare(T item1, T item2) {
        int id1 = ((Person) item1).getId();
        int id2 = ((Person) item2).getId();
        if (id1 > id2) {
            return 1;
        } else if (id1 < id2)
            return -1;
        else
            return 0;
    }
}