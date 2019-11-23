package com.netcracker.edu.trainee.firstLab.service.comparators;

import java.util.Comparator;

public class PersonComparator<T> implements Comparator<T> {

    @Override
    public int compare(T item1, T item2) {
        if (item1.hashCode() > item2.hashCode()) {
            return 1;
        } else if (item1.hashCode() < item2.hashCode())
            return -1;
        else
            return 0;
    }

}